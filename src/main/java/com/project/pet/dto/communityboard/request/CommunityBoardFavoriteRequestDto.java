package com.project.pet.dto.communityboard.request;


import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import lombok.Data;

@Data
public class CommunityBoardFavoriteRequestDto {
    private int communityBoardId;
    private int userId;

    public CommunityBoardFavorite toEntity() {
        return CommunityBoardFavorite.builder()
                .communityBoardId(communityBoardId)
                .userId(userId)
                .build();
    }
}
