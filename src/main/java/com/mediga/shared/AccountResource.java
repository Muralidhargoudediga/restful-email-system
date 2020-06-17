package com.mediga.shared;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface AccountResource {
    @Get("txt")
    String represent();

    @Put("txt")
    void store(String account);

    @Delete
    void remove();
}
