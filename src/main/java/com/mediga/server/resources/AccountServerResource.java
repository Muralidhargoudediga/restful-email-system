package com.mediga.server.resources;

import com.mediga.shared.AccountResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class AccountServerResource extends ServerResource implements AccountResource {
    private int accountId;

    @Override
    protected void doInit() throws ResourceException {
        this.accountId = Integer.parseInt(getAttribute("accountId"));
    }

    @Override
    public String represent() {
        return AccountsServerResource.getAccounts().get(accountId);
    }

    @Override
    public void store(String account) {
        AccountsServerResource.getAccounts().set(accountId, account);
    }

    @Override
    public void remove() {
        AccountsServerResource.getAccounts().remove(accountId);
    }
}
