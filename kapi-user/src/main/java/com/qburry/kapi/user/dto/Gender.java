package com.qburry.kapi.user.dto;

import lombok.Getter;

@Getter
public enum Gender {
    FEMALE("F"), MALE("M"), UNDEFINED("U");

    private final String code;

    Gender(String code){
        this.code = code;
    }

}
