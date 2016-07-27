package com.example.Resources;

import com.example.MongoDBInstance;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


@Path("restaurants")
public class RestaurantsResource {

    private MongoDBInstance mdb;
    private MongoDatabase db;

    public RestaurantsResource() {
        mdb = MongoDBInstance.getInstance();
        db = mdb.getDb();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getAllRestaurants() {

        List<Document> restaurants = db.getCollection("restaurants").find().sort( new Document("restaurant_id", 1) ).into( new ArrayList<Document>() );
        String restaurantsJSON = new Gson().toJson(restaurants);
        return Response.ok(restaurantsJSON).build();
    }

    @GET
    @Path("{restaurant_id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getRestaurant(@PathParam("restaurant_id") String restaurant_id) {

        //TODO: Exception handling to cover the restaurant not being in the DB
        List<Document> restaurant = db.getCollection("restaurants").find( eq("restaurant_id", restaurant_id) ).into( new ArrayList<Document>() );
        String restaurantJSON = new Gson().toJson(restaurant);
        return Response.ok(restaurantJSON).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRestaurant(String restaurant) {

        try {
            MongoCollection coll = db.getCollection("restaurants");
            Document newRestaurant = Document.parse(restaurant);
            coll.insertOne(newRestaurant);
        } catch (Exception e) {
            return Response.notModified().build();
        }

        return Response.ok(restaurant).build();

    }
}
