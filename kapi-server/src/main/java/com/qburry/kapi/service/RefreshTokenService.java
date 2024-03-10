package com.qburry.kapi.service;

import com.qburry.kapi.entitiy.RefreshToken;
import com.qburry.kapi.repository.RefreshTokenRepository;
import com.qburry.kapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = RefreshToken.builder()
                .user(userRepository.findByAccount_Username(username).get())
                .token(UUID.randomUUID().toString())
                .expiration(Instant.now().plusMillis(600000))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return  refreshTokenRepository.findByToken(token);
    }

    public String updateRefreshToken(RefreshToken token){
        RefreshToken refreshToken = token.toBuilder()
                .token(UUID.randomUUID().toString())
                .expiration(Instant.now().plusMillis(600000))
                .build();

        return refreshTokenRepository.save(refreshToken).getToken();

    }

    public void delete(RefreshToken token) {
        refreshTokenRepository.delete(token);
    }
}
