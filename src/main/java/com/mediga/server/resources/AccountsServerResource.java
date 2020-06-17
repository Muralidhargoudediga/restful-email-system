package com.mediga.server.resources;

import com.mediga.shared.AccountsResource;
import org.restlet.resource.ServerResource;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class AccountsServerResource extends ServerResource implements AccountsResource {
    private static final List<String> accounts = new CopyOnWriteArrayList<>();

    @Override
    public String represent() {
        StringBuilder sb = new StringBuilder();

        return accounts.stream().filter(a -> a != null).collect(Collectors.joining("\n"));
    }

    @Override
    public String add(String account) {
        getAccounts().add(account);
        return Integer.toString(getAccounts().indexOf(account));
    }

    public static List<String> getAccounts() {
        return accounts;
    }
}
