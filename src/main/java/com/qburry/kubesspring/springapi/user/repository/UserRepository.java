package com.qburry.kubesspring.springapi.user.repository;

import com.qburry.kubesspring.springapi.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
