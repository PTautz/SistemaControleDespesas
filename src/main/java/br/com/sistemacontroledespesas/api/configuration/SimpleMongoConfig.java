package br.com.sistemacontroledespesas.api.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

//Essa anotação indica para o Spring que essa é uma classe de configuração
@Configuration
//Classe que define objeto de configuração da aplcação (beans)
public class SimpleMongoConfig {

    //Cria o objeto para abrir a conexão com o banco
    @Bean
    public MongoClient mongo() {
        String urlMongo = System.getenv("URLMongo");
        //Configuração específica do MongoDB para conexão com o banco
        ConnectionString connectionString = new ConnectionString(urlMongo);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), "mongodb-despesas");
    }
}