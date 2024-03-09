package com.qburry.kapi.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;
    private Gender gender;
    private String role;
    private String avatar;
    private LocalDateTime emailValidated;
    private LocalDateTime mobileValidated;
    private Account account;
}
