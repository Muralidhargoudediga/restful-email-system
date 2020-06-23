package com.mediga.server;

import com.mediga.server.resources.MailServerSAXResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class MailServerApplication extends Application{

    public MailServerApplication() {
        setName("RESTful Mail Server");
        setDescription("Example for 'Restlet in Action' book");
        setOwner("Restlet SAS");
        setAuthor("The Restlet Team");
    }


    public static void main(String[] args) throws Exception {
        Component mailServer = new Component();
        mailServer.getServers().add(Protocol.HTTP, 8111);
        mailServer.getDefaultHost().attach(new MailServerApplication());
        mailServer.start();
    }


/*
    @Override
    public Restlet createInboundRoot(){
        Tracer tracer = new Tracer(getContext());
        Blocker blocker = new Blocker(getContext());
        //blocker.getBlockedAddresses().add("127.0.0.1"); IPV4 format
        //MAC OS is configured by default to use an IPv6 network stack
        blocker.getBlockedAddresses().add("0:0:0:0:0:0:0:1"); // IPV6 format
        blocker.setNext(tracer);

        Router router = new Router(getContext());
        router.attach("/", RootServerResource.class);
        router.attach("/accounts", AccountsServerResource.class);
        router.attach("/accounts/{accountId}", AccountServerResource.class);

        return router;
    }
*/


    @Override
    public Restlet createInboundRoot(){
        Router router = new Router(getContext());
        router.attach("/accounts/{accountId}/mails/{mailId}", MailServerSAXResource.class);

        return router;
    }
}
