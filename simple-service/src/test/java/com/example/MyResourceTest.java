package com.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testGetIt() {
        String testResponseString = "[{\"_id\":{\"timestamp\":1469204663,\"machineIdentifier\":10820427,\"processIdentifier\":-11156,\"counter\":1651301},\"address\":{\"building\":\"1007\",\"coord\":[-73.856077,40.848447],\"street\":\"Morris Park Ave\",\"zipcode\":\"10462\"},\"borough\":\"Bronx\",\"cuisine\":\"Bakery\",\"grades\":[{\"date\":\"Mar 2, 2014 6:00:00 PM\",\"grade\":\"A\",\"score\":2},{\"date\":\"Sep 10, 2013 7:00:00 PM\",\"grade\":\"A\",\"score\":6},{\"date\":\"Jan 23, 2013 6:00:00 PM\",\"grade\":\"A\",\"score\":10},{\"date\":\"Nov 22, 2011 6:00:00 PM\",\"grade\":\"A\",\"score\":9},{\"date\":\"Mar 9, 2011 6:00:00 PM\",\"grade\":\"B\",\"score\":14}],\"name\":\"Morris Park Bake Shop\",\"restaurant_id\":\"30075445\"}]";
        String responseMsg = target.path("restaurants/30075445").request().get(String.class);
        assertEquals(testResponseString, responseMsg);
    }
}
