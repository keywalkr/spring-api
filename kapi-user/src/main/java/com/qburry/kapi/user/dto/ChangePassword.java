package com.qburry.kapi.user.dto;

import lombok.Builder;
@Builder
public record ChangePassword(
        Long id,
        String oldPassword,
        String newPassword,
        String reNewPassword
) {
}
