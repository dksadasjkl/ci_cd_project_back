package com.project.pet.dto.communityboard.request;

import com.project.pet.entity.communityBoard.CommunityBoard;
import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import lombok.Data;

@Data
public class GetCommunityBoardLikeReqDto {
    private int communityBoardId;
    private int userId;


    public CommunityBoardFavorite toEntity()  {
        return  CommunityBoardFavorite.builder()
                .communityBoardId(communityBoardId)
                .userId(userId)
                .build();
    }

    public CommunityBoard toEntityCommunityBoard()  {
        return  CommunityBoard.builder()
                .communityBoardId(communityBoardId)
                .userId(userId)
                .build();
    }

}
