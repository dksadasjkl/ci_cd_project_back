package com.project.pet.dto.adoptation.request;


import lombok.Builder;
import lombok.Data;

@Data
public class GetAdoptationBoardDogCountReqDto {
    private int page;
    private int count;
}
