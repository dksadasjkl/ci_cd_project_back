package com.project.pet.dto.communityboard.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


// 게시판 작성 단건(get) 응답
@Data
@Builder
public class GetCommunityBoardResponseDto {
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
    private String createDate;
    private String updateDate;
}
