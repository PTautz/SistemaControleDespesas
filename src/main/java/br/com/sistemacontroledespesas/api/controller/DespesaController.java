package br.com.sistemacontroledespesas.api.controller;

import br.com.sistemacontroledespesas.api.controller.param.DataDespesa;
import br.com.sistemacontroledespesas.api.controller.param.DataFinalInicial;
import br.com.sistemacontroledespesas.api.controller.param.DespesaId;
import br.com.sistemacontroledespesas.api.domain.Despesa;
import br.com.sistemacontroledespesas.api.exception.DadosNaoEncontradosException;
import br.com.sistemacontroledespesas.api.repository.DespesaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.temporal.ChronoUnit;
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
    public Despesa obtemDespesa(@PathVariable String valorId) throws DadosNaoEncontradosException {
        log.info("ID recebido como Parâmetro {}",valorId);

        //chamando método do despesaRepository para buscar a despesa pelo ID
        Optional<Despesa> optionalDespesa = despesaRepository.findById(valorId);
        if (optionalDespesa.isPresent()) {
            Despesa d = optionalDespesa.get();
            log.info("Despesa encontrada foi de: " + d);
            return d;
        } else {
            log.info("Despesa não encontrada");
            throw new DadosNaoEncontradosException("Despesa não encontrada");
        }
    }

    //(parametro sempre tipo(M) e nome(m)
    @PostMapping("/despesa")
    //RequestBody coloca o corpo(dados) da requisição pra dentro do parâmetro do método
    public Despesa salvarDespesa(@RequestBody Despesa despesa) {
        despesaRepository.save(despesa);
        log.info("Salvando despesa {}",despesa);
        return despesa;
    }

    @PostMapping("/obtemlistadespesa")
    //Retorna lista de despesas por data inicial e final
    public List<Despesa> obtemDespesa(@RequestBody DataFinalInicial datas) {

        log.info("Obtendo despesa {}", datas);

        return despesaRepository.findByDataDespesaBetween(datas.getDataInicial(),datas.getDataFinal());

    }

    @DeleteMapping ("/deletadespesa")
    public void deletarDespesa(@RequestBody DespesaId despesaId) {
        log.info("Deletando despesa {}",despesaId);
        despesaRepository.deleteById(despesaId.getDespesaId());
    }
    @PostMapping ("/despesa-recorrente")
    public void recorrencia(@RequestBody DataDespesa dataDespesa) {
        // salvar a primeira despesa
        despesaRepository.save(dataDespesa.getDespesaInical());
        log.info("Número de parcelas {}",dataDespesa.getNumeroDeVezes());

        //laço de repetição para recorrência da despesa
        for (int x = 1; x < dataDespesa.getNumeroDeVezes(); x++) {
            // criar proxima despesa
            Despesa despesa = new Despesa();
            despesa.setValor(dataDespesa.getDespesaInical().getValor());
            despesa.setNomeDespesa(dataDespesa.getDespesaInical().getNomeDespesa());
            //(x = variável de contagem) representação(ChronoUnit) implementa a contagem dos meses na recorrência da despesa
            despesa.setDataDespesa(dataDespesa.getDespesaInical().getDataDespesa().plus(x,ChronoUnit.MONTHS));
            despesaRepository.save(despesa);

        }

    }
}
