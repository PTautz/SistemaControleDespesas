package br.com.sistemacontroledespesas.api.controller;

import br.com.sistemacontroledespesas.api.controller.param.DataFinalInicial;
import br.com.sistemacontroledespesas.api.domain.Balanco;
import br.com.sistemacontroledespesas.api.domain.Despesa;
import br.com.sistemacontroledespesas.api.domain.Entrada;
import br.com.sistemacontroledespesas.api.repository.DespesaRepository;
import br.com.sistemacontroledespesas.api.repository.EntradaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class BalancoController {

    private final DespesaRepository despesaRepository;
    private final EntradaRepository entradaRepository;
    private static final Logger log = LoggerFactory.getLogger(BalancoController.class);

    @Autowired
    public BalancoController(DespesaRepository despesaRepository, EntradaRepository entradaRepository) {
        this.despesaRepository = despesaRepository;
        this.entradaRepository = entradaRepository;
    }

    @PostMapping("/calculabalanco")
    public Balanco calculaBalanco(@RequestBody DataFinalInicial datas){

        // buscar despesas
        List<Despesa> despesas = despesaRepository.findByDataDespesaBetween(datas.getDataInicial(),datas.getDataFinal());
        log.info("Tamanho da lista de despesas {}",despesas.size());

        // buscar entradas
        List<Entrada> entradas = entradaRepository.findByDataEntradaBetween(datas.getDataInicial(),datas.getDataFinal());
        log.info("Tamanho da lista de entradas {}",entradas.size());

        //Percorrer lista de entradas somando valor
        BigDecimal totalEntradas = new BigDecimal(0);
        if (entradas.size()>0) {
            for (Entrada e : entradas) {
                totalEntradas = totalEntradas.add(e.getValor());

                log.info("Somatório de valor de entradas é de: {}, Entrada atual {}", totalEntradas, e.getValor());
            }
        } else{
            log.info("Não existem entradas nas datas informadas");
        }

        // Percorrer lista de despesa somando valor
        BigDecimal totalDespesas = new BigDecimal(0);
        if (despesas.size()>0) {
            for (Despesa d : despesas) {
                totalDespesas = totalDespesas.add(d.getValor());

                log.info("Somatório de valor de despesas é de: {}, Despesa atual {}", totalDespesas, d.getValor());
            }
        } else {
            log.info("Não existem despesas nas datas informadas");
        }

        // variavel do balanço = entradas - despesas
        BigDecimal valorBalanco;
        valorBalanco = totalEntradas.subtract(totalDespesas);
        var balanco = new Balanco();
        // retornar objeto com o balanco
        balanco.setBalanco(valorBalanco);
        balanco.setTotalEntradas(totalEntradas);
        balanco.setTotalDespesas(totalDespesas);
        log.info("O retorno do método calcula balanço é: {}",balanco);
        return balanco;


    }

}
