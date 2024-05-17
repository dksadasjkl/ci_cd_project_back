package com.project.pet.entity.communityBoard;

import com.project.pet.dto.communityboard.response.GetCommunityBoardFavoriteResponseDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardLikedByUserIdResDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardResponseDto;
import com.project.pet.dto.communityboard.response.GetTop3BoardsResponseDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoard {

    private int communityBoardId;
    private int userId;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;
    private int favoriteCount;
    private int viewCount;
    private int commentCount;
    private int totalSum;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private User user;
    private CommunityBoardAnimalCategory communityBoardAnimalCategory;
    private CommunityBoardView communityBoardView;
    private CommunityBoardFavorite communityBoardFavorite;
    private CommunityBoardComment communityBoardComment;

    public GetCommunityBoardResponseDto toGetCommunityBoardResponseDto () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = createDate.toLocalDate();
        String formatCreateDate = date.format(formatter);

        LocalDate update = updateDate.toLocalDate();
        String formatUpdateDate = date.format(formatter);


     return  GetCommunityBoardResponseDto.builder()
             .communityBoardId(communityBoardId)
             .userId(userId)
             .userName(user.getUsername())
             .userNickname(user.getNickname())
             .communityBoardTitle(communityBoardTitle)
             .communityBoardContent(communityBoardContent)
             .communityBoardAnimalCategoryName(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryName())
             .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
             .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
             .favoriteCount(favoriteCount)
             .viewCount(viewCount)
             .commentCount(commentCount)
             .createDate(formatCreateDate)
             .updateDate(formatUpdateDate)
             .build();
    }

    public GetTop3BoardsResponseDto toGetTop3BoardsResDto () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = createDate.toLocalDate();
        String formatCreateDate = date.format(formatter);

        LocalDate update = updateDate.toLocalDate();
        String formatUpdateDate = date.format(formatter);


        return  GetTop3BoardsResponseDto.builder()
                .communityBoardId(communityBoardId)
                .userId(userId)
                .userName(user.getUsername())
                .userNickname(user.getNickname())
                .communityBoardTitle(communityBoardTitle)
                .communityBoardContent(communityBoardContent)
                .communityBoardAnimalCategoryName(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryName())
                .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
                .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
                .favoriteCount(favoriteCount)
                .viewCount(viewCount)
                .commentCount(commentCount)
                .totalSum(totalSum)
                .createDate(formatCreateDate)
                .updateDate(formatUpdateDate)
                .build();
    }



    public GetCommunityBoardFavoriteResponseDto toGetCommunityBoardFavoriteResponseDto () {
        return  GetCommunityBoardFavoriteResponseDto.builder()
                .communityBoardId(communityBoardId)
                .favoriteCount(favoriteCount)
                .build();
    }


    public GetCommunityBoardLikedByUserIdResDto toGetCommunityBoardLikedByUserIdResDto() {
        return  GetCommunityBoardLikedByUserIdResDto.builder()
                .communityBoardId(communityBoardId)
                .userId(user.getUserId())
                .userName(user.getUsername())
                .communityBoardTitle(communityBoardTitle)
                .communityBoardContent(communityBoardContent)
                .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
                .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
