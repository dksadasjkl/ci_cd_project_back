package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductComment;
import lombok.Data;

@Data
public class UpdateProductCommentRequestDto {
    private int productCommentId;
    private int productId;
    private int userId;
    private String productCommentContent;
    private int productCommentRatingId;
    private int productCommentRatingValue;

    public ProductComment toEntity() {
        return ProductComment.builder()
                .productCommentId(productCommentId)
                .productId(productId)
                .userId(userId)
                .productCommentContent(productCommentContent)
                .build();
    }

}
