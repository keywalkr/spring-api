package com.qburry.kubesspring.springapi.user.service;

import com.qburry.kubesspring.springapi.user.dto.User;
import com.qburry.kubesspring.springapi.user.mapper.UserMapper;
import com.qburry.kubesspring.springapi.user.model.UserEntity;
import com.qburry.kubesspring.springapi.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Long save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByAccount_Username(String username);

    void saveAll(List<User> users);

    List<User> findAll();
}
