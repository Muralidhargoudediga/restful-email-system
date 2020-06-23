package com.mediga.components;

import com.mediga.server.MailServerApplication;
import org.restlet.Component;

public class MailServerComponent extends Component {
    public MailServerComponent() {
        setName("RESTful Mail Server component");
        setDescription("Example for 'Restlet in Action' book");
        setOwner("Restlet SAS");
        setAuthor("Muralidhar");

        // Attach the application to the default virtual host
        getDefaultHost().attachDefault(new MailServerApplication());
    }

    public static void main(String[] args) throws Exception {
        new MailServerComponent().start();
    }
}
