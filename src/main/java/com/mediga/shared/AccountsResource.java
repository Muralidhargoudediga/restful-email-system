package com.mediga.shared;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface AccountsResource {
    @Get("txt")
    String represent();

    @Post("txt")
    String add(String account);
}
