package com.mediga.restlets;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

public class Tracer extends Restlet {

    public Tracer(Context context) {
        super(context);
    }

    @Override
    public void handle(Request request, Response response) {
        String entity = "Method : " + request.getMethod()
                + "\nResource URI : " + request.getResourceRef()
                + "\nIP Address : " + request.getClientInfo().getAddress()
                +"\nAgent Name : " + request.getClientInfo().getAgentName()
                +"\nAgent Version : " + request.getClientInfo().getAgentVersion();

        response.setEntity(entity, MediaType.TEXT_PLAIN);
    }
}
