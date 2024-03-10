package com.qburry.kapi.user.service;

import com.qburry.kapi.user.dto.Account;
import com.qburry.kapi.user.mapper.AccountMapper;
import com.qburry.kapi.user.model.AccountEntity;
import com.qburry.kapi.user.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public List<Account> getAll() {
        return accountMapper.toAccounts(accountRepository.findAll());
    }

    public Long save(Account account) {
        AccountEntity saved = accountRepository.save(accountMapper.toEntity(account));
        return saved.getId();
    }
}
