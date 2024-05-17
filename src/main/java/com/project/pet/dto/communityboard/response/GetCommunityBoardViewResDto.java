package com.project.pet.dto.communityboard.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetCommunityBoardViewResDto {
    private int communityBoardViewId;
    private int communityBoardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int totalUserIdCount;
}
