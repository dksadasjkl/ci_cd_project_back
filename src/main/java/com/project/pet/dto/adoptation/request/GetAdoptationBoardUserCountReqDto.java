package com.project.pet.dto.adoptation.request;

import lombok.Data;

@Data
public class GetAdoptationBoardUserCountReqDto {
    private int userId;
    private int page;
    private int count;
}
