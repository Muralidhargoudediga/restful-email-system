package com.mediga.server.resources;

import org.restlet.data.Reference;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;

public class MailServerResource extends ServerResource {

    @Get
    public Representation toXml() throws IOException {
        DomRepresentation result = new DomRepresentation();
        result.setIndenting(true);

        Document document = result.getDocument();

        Node mailElt = document.createElement("mail");
        document.appendChild(mailElt);

        Node statusElt = document.createElement("status");
        statusElt.setTextContent("received");
        mailElt.appendChild(statusElt);

        Node subjectElt = document.createElement("subject");
        subjectElt.setTextContent("Message to self");
        mailElt.appendChild(subjectElt);

        Node contentElt = document.createElement("content");
        contentElt.setTextContent("Doh!");
        mailElt.appendChild(contentElt);

        Node accountRef = document.createElement("accountRef");
        accountRef.setTextContent(new Reference(getReference(), "..").getTargetRef().toString());
        mailElt.appendChild(accountRef);

        return result;
    }

    @Put
    public void store(DomRepresentation mailRep) throws IOException {
        Document document = mailRep.getDocument();
        Element mailElt = document.getDocumentElement();
        Element statusElt = (Element) mailElt.getElementsByTagName("status").item(0);
        Element subjectElt = (Element) mailElt.getElementsByTagName("subject").item(0);
        Element contentElt = (Element) mailElt.getElementsByTagName("content").item(0);
        Element accountRefElt = (Element) mailElt.getElementsByTagName("accountRef").item(0);

        System.out.println("Status: " + statusElt.getTextContent());
        System.out.println("Subject: " + subjectElt.getTextContent());
        System.out.println("Content: " + contentElt.getTextContent());
        System.out.println("Account URI: " + accountRefElt.getTextContent());
    }
}
