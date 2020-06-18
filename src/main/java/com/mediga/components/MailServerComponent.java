package com.mediga.components;

import com.mediga.server.MailServerApplication;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.VirtualHost;

public class MailServerComponent extends Component {
    public MailServerComponent() {
        setName("RESTful Mail Server component");
        setDescription("Example for 'Restlet in Action' book");
        setOwner("Restlet SAS");
        setAuthor("The Restlet Team");

        Server server = getServers().add(Protocol.HTTP, 8111);
        server.getContext().getParameters().set("tracing", "true");

        //Configuring default host to match particular requests
        VirtualHost host = getDefaultHost();
        //Regex to match 3 domains - www.rmep.com & www.rmep.net & www.rmep.org
        host.setHostDomain("www\\.rmep\\.com|www\\.rmep\\.net|www\\.rmep\\.org");

        //Regex to match two IP addresses
        host.setServerAddress("1\\.2\\.3\\.10|1\\.2\\.3\\.20");

        host.setServerPort("80");
        host.attachDefault(new MailServerApplication());
    }

    public static void main(String[] args) throws Exception {
        new MailServerComponent().start();
    }
}
