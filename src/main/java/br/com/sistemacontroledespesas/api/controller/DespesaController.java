package br.com.sistemacontroledespesas.api.controller;

import br.com.sistemacontroledespesas.api.domain.Despesa;
import br.com.sistemacontroledespesas.api.repository.DespesaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
public class DespesaController {
    //final define uma constante
    private static final Logger log = LoggerFactory.getLogger(DespesaController.class);

    //Anotação que instancia o objeto automaticamente
    @Autowired
    private DespesaRepository despesaRepository;


    @GetMapping("/obtem-despesa/{valor}")
    public Despesa obtemDespesa(@PathVariable String valor) {
        //metodo que cria objeto para retornar despesa
        Despesa mensal = new Despesa();
        //Usando o 'set' para passar parâmetros de teste
        mensal.setNomeDespesa("Janeiro");
        mensal.setValor(new BigDecimal(700));
        //LocalDateTime para pegar a data atual - now é o método
        mensal.setDataDespesa(LocalDateTime.now());

        //chave recebe o objeto mensal de parâmetro
        log.info("Obtendo Despesa {}",mensal);
        log.info("Obtendo valor {}",valor);
        return mensal;


    }
    //(parametro sempre tipo(M) e nome(m)
    @PostMapping("/despesa")
    //RequestBody coloca o corpo(dados) da requisição pra dentro do parâmetro do método
    public void salvarDespesa(@RequestBody Despesa despesa) {
        log.info("Salvando despesa {}",despesa);
        despesaRepository.save(despesa);
    }
}
