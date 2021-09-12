package br.com.sistemacontroledespesas.api.controller;

import br.com.sistemacontroledespesas.api.controller.param.DataFinalInicial;
import br.com.sistemacontroledespesas.api.domain.Despesa;
import br.com.sistemacontroledespesas.api.repository.DespesaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class DespesaController {
    //final define uma constante
    private static final Logger log = LoggerFactory.getLogger(DespesaController.class);

    //Anotação que instancia o objeto automaticamente
    @Autowired
    private DespesaRepository despesaRepository;


    @GetMapping("/obtem-despesa/{valorId}")
    public Despesa obtemDespesa(@PathVariable String valorId) {
        log.info("ID recebido como Parâmetro {}",valorId);

        //chamando método do despesaRepository para buscar a despesa pelo ID
        Optional<Despesa> optionalDespesa = despesaRepository.findById(valorId);
        if (optionalDespesa.isPresent()) {
            Despesa d = optionalDespesa.get();
            log.info("Despesa encontrada foi de: " + d);
            return d;
        } else {
            log.info("Despesa não encontrada");
            return null;
        }
    }

    //(parametro sempre tipo(M) e nome(m)
    @PostMapping("/despesa")
    //RequestBody coloca o corpo(dados) da requisição pra dentro do parâmetro do método
    public void salvarDespesa(@RequestBody Despesa despesa) {
        log.info("Salvando despesa {}",despesa);
        despesaRepository.save(despesa);
    }

    @PostMapping("/obtemlistadespesa")
    //Retorna lista de despesas por data inicial e final
    public List<Despesa> obtemDespesa(@RequestBody DataFinalInicial datas) {

        log.info("Obtendo despesa {}", datas);

        return despesaRepository.findByDataDespesaBetween(datas.getDataInicial(),datas.getDataFinal());

    }
}
