package com.mediga;

import com.mediga.filters.Blocker;
import com.mediga.restlets.Tracer;
import org.restlet.*;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;

public class MailServerApplication extends Application{

    public MailServerApplication() {
        setName("RESTful Mail Server");
        setDescription("Example for 'Restlet in Action' book");
        setOwner("Restlet SAS");
        setAuthor("The Restlet Team");
    }

    public static void main(String[] args) throws Exception {
        Server mailServer = new Server(Protocol.HTTP, 8111);
        mailServer.setNext(new MailServerApplication());
        mailServer.start();
    }

    @Override
    public Restlet createInboundRoot(){
        Blocker blocker = new Blocker(getContext());
        //blocker.getBlockedAddresses().add("127.0.0.1"); IPV4 format
        //MAC OS is configured by default to use an IPv6 network stack
        blocker.getBlockedAddresses().add("0:0:0:0:0:0:0:1"); // IPV6 format
        blocker.setNext(new Tracer(getContext()));
        return blocker;
    }
}
