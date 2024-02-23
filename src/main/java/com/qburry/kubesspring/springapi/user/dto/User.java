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
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;
    private String role;
    private String avatar;
    private LocalDateTime emailValidated;
    private LocalDateTime mobileValidated;
    private Account account;
}
