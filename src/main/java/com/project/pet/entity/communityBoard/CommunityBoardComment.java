package com.project.pet.entity.communityBoard;


import com.project.pet.dto.communityboard.response.GetCommunityBoardCommentResponseDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoardComment {
    private int communityBoardCommentId;
    private int communityBoardId;
    private int userId;
    private String communityBoardCommentContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private CommunityBoard communityBoard;
    private User user;

    public GetCommunityBoardCommentResponseDto toGetCommunityBoardCommentResponseDto() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = createDate.toLocalDate();
        String formatCreateDate = date.format(formatter);

        LocalDate update = updateDate.toLocalDate();
        String formatUpdateDate = date.format(formatter);

        return  GetCommunityBoardCommentResponseDto.builder()
                .communityBoardCommentId(communityBoardCommentId)
                .communityBoardId(communityBoardId)
                .userId(user.getUserId())
                .userName(user.getUsername())
                .userNickname(user.getNickname())
                .communityBoardCommentContent(communityBoardCommentContent)
                .createDate(formatCreateDate)
                .updateDate(formatUpdateDate)
                .build();
    }


}
