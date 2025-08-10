package com.data.service;

import com.data.entity.Account;
import com.data.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAll() {
        List<Account> accounts = accountRepository.findAll();

        return accounts;
    }


    public List<Account> findByUsername(String username) {
        List<Account> accounts = accountRepository.findByUsername(username);

        return accounts;
    }
}
