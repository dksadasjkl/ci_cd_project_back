package com.project.pet.dto.adoptation.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAdoptationBoardCatCountRespDto {
    private int totalCountCat;
    private int maxPageNumberCat;
}
