package com.mediga.client;

import com.mediga.shared.AccountResource;
import com.mediga.shared.AccountsResource;
import com.mediga.shared.RootResource;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

import java.io.IOException;

public class MailClientOld {
    public static void main(String[] args) throws IOException {
        System.out.println("\n1) Set up the service client resource\n");
        Client client = new Client(new Context(), Protocol.HTTP);
        ClientResource service = new ClientResource("http://localhost:8111");
        service.setNext(client);

        System.out.println("\n2) Display the root resource\n");
        RootResource mailRoot = service.getChild("/", RootResource.class);
        System.out.println(mailRoot.represent());

        System.out.println("\n3) Display the initial list of accounts\n");
        AccountsResource mailAccounts = service.getChild("/accounts", AccountsResource.class);
        String list = mailAccounts.represent();
        System.out.println(list == null ? "<Empty>\n" : list);

        System.out.println("4) Adds new accounts\n");
        mailAccounts.add("Muralidhar");
        mailAccounts.add("Srinivas");
        mailAccounts.add("Siva");
        System.out.println("Three accounts added !");

        System.out.println("\n5) Display the updated list of accounts\n");
        System.out.println(mailAccounts.represent());

        System.out.println("6) Display the second account\n");
        AccountResource mailAccount = service.getChild("/accounts/1", AccountResource.class);
        System.out.println(mailAccount.represent());

        System.out.println("\n7) Update the individual account and display it again\n");
        mailAccount.store("Srinivas Goud");
        System.out.println(mailAccount.represent());

        System.out.println("\n8) Delete the first account and display the list again\n");
        mailAccount = service.getChild("/accounts/0", AccountResource.class);
        mailAccount.remove();

        System.out.println(mailAccounts.represent());
    }
}
