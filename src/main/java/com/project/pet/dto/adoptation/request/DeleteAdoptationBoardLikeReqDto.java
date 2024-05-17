package com.project.pet.dto.adoptation.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteAdoptationBoardLikeReqDto {
    private int adoptationBoardId;
    private int userId;
}
