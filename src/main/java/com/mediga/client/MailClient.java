package com.mediga.client;

import com.mediga.shared.RootResource;
import org.restlet.resource.ClientResource;

import java.io.IOException;

public class MailClient {
    public static void main(String[] args) throws IOException {
        RootResource mailClient = ClientResource.create("http://localhost:8111/", RootResource.class);
        String result = mailClient.represent();
        System.out.println(result);
    }
}
