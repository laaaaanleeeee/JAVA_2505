package com.example.demo.controller;

import com.example.demo.dto.AccountCreateDto;
import com.example.demo.dto.AccountUpdateDto;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepo;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountRepo.findAll();

        return ResponseEntity.ok(accounts);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        // op account: có thể có or không
        Optional<Account> opAccount = accountRepo.findById(id);
        // check empty
        if(opAccount.isEmpty()) {
            return new ResponseEntity<>("ID not found, id = " + id, HttpStatus.BAD_REQUEST);
        }
        else {
            Account account = opAccount.get();
            return ResponseEntity.ok(account);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Account> opAccount = accountRepo.findById(id);

        if(opAccount.isEmpty()) {
            return new ResponseEntity<>("ID not found, id = " + id, HttpStatus.BAD_REQUEST);
        }

        Account account = opAccount.get();
        accountRepo.delete(account);

        return ResponseEntity.ok("Delete account success, username = " + account.getUsername());
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountCreateDto accountCreateDto) {
        Account account = new Account();
        account.setUsername(accountCreateDto.getUsername());
        account.setPassword(accountCreateDto.getPassword());
        account.setFullName(accountCreateDto.getFullName());
        account.setEmail(accountCreateDto.getEmail());
        account.setPhone(accountCreateDto.getPhone());

        // save: Account(id=null) => create
        // save: Account(id=1 or ...) => update
        accountRepo.save(account);

        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody AccountUpdateDto accountUpdateDto) {
        Optional<Account> opAccount = accountRepo.findById(id);

        if(opAccount.isEmpty()) {
            return new ResponseEntity<>("ID not found, id = " + id, HttpStatus.BAD_REQUEST);
        }

        Account account = new Account();
        account.setUsername(accountUpdateDto.getUsername());
        account.setPassword(accountUpdateDto.getPassword());
        account.setFullName(accountUpdateDto.getFullName());
        account.setEmail(accountUpdateDto.getEmail());
        account.setPhone(accountUpdateDto.getPhone());

        accountRepo.save(account);

        return new ResponseEntity<>("Update account success, id = " + account.getId(), HttpStatus.OK);

    }
}
