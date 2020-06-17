package com.mediga.shared;

import org.restlet.resource.Get;
import org.restlet.resource.Options;

public interface RootResource {

    @Get("txt")
    String represent();

    @Options("txt")
    String describe();
}
