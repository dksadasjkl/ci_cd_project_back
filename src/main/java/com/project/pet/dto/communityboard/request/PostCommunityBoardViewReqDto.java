package com.project.pet.dto.communityboard.request;

import com.project.pet.entity.communityBoard.CommunityBoardView;
import lombok.Data;

@Data
public class PostCommunityBoardViewReqDto {

    private int communityBoardId;
    private int userId;

    public CommunityBoardView toEntity() {

        return CommunityBoardView.builder()
                .userId(userId)
                .communityBoardId(communityBoardId)
                .build();
    }
}
