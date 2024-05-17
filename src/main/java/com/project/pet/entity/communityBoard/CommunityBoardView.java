package com.project.pet.entity.communityBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CommunityBoardView {

    private int communityViewId;
    private int communityBoardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int totalViewUserIdCount;

}
