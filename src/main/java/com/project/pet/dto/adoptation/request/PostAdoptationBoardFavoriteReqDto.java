package com.project.pet.dto.adoptation.request;


import com.project.pet.entity.adoptationBoard.AdoptationBoardFavorite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostAdoptationBoardFavoriteReqDto {

    private int adoptationBoardId;
    private int userId;


    public AdoptationBoardFavorite toEntity() {
        return AdoptationBoardFavorite.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(userId)
                .build();
    }
}
