package com.data.controller;

import com.data.entity.Account;
import com.data.repository.AccountRepository;
import com.data.service.AccountService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountService.getAll();

        return ResponseEntity.ok(accounts);
    }

    @GetMapping("{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(accountService.findByUsername(username));
    }

    @GetMapping("get")
    public ResponseEntity<?> getData2() {
        List<Account> account2 = accountRepository.getData2("lan", "LaanLee");

        return ResponseEntity.ok(account2);
    }

    @PostMapping
    public ResponseEntity<?> postData(@RequestBody Account account) {
        Account saved = accountRepository.save(account);
        return ResponseEntity.ok(saved);
    }

}
