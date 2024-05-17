package com.project.pet.dto.adoptation.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetAdoptationFavoriteRespDto {
    private int adoptationFavoriteId;
    private int adoptationBoardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
