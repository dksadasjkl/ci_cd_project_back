package com.project.pet.dto.adoptation.request;

import lombok.Data;

@Data
public class GetAdoptationBoardMyPageReqDto {
    private int userId;
    private int page;
    private int count;
}
