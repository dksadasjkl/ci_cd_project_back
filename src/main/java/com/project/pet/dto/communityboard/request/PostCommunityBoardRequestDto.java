package com.project.pet.dto.communityboard.request;


import com.project.pet.entity.communityBoard.CommunityBoard;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

//
public class PostCommunityBoardRequestDto {

  private int userId;
  private String communityBoardTitle;
  private String communityBoardContent;
  private int communityBoardAnimalCategoryId;

  public CommunityBoard toEntity() {

    return  CommunityBoard.builder()
            .userId(userId)
            .communityBoardTitle(communityBoardTitle)
            .communityBoardContent(communityBoardContent)
            .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
            .build();
  }

}
