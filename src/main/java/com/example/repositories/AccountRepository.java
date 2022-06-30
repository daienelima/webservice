package com.example.repositories;

import com.example.dto.Account;

import java.io.IOException;
import java.util.List;

public interface AccountRepository {

    List<Account> findAllAccounts(Integer id) throws IOException, InterruptedException;
}
