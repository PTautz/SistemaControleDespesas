package br.com.sistemacontroledespesas.api.controller;

import br.com.sistemacontroledespesas.api.domain.Despesa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
public class DespesaController {

    @GetMapping("/obtemDespesa")
    public Despesa obtemDespesa() {
        //método que cria objeto para retornar despesa
        Despesa mensal = new Despesa();
        //Usando o 'set' para passar parâmetros de teste
        mensal.setNomeDespesa("Janeiro");
        mensal.setValor(new BigDecimal(700));
        //LocalDateTime para pegar a data atual - now é o método
        mensal.setDataDespesa(LocalDateTime.now());
        return mensal;
    }

}
