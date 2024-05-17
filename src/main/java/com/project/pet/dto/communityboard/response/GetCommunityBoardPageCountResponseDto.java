package com.project.pet.dto.communityboard.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCommunityBoardPageCountResponseDto {
    private int totalCount;
    private int maxPageNumber;
}
