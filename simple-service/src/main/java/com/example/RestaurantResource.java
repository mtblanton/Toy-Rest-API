package com.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Taylor on 7/24/2016.
 */
@Path("restaurants")
public class RestaurantResource {

    //TODO: implement DB connection so that I only start it once
    private MongoClient client = new MongoClient();
    private MongoDatabase db = client.getDatabase("test");
    private MongoCollection<Document> coll = db.getCollection("restaurants");
    private String restaurants = null;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRestaurants() {
        FindIterable<Document> iterable = db.getCollection("restaurants").find();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                restaurants += document;
            }
        });
        //TODO: This returned "Syntax error", figure out what's going on
        return restaurants;
    }
}
