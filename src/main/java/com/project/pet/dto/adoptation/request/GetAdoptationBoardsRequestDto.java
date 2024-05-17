package com.project.pet.dto.adoptation.request;

import lombok.Data;

@Data
public class GetAdoptationBoardsRequestDto {
    private int page;
    private int count;
    private String adoptationBoardTitle;
    private int boardAnimalCategoryId;
}
