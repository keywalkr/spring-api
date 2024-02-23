package com.qburry.kubesspring.springapi.user.controller;

import com.qburry.kubesspring.springapi.user.dto.Account;
import com.qburry.kubesspring.springapi.user.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    List<Account> getAllAccounts() {
        return accountService.getAll();
    }

    @PutMapping("/update/{account-id}")
    public void updateAccount(@RequestBody Account account){
        accountService.save(account);
    }

}
