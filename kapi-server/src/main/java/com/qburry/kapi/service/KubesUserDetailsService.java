package com.qburry.kapi.service;

import com.qburry.kapi.model.UserInfoDetails;
import com.qburry.kapi.user.mapper.UserMapper;
import com.qburry.kapi.user.model.UserEntity;
import com.qburry.kapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class KubesUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Entering in loadUserByUsername Method...");

        Optional<UserEntity> userEntity = userRepository.findByAccount_Username(username);

        return userEntity
                .map(userMapper::toUser)
                .map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found "));
    }


}
