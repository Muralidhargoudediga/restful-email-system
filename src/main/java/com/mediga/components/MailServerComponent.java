package com.mediga.components;

import com.mediga.server.MailServerApplication;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class MailServerComponent extends Component {
    public MailServerComponent() {
        setName("RESTful Mail Server component");
        setDescription("Example for 'Restlet in Action' book");
        setOwner("Restlet SAS");
        setAuthor("The Restlet Team");

        Server server = getServers().add(Protocol.HTTP, 8111);
        server.getContext().getParameters().set("tracing", "true");
        getDefaultHost().attachDefault(new MailServerApplication());
    }

    public static void main(String[] args) throws Exception {
        new MailServerComponent().start();
    }
}
