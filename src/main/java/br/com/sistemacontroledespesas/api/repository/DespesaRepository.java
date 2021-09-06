package br.com.sistemacontroledespesas.api.repository;

import br.com.sistemacontroledespesas.api.domain.Despesa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DespesaRepository extends MongoRepository<Despesa, String> {

}


