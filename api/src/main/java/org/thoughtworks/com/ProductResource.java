package org.thoughtworks.com;

import org.thoughtworks.com.json.response.ProductJson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/products")
public class ProductResource {


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductJson getProduct(@PathParam("id") int id) {
        return new ProductJson();
    }
}
