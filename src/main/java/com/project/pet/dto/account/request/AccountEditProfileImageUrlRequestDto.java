package com.project.pet.dto.account.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountEditProfileImageUrlRequestDto {
    private String oldProfileImageUrl;
    @NotBlank(message = "공백일 수 없습니다.")
    private String newProfileImageUrl;
}
