package com.mediga.client;

import org.restlet.resource.ClientResource;

import java.io.IOException;

public class MailClient {
    public static void main(String[] args) throws IOException {
        ClientResource mailClient = new ClientResource("http://localhost:8111/");
        mailClient.get().write(System.out);
    }
}
