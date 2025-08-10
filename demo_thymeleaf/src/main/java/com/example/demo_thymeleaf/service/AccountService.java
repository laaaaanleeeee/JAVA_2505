package com.example.demo_thymeleaf.service;

import com.example.demo_thymeleaf.entity.Account;
import com.example.demo_thymeleaf.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {
    AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(int id) {
        return accountRepository.findById(id);
    }

    public boolean save(Account account) {
        accountRepository.save(account);
        return true;
    }

    public boolean update(Account account) {
        accountRepository.save(account);
        return true;
    }

    public boolean delete(Account account) {
        accountRepository.delete(account);
        return true;
    }
}
