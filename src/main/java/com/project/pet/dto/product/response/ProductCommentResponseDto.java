package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductCommentResponseDto {
    private int productCommentId;
    private int productId;
    private int userId;
    private String productNameKor;
    private String productImageUrl;
    private String productCommentContent;
    public int productCommentRatingId;
    public int productCommentRatingValue;
    private String createDate;
    private String updateDate;
}
