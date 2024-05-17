package com.project.pet.dto.adoptation.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class GetTop3AdoptationBoardsResDto {
    private int adoptationBoardId;
    private int userId;
    private int totalSum;
    private String username;
    private String userNickname;
    private String adoptationBoardTitle;
    private String adoptationBoardContent;
    private int boardAnimalCategoryId;
    private String boardAnimalCategoryNameKor;
    private int favoriteCount;
    private int viewCount;
    private int commentCount;
    private LocalDate createDate;
    private LocalDate updateDate;
}
