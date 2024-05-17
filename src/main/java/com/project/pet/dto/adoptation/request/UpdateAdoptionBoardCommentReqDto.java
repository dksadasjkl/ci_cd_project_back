package com.project.pet.dto.adoptation.request;

import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import lombok.Data;

@Data
public class UpdateAdoptionBoardCommentReqDto {
    private int adoptationBoardCommentId;
    private String adoptationBoardCommentContent;

    public AdoptationBoardComment toEntity() {
        return AdoptationBoardComment.builder()
                .adoptationBoardCommentId(adoptationBoardCommentId)
                .adoptationBoardCommentContent(adoptationBoardCommentContent)
                .build();
    }
}
