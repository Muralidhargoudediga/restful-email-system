package com.mediga.server.resources;

import org.restlet.data.Reference;
import org.restlet.ext.xml.SaxRepresentation;
import org.restlet.ext.xml.XmlWriter;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class MailServerSAXResource extends ServerResource {

    @Get
    public Representation toXml(){
        SaxRepresentation result = new SaxRepresentation() {
            @Override
            public void write(XmlWriter writer) throws IOException {
                try {
                    //Start Document
                    writer.startDocument();
                    //Append Root node

                    writer.startElement("mail");

                    //Append child nodes
                    writer.startElement("status");
                    //set text content
                    writer.characters("received");
                    writer.endElement("status");

                    writer.startElement("subject");
                    writer.characters("Message to self");
                    writer.endElement("subject");

                    writer.startElement("content");
                    writer.characters("Doh!");
                    writer.endElement("content");
                    writer.startElement("accountRef"); writer.characters(new Reference(getReference(), "..")
                            .getTargetRef().toString()); writer.endElement("accountRef");

                    writer.endElement("mail");
                    writer.endDocument();

                } catch (SAXException e) {
                    throw new IOException(e);
                }
            }
        };

        return result;
    }

    @Put
    public void store(SaxRepresentation mailRep) throws IOException {
        mailRep.parse(new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if ("status".equals(localName)) {
                    System.out.print("Status: ");
                } else if ("subject".equals(localName)) {
                    System.out.print("Subject: ");
                } else if ("content".equals(localName)) {
                    System.out.print("Content: ");
                } else if ("accountRef".equals(localName)) {
                    System.out.print("Account URI: ");
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println();
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.print(new String(ch, start, length));
            }
        });
    }
}
