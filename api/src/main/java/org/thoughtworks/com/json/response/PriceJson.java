package org.thoughtworks.com.json.response;

import org.thoughtworks.com.domain.Price;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class PriceJson {
    private final UriInfo uriInfo;
    private Price price;

    public PriceJson(UriInfo uriInfo, Price price) {

        this.uriInfo = uriInfo;
        this.price = price;
    }

    public URI getUri() {
        return uriInfo.getAbsolutePathBuilder().build();
    }


    public double getPrice() {
        return price.getPrice();
    }
}
