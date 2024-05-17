package com.project.pet.dto.adoptation.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAdoptationBoardDogCountRespDto {
    private int totalCountDog;
    private int maxPageNumberDog;
}
