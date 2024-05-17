package com.project.pet.dto.adoptation.request;


import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostAdoptationBoardCommentReqDto {
    private int adoptationBoardId;
    private int userId;
    private String adoptationBoardCommentContent;


    public AdoptationBoardComment toEntity() {
        return AdoptationBoardComment.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(userId)
                .adoptationBoardCommentContent(adoptationBoardCommentContent)
                .build();

    }

}
