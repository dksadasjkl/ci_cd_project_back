package com.project.pet.dto.adoptation.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAdoptationBoardByUserIdReqDto {
    private int userId;
}
