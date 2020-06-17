package com.mediga.server.resources;

import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RootServerResource extends ServerResource {

    @Get("txt")
    public String represent() throws ResourceException {
        return "This is the root resource.";
    }

    @Options("txt")
    public String describe() throws ResourceException {
        throw new RuntimeException("Not Yet Implemented");
    }
}
