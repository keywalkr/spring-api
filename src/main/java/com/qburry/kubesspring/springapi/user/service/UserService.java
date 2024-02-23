package com.qburry.kubesspring.springapi.user.service;

import com.qburry.kubesspring.springapi.user.dto.User;
import com.qburry.kubesspring.springapi.user.mapper.UserMapper;
import com.qburry.kubesspring.springapi.user.model.UserEntity;
import com.qburry.kubesspring.springapi.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public Long save(User user) {
        log.info("person service save called...");
        UserEntity save = repository.save(userMapper.toEntity(user));
        return save.getId();
    }

    public List<User> findAll() {
        return userMapper.toUsers(repository.findAll());
    }
}
