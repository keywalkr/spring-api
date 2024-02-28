package com.qburry.kubesspring.springapi.user.dto;

import lombok.Builder;
@Builder
public record ChangePassword(
        Long id,
        String oldPassword,
        String newPassword,
        String reNewPassword
) {
}
