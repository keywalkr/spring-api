package com.qburry.kapi.user.service;


import com.qburry.kapi.user.dto.User;

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
