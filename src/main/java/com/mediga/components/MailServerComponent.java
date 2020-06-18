package com.mediga.components;

import com.mediga.server.MailServerApplication;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.VirtualHost;

public class MailServerComponent extends Component {
    public MailServerComponent() {
        setName("RESTful Mail Server component");
        setDescription("Example for 'Restlet in Action' book");
        setOwner("Restlet SAS");
        setAuthor("The Restlet Team");

        // Add connectors
        getClients().add(new Client(Protocol.CLAP));
        Server server = new Server(new Context(), Protocol.HTTP, 8111);;
        server.getContext().getParameters().set("tracing", "true");
        getServers().add(server);

        //Configuring default host to match particular requests
        VirtualHost host = getDefaultHost();
        //Regex to match 3 domains - www.rmep.com & www.rmep.net & www.rmep.org
       host.setHostDomain("www\\.rmep\\.com|www\\.rmep\\.net|www\\.rmep\\.org");

        //Regex to match two IP addresses
       host.setServerAddress("1\\.2\\.3\\.10|1\\.2\\.3\\.20");

       host.setServerPort("80");

        // Attach the application to the default virtual host
        host.attachDefault(new MailServerApplication());

        // Configure the log service
        getLogService().setLoggerName("MailServer.AccessLog");
        getLogService().setLogPropertiesRef("clap://system/log.properties");
    }

    public static void main(String[] args) throws Exception {
        new MailServerComponent().start();
    }
}
