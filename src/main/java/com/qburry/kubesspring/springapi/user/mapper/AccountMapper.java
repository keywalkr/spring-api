package com.qburry.kubesspring.springapi.user.mapper;

import com.qburry.kubesspring.springapi.user.dto.Account;
import com.qburry.kubesspring.springapi.user.model.AccountEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toAccount(AccountEntity entity);
    List<Account> toAccounts(List<AccountEntity> entities);

    AccountEntity toEntity(Account account);
    List<AccountEntity> toEntities(List<Account> accounts);
}
