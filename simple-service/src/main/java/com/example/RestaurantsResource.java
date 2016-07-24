package com.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.mongodb.client.model.Filters.eq;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("restaurants/{restaurant_id}")
public class RestaurantsResource {

    private MongoClient client = new MongoClient();
    private MongoDatabase db = client.getDatabase("test");
    private MongoCollection<Document> coll = db.getCollection("restaurants");

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRestaurant(@PathParam("restaurant_id") String restaurant_id) {
        MongoCursor<Document> cur = coll.find( eq("restaurant_id", restaurant_id)).iterator();
        String restaurantList = null;
        try {
            while (cur.hasNext()) {
                restaurantList += cur.next().toJson() + "\n";
            }
        } catch(Exception e) {

        } finally {
            cur.close();
        }
        return restaurantList;
    }
}
