package com.qburry.kapi.service;

import com.qburry.kapi.entitiy.RefreshToken;
import com.qburry.kapi.model.AuthRequest;
import com.qburry.kapi.model.AuthResponse;
import com.qburry.kapi.model.RefreshTokenRequest;
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

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;
    private final ServerMapper serverMapper;
    private final UserMapper userMapper;

    public Long signup(RegistrationRequest request) {
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

        if (authentication.isAuthenticated()) {
            return AuthResponse.builder()
                    .accessToken(jwtService.createToken(authentication))
                    .token(refreshTokenService.createRefreshToken(request.getUsername()).getToken())
                    .build();
        } else {
            throw new UsernameNotFoundException("invalid user request ...");
        }
    }

    public AuthResponse refreshToken(RefreshTokenRequest token) {
        return refreshTokenService.findByToken(token.getToken())
                .map(this::verifyRefreshToken)
                .map(RefreshToken::getUser)
                .map(user ->
                        AuthResponse.builder()
                                .accessToken(jwtService.createToken(null))
                                .token(refreshTokenService.updateRefreshToken(null))
                                .build())
                .orElseThrow(() -> new RuntimeException(""));
    }

    private RefreshToken verifyRefreshToken(RefreshToken token) {
        if (token.getExpiration().compareTo(Instant.now()) < 0) {
            refreshTokenService.delete(token);
            throw new RuntimeException(token.getToken() + " was expired");
        }
        return token;
    }
}
