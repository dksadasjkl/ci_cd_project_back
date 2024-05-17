package com.project.pet.dto.adoptation.request;

import lombok.Data;

@Data
public class GetAdoptationBoardCountReqDto {
    private int count;
    private String adoptationBoardTitle;
    private int boardAnimalCategoryId;
}
