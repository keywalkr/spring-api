package com.qburry.kubesspring.springapi.user.repository;

import com.qburry.kubesspring.springapi.user.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByUsername(String username);
}
