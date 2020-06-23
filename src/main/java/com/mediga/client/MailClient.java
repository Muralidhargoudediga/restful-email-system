package com.mediga.client;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class MailClient {
    public static void main(String[] args) throws Exception {
        ClientResource mailClient = new ClientResource("http://localhost:8111/accounts/chunkylover53/mails/123");
        Representation mailRepresentation = mailClient.get();
        mailClient.put(mailRepresentation);
    }
}
