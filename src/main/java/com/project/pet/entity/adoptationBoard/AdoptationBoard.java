package com.project.pet.entity.adoptationBoard;


import com.project.pet.dto.adoptation.response.GetAdoptationBoardRespDto;
import com.project.pet.dto.adoptation.response.GetLikedAdoptationBoardByUserIdRespDto;
import com.project.pet.dto.adoptation.response.GetTop3AdoptationBoardsResDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdoptationBoard {

    private int adoptationBoardId;
    private int userId;
    private String adoptationBoardTitle;
    private String adoptationBoardContent;
    private int boardAnimalCategoryId;
    private int favoriteCount;
    private int viewCount;
    private int commentCount;
    private int totalSum;
    private LocalDate createDate;
    private LocalDate updateDate;


    public User user;
    public AdoptationBoardAnimalCategory adoptationBoardAnimalCategory;
    public AdoptationBoardFavorite adoptationBoardFavorite;
    public AdoptationBoardComment adoptationBoardComment;

    // Entity -> ResponseDto
    public GetAdoptationBoardRespDto toGetAdoptationBoardRespDto () {
        return GetAdoptationBoardRespDto.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(user.getUserId())
                .username(user.getUsername())
                .userNickname(user.getNickname())
                .adoptationBoardTitle(adoptationBoardTitle)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .boardAnimalCategoryNameKor(adoptationBoardAnimalCategory.getBoardAnimalCategoryNameKor())
                .favoriteCount(favoriteCount)
                .viewCount(viewCount)
                .commentCount(commentCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetLikedAdoptationBoardByUserIdRespDto toGetLikedAdoptationBoardByUserIdRespDto () {
        return GetLikedAdoptationBoardByUserIdRespDto.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(user.getUserId())
                .username(user.getUsername())
                .adoptationBoardTitle(adoptationBoardTitle)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .boardAnimalCategoryNameKor(adoptationBoardAnimalCategory.getBoardAnimalCategoryNameKor())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetTop3AdoptationBoardsResDto toGetTop3AdoptationBoardsResDto() {
        return GetTop3AdoptationBoardsResDto.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(user.getUserId())
                .totalSum(totalSum)
                .username(user.getUsername())
                .userNickname(user.getNickname())
                .adoptationBoardTitle(adoptationBoardTitle)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .boardAnimalCategoryNameKor(adoptationBoardAnimalCategory.getBoardAnimalCategoryNameKor())
                .favoriteCount(favoriteCount)
                .viewCount(viewCount)
                .commentCount(commentCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }




}
