package br.com.sistemacontroledespesas.api.controller;

import br.com.sistemacontroledespesas.api.controller.param.DataFinalInicial;
import br.com.sistemacontroledespesas.api.controller.param.EntradaId;
import br.com.sistemacontroledespesas.api.domain.Entrada;
import br.com.sistemacontroledespesas.api.exception.DadosNaoEncontradosException;
import br.com.sistemacontroledespesas.api.repository.EntradaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class EntradaController {
        private static final Logger log = LoggerFactory.getLogger(br.com.sistemacontroledespesas.api.controller.DespesaController.class);

        @Autowired
        private EntradaRepository entradaRepository;


        @GetMapping("/obtem-entrada/{valorId}")
        public Entrada obtemEntrada(@PathVariable String valorId) throws DadosNaoEncontradosException {
            log.info("ID recebido como Parâmetro {}",valorId);

            Optional<Entrada> optionalEntrada = entradaRepository.findById(valorId);
            if (optionalEntrada.isPresent()) {
                Entrada e = optionalEntrada.get();
                log.info("Entrada encontrada foi de: " + e);
                return e;
            } else {
                log.info("Entrada não encontrada");
                throw new DadosNaoEncontradosException("Entrada não encontrada");
            }
        }
        @PostMapping("/entrada")
        public void salvarEntrada(@RequestBody Entrada entrada) {
            log.info("Salvando entrada {}",entrada);
            entradaRepository.save(entrada);
        }

        @PostMapping("/obtemlistaentrada")
        public List<Entrada> obtemEntrada(@RequestBody DataFinalInicial datas) {

            log.info("Obtendo Entrada {}", datas);

            return entradaRepository.findByDataEntradaBetween(datas.getDataInicial(),datas.getDataFinal());

        }
        @DeleteMapping ("/deletaentrada")
        public void deletarEntrada(@RequestBody EntradaId entradaId){
            log.info("Deletando entrada {}",entradaId);
            entradaRepository.deleteById(entradaId.getEntradaId());
        }
}
