package com.project.pet.dto.communityboard.request;


import com.project.pet.entity.communityBoard.CommunityBoard;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCommunityBoardRequestDto {

    private int communityBoardId;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;

    public CommunityBoard toEntity() {
        return CommunityBoard.builder()
                .communityBoardId(communityBoardId)
                .communityBoardTitle(communityBoardTitle)
                .communityBoardContent(communityBoardContent)
                .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
                .build();
    }

}
