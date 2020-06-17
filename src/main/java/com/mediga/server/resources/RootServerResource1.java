package com.mediga.server.resources;

import com.mediga.shared.RootResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RootServerResource1 extends ServerResource implements RootResource {

    public String represent() throws ResourceException {
        return "This is the root resource1.";
    }

    public String describe() throws ResourceException {
        throw new RuntimeException("Not Yet Implemented");
    }
}
