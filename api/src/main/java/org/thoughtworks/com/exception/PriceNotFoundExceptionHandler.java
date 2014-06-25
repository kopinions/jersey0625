package org.thoughtworks.com.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PriceNotFoundExceptionHandler implements ExceptionMapper<PriceNotFoundException> {
    @Override
    public Response toResponse(PriceNotFoundException exception) {
        return Response.status(404).build();
    }
}
