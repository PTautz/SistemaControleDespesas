package br.com.sistemacontroledespesas.api.repository;

import br.com.sistemacontroledespesas.api.domain.Entrada;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EntradaRepository extends MongoRepository<Entrada, String> {

    List<Entrada> findByDataEntradaBetween(LocalDateTime from, LocalDateTime to);
}
