package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductComment;
import lombok.Data;

@Data
public class PostProductCommentsRequestDto {
    private int productId;
    private int userId;
    private String productCommentContent;
    public int productCommentRatingValue;

    public ProductComment toEntity() {
        return ProductComment.builder()
                .productId(productId)
                .userId(userId)
                .productCommentContent(productCommentContent)
                .build();
    }
}
