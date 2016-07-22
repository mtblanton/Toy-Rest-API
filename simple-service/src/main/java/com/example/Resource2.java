package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("resource2")
public class Resource2 {

    private String string;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return string;
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response postString(String inputString) {
        string = inputString;
        return Response.status(200).entity(inputString).build();
    }

    public void setString(String inputString) {
        string = inputString;
    }

    public String getString() {
        return string;
    }
}
