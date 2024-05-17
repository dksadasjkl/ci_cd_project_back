package com.project.pet.entity.adoptationBoard;


import com.project.pet.dto.adoptation.response.GetAdoptationFavoriteRespDto;
import com.project.pet.dto.adoptation.response.GetFindUserResponseDto;
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
public class AdoptationBoardFavorite {

    private int adoptationFavoriteId;
    private int adoptationBoardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public GetAdoptationFavoriteRespDto toGetAdoptationFavoriteRespDto() {
        return GetAdoptationFavoriteRespDto.builder()
                .adoptationFavoriteId(adoptationFavoriteId)
                .adoptationBoardId(adoptationBoardId)
                .userId(userId)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetFindUserResponseDto toGetFindUserResponseDto() {
        return GetFindUserResponseDto.builder()
                .userId(userId)
                .build();
    }

}
