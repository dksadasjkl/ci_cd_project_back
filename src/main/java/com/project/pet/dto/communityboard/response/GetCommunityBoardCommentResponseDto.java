package com.project.pet.dto.communityboard.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCommunityBoardCommentResponseDto {
    private int communityBoardCommentId;
    private int communityBoardId;
    private String userName;
    private String userNickname;
    private int userId;
    private String communityBoardCommentContent;
    private String createDate;
    private String updateDate;

}
