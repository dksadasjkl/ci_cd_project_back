package com.project.pet.dto.adoptation.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class GetLikedAdoptationBoardByUserIdRespDto {
    private int adoptationBoardId;
    private int userId;
    private String username;
    private String adoptationBoardTitle;
    private String adoptationBoardContent;
    private int boardAnimalCategoryId;
    private String boardAnimalCategoryNameKor;
    private LocalDate createDate;
    private LocalDate updateDate;
}
