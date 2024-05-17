package com.project.pet.dto.adoptation.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAdoptationBoardUserCountRespDto {
    private int totalCount;
    private int maxPageNumber;
}
