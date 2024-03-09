package com.qburry.kapi.service;

import com.qburry.kapi.model.AuthRequest;
import com.qburry.kapi.model.AuthResponse;
import com.qburry.kapi.model.RegistrationRequest;
import com.qburry.kapi.user.dto.User;
import com.qburry.kapi.user.mapper.UserMapper;
import com.qburry.kapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ServerMapper serverMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long signup(RegistrationRequest request){
        log.info("Sign up user...");

        userRepository.findByAccount_Username(request.getUsername()).ifPresent(
                user1 -> {
                    throw new RuntimeException("User " + user1.getAccount().getUsername() + " already exists!");
                }
        );
        User user = serverMapper.toUser(request);
        return userRepository.save(userMapper.toEntity(user)).getId();
    }

    public AuthResponse authenticate(AuthRequest request) {
        log.info("Authenticate user request...");
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if(authentication.isAuthenticated()){
            return AuthResponse.builder()
                    .accessToken(jwtService.createToken(authentication))
                    .build();
        }else {
            throw new UsernameNotFoundException("invalid user request ...");
        }
    }
}
