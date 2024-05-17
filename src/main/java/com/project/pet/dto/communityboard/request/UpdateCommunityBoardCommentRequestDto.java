package com.project.pet.dto.communityboard.request;

import com.project.pet.entity.communityBoard.CommunityBoardComment;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class UpdateCommunityBoardCommentRequestDto {
    private int communityBoardCommentId;
    private int communityBoardId;
    private int userId;
    private String communityBoardCommentContent;


    public CommunityBoardComment toEntity() {

        return CommunityBoardComment.builder()
                .communityBoardCommentId(communityBoardCommentId)
                .communityBoardId(communityBoardId)
                .userId(userId)
                .communityBoardCommentContent(communityBoardCommentContent)
                .build();

    }
}
