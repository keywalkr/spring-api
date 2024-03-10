package com.qburry.kapi.web.user;

import com.qburry.kapi.user.dto.Account;
import com.qburry.kapi.user.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @PutMapping("/update/{account-id}")
    public void updateAccount(@RequestBody Account account){
        accountService.save(account);
    }

}
