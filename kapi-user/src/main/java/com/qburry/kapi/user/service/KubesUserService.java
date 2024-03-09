package com.qburry.kapi.user.service;

import com.qburry.kapi.user.dto.User;
import com.qburry.kapi.user.mapper.UserMapper;
import com.qburry.kapi.user.model.UserEntity;
import com.qburry.kapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KubesUserService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Long save(User user) {
        log.info("person service save called...");
        UserEntity save = userRepository.save(userMapper.toEntity(user));
        return save.getId();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id).map(userMapper::toUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toUser);
    }

    @Override
    public Optional<User> findByAccount_Username(String username) {
        return userRepository.findByAccount_Username(username).map(userMapper::toUser);
    }

    @Override
    public void saveAll(List<User> users) {
        List<UserEntity> userEntities = userRepository.saveAll(userMapper.toEntities(users));
    }

    @Override
    public List<User> findAll() {
        return userMapper.toUsers(userRepository.findAll());
    }
}
