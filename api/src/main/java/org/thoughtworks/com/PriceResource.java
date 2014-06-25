package org.thoughtworks.com;

import org.thoughtworks.com.json.response.PriceJson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class PriceResource {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PriceJson getPrice(@PathParam("id") int id) {
        return new PriceJson();
    }
}
