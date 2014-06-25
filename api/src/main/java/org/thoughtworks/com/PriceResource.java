package org.thoughtworks.com;

import org.thoughtworks.com.domain.Price;
import org.thoughtworks.com.domain.Product;
import org.thoughtworks.com.json.request.CreatePriceJson;
import org.thoughtworks.com.json.response.PriceJson;
import org.thoughtworks.com.provider.ProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PriceResource {


    private ProductRepository productRepository;
    private Product product;

    public PriceResource(ProductRepository productRepository, Product product) {

        this.productRepository = productRepository;
        this.product = product;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PriceJson getPrice(@PathParam("id") int id) {
        Price price = productRepository.getPriceById(id);
        return new PriceJson();
    }

    @POST
    public Response createProductPrice(CreatePriceJson createPriceJson) {
        productRepository.createProductPrice(product, createPriceJson.createPrice());
        return Response.status(201).build();
    }
}
