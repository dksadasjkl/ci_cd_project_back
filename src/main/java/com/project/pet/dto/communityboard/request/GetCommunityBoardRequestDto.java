package com.project.pet.dto.communityboard.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

// 단건 조회 요청.
public class GetCommunityBoardRequestDto {

    private int communityBoardId;

}
