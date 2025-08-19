package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.dto.PageDTO;
import com.example.demo_thymeleaf.entity.Account;
import com.example.demo_thymeleaf.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;

    @GetMapping("account-list")
    public String findAll(Model model,
                          @PageableDefault(size = 5) Pageable pageable) {

        Page<Account> pAccounts = accountService.findAll(pageable);
        PageDTO pageDTO = new PageDTO();
        pageDTO.setListDTO(pAccounts.getContent());
        pageDTO.setPage(pAccounts.getNumber());
        pageDTO.setTotalPage(pAccounts.getTotalPages());
        pageDTO.setSize(pAccounts.getSize());
        pageDTO.setNumElement(pAccounts.getNumberOfElements());
        pageDTO.setTotalElement(pAccounts.getTotalElements());
        pageDTO.setFirst(pAccounts.isFirst());
        pageDTO.setLast(pAccounts.isLast());
        model.addAttribute("pageDTO", pageDTO);
        return "AccountList";
    }


    @GetMapping("account-delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Account> optionalAccount = accountService.findById(id);

        if(optionalAccount.isEmpty()) {
            return "redirect:/account-list";
        }

        accountService.delete(optionalAccount.get());
        return "redirect:/account-list";
    }

    @GetMapping("account-add")
    public String add() {
        return "AccountAdd";
    }

    @PostMapping("account-save")
    public String save(@RequestParam String username,
                       @RequestParam String password,
                       @RequestParam String fullName) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setFullName(fullName);

        accountService.save(account);
        return "redirect:/account-list";
    }

    @GetMapping("account-edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Account account = accountService.findById(id).get();
        model.addAttribute("account", account);
        return "AccountEdit";
    }

    @PostMapping("account-edit/{id}")
    public String save(@PathVariable int id,
                        @RequestParam String username,
                       @RequestParam String password,
                       @RequestParam String fullName) {
        Account account = accountService.findById(id).get();
        account.setUsername(username);
        account.setPassword(password);
        account.setFullName(fullName);

        accountService.update(account);
        return "redirect:/account-list";
    }
}
