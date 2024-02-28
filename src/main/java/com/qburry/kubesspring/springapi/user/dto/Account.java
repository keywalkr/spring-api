package com.qburry.kubesspring.springapi.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String username;
    private String password;
    private String hash;
    private String salt;
    private LocalDateTime lastLogin;
}
