package com.qburry.kubesspring.springapi.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
