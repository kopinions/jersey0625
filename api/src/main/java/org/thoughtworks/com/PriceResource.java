package org.thoughtworks.com;

import org.thoughtworks.com.domain.Price;
import org.thoughtworks.com.json.response.PriceJson;
import org.thoughtworks.com.provider.ProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PriceResource {


    private ProductRepository productRepository;

    public PriceResource(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PriceJson getPrice(@PathParam("id") int id) {
        Price price = productRepository.getPriceById(id);
        return new PriceJson();
    }

    @POST
    public Response createProductPrice() {
        return Response.status(201).build();
    }
}
