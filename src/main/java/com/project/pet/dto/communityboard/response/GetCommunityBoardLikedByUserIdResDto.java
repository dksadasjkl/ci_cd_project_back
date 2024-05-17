package com.project.pet.dto.communityboard.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetCommunityBoardLikedByUserIdResDto {

    private int communityBoardId;
    private int userId;
    private String userName;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;
    private String communityBoardAnimalCategoryNameKor;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
