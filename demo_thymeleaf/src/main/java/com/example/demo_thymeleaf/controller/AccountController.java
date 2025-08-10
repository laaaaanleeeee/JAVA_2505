package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.entity.Account;
import com.example.demo_thymeleaf.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;

    @GetMapping("account-list")
    public String findAll(Model model) {
        model.addAttribute("name", "Ngoc");
        model.addAttribute("money", 100000);
        model.addAttribute("address", "Ha Noi");
        model.addAttribute("now", new Date());

        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);

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
}
