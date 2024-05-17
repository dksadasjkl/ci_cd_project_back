package com.project.pet.entity.communityBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoardCommentRating {
    public int communityBoardCommentRatingId;
    public int communityBoardCommentId;
    public int userId;
    public int communityBoardCommentRatingValue;
}
