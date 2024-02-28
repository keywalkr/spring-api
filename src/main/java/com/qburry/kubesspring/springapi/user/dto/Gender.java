package com.qburry.kubesspring.springapi.user.dto;

import lombok.Getter;

@Getter
public enum Gender {
    FEMALE("F"), MALE("M"), UNDEFINED("U");

    private final String code;

    private Gender(String code){
        this.code = code;
    }

}
