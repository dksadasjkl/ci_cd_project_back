package com.project.pet.dto.adoptation.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetFindUserResponseDto {
    private int userId;
}
