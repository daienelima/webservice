package com.example.repositories.impl;

import com.example.dto.Account;
import com.example.repositories.AccountRepository;
import com.example.service.HttpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountRepositoryImpl implements AccountRepository {

    private final HttpService httpService;
    private static final String url = "https://610adb7752d56400176b0013.mockapi.io/testes/account/";

    @Override
    public List<Account> findAllAccounts(Integer id) throws IOException, InterruptedException {
        List<Account> accounts = new ArrayList<>();
        if(id != null){
            accounts = httpService.sendGetReturnList(url, Account.class);
        }else {
            accounts = httpService.sendGetReturnList(url + id, Account.class);
        }
        return accounts;
    }
}
