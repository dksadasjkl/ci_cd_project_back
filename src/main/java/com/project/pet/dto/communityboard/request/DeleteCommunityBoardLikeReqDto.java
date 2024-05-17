package com.project.pet.dto.communityboard.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteCommunityBoardLikeReqDto {
    private int communityBoardId;
    private int userId;
}
