package me.aboullaite.flighttracker.config;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class MongoDbReactiveConfig extends AbstractReactiveMongoConfiguration {
    @Override
    public MongoClient reactiveMongoClient() {
        String value = System.getenv("DATABASE_HOSTNAME");
        if (value != null) {
            return MongoClients.create("mongodb://" + value);
        } else {
            return MongoClients.create();
        }
    }

    @Override
    protected String getDatabaseName() {
        return "aircraft-db";
    }
}
