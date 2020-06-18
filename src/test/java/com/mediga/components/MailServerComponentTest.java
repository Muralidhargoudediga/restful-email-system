package com.mediga.components;

import junit.framework.TestCase;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;

public class MailServerComponentTest extends TestCase {

    //We cannot access the domain www.rmep.org from web browser as we have not purchased it. So we are writing a JUnit Testcase.
    public void testVirtualHost(){
        MailServerComponent component = new MailServerComponent();

        Request request = new Request();
        request.setMethod(Method.GET);
        request.setResourceRef("http://www.rmep.org/accounts");
        request.setHostRef("http://www.rmep.org");
        Response response = new Response(request);
        response.getServerInfo().setAddress("1.2.3.20");
        response.getServerInfo().setPort(80);
        component.handle(request, response);

        assertTrue(response.getStatus().isSuccess());
    }
}