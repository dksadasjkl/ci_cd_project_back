package com.project.pet.dto.communityboard.request;

import lombok.Data;

@Data
public class GetCommunityBoardPageCountReqDto {
    private int page;
    private int count;
    private int boardAnimalCategoryId;
    private String searchText;
}
