package com.mediga.server.resources;

import com.mediga.shared.RootResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RootServerResource extends ServerResource implements RootResource {

    public String represent() throws ResourceException {
        return "Welcome to the " + getApplication().getName() + " !";
    }
}
