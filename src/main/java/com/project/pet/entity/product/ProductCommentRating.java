package com.project.pet.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCommentRating {
    public int productCommentRatingId;
    public int productCommentId;
    public int userId;
    public int productCommentRatingValue;
}
