package com.example.controller;

import com.example.constants.AppConstants;
import com.example.dto.Account;
import com.example.repositories.AccountRepository;
import com.soap.account.AccountRequest;
import com.soap.account.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Endpoint
public class Controller {

    private final AccountRepository repository;

    @PayloadRoot(namespace = AppConstants.TARGET_NAMESPACE , localPart = AppConstants.LOCAL_PART)
    @ResponsePayload
    public AccountResponse dataload(@RequestPayload AccountRequest accountRequest) throws IOException, InterruptedException {
        return buildResponse(repository.findAllAccounts(accountRequest.getFiltro().getId()));
    }

    private static AccountResponse buildResponse(List<Account> accounts){
        var accountsResponse = new AccountResponse.ListAccounts().getAccount();

        for (Account a: accounts){
           var account = new AccountResponse.ListAccounts.Account();
           account.setAccountNumber(a.getAccountNumber());
           account.setCpf(a.getIban());
           account.setId(a.getId());
           account.setName(a.getName());
           accountsResponse.add(account);
        }
        var response = new AccountResponse();
        response.setListAccounts(response.getListAccounts());
        return response;
    }
}
