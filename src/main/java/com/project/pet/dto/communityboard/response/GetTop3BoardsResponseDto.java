package com.project.pet.dto.communityboard.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetTop3BoardsResponseDto {
    private int communityBoardId;
    private int userId;
    private String userName;
    private String userNickname;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;
    private String communityBoardAnimalCategoryName;
    private String communityBoardAnimalCategoryNameKor;
    private int favoriteCount;
    private int viewCount;
    private int commentCount;
    private int totalSum;
    private String createDate;
    private String updateDate;
}
