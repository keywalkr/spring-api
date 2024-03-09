package com.qburry.kapi.user.service;

import com.qburry.kapi.user.dto.ChangePassword;
import com.qburry.kapi.user.model.AccountEntity;
import com.qburry.kapi.user.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.regex.Pattern.matches;

@Slf4j
@Service
@AllArgsConstructor
public class ChangePasswordService {

    private final AccountRepository accountRepository;

    public void changePassword(ChangePassword changePassword)  {
        accountRepository.findById(changePassword.id()).ifPresentOrElse(account ->{
            account.setPassword(changePassword.newPassword());
            accountRepository.save(account);
        }, () -> log.info("Account does not exit"));

    }

    private AccountEntity map(AccountEntity entity, ChangePassword password) {
        return AccountEntity.builder().build();
    }

    private Boolean checkIfValidOldPassword(String oldPassword, AccountEntity entity) {
        return matches(oldPassword, entity.getPassword());
    }
}
