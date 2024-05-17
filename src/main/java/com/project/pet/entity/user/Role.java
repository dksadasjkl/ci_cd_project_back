package com.project.pet.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {

    private int roleId;
    private String roleName;
    private String roleNameKor;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}