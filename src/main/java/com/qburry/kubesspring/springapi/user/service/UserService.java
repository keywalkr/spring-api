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

    public Optional<User> findById(Long id){
        return repository.findById(id).map(userMapper::toUser);
    }

    public void saveAll(List<User> users){
        List<UserEntity> userEntities = repository.saveAll(userMapper.toEntities(users));
    }

    public List<User> findAll() {
        return userMapper.toUsers(repository.findAll());
    }
}
