package com.qburry.kapi.model;

import com.qburry.kapi.user.dto.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class RegistrationRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;
    private Gender gender;
    private String role;
    private String avatar;
    private String username;
    private String password;
}
