package com.project.pet.dto.adoptation.request;


import com.project.pet.entity.adoptationBoard.AdoptationBoard;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateAdoptationBoardReqDto {

    @NotNull //경로 변수 boardId를 저장할 필드 생성
    private int adoptationBoardId;
    @NotBlank
    private String adoptationBoardTitle;
    @NotBlank
    private String adoptationBoardContent;
    @NotNull
    private int boardAnimalCategoryId;

    public AdoptationBoard toEntity() {

        return AdoptationBoard.builder()
                .adoptationBoardId(adoptationBoardId)
                .adoptationBoardTitle(adoptationBoardTitle)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .build();
    }

}
