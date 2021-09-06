package br.com.sistemacontroledespesas.api.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

//Essa anotação indica para o Spring que essa é uma classe de configuração
@Configuration
//Classe que define objeto de configuração da aplcação (beans)
public class SimpleMongoConfig {

//trocar senha do mongo na url : colocarsenhaaqui@mongodb-despesas.6phge.mongodb.net
    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://despesas-mongo-user:colocarsenhaaqui@mongodb-despesas.6phge.mongodb.net/mongodb-despesas?retryWrites=true&w=majority");
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