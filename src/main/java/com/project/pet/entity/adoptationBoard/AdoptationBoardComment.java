package com.project.pet.entity.adoptationBoard;


import com.project.pet.dto.adoptation.response.GetAdoptationBoardCommentRespDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdoptationBoardComment {

    private int adoptationBoardId;
    private int adoptationBoardCommentId;
    private int userId;
    private String adoptationBoardCommentContent;
    private LocalDate createDate;
    private LocalDate updateDate;
    private User user;


    public GetAdoptationBoardCommentRespDto toGetAdoptationBoardCommentRespDto() {
        return GetAdoptationBoardCommentRespDto.builder()
                .adoptationBoardId(adoptationBoardId)
                .adoptationBoardCommentId(adoptationBoardCommentId)
                .userId(userId)
                .username(user.getUsername())
                .userNickname(user.getNickname())
                .adoptationBoardCommentContent(adoptationBoardCommentContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();


    }

}
