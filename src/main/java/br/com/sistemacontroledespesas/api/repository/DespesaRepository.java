package br.com.sistemacontroledespesas.api.repository;

import br.com.sistemacontroledespesas.api.domain.Despesa;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface DespesaRepository extends MongoRepository<Despesa, String> {

    //Método que busca despesa por data
    List<Despesa> findByDataDespesaBetween(LocalDateTime from , LocalDateTime to);

}


