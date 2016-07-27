package com.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Taylor on 7/25/2016.
 */
public class MongoDBInstance {
    private MongoClient client;
    private MongoDatabase db;

    private static MongoDBInstance mongoDbInstance;

    private static final String dbHost = "localhost";
    private static final String dbName = "test";

    private MongoDBInstance(){}

    public static MongoDBInstance getInstance() {
        if(mongoDbInstance == null) {
            mongoDbInstance = new MongoDBInstance();
        }
        return mongoDbInstance;
    }

    public MongoDatabase getDb() {
        if(client == null) {
            try {
                client = new MongoClient(dbHost);
            } catch(Exception e) {
                return null;
            }
        }
        if (db == null) {
            db = client.getDatabase(dbName);
        }
        return db;
    }
}
