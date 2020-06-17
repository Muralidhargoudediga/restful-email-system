package com.mediga.shared;

import org.restlet.resource.Get;

public interface RootResource {

    @Get("txt")
    String represent();

}
