package com.project.pet.entity.product;

import com.project.pet.dto.product.response.ProductCommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductComment {

    private int productCommentId;
    private int productId;
    private int userId;
    private String productCommentContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private ProductCommentRating productCommentRating;
    private Product product;

    public ProductCommentResponseDto toProductCommentResponseDto() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = createDate.toLocalDate();
        String formatCreateDate = date.format(formatter);

        LocalDate update = updateDate.toLocalDate();
        String formatUpdateDate = date.format(formatter);

        return ProductCommentResponseDto.builder()
                .productCommentId(productCommentId)
                .productId(productId)
                .userId(userId)
                .productCommentContent(productCommentContent)
                .productNameKor(product.getProductNameKor())
                .productImageUrl(product.getProductImageUrl())
                .productCommentRatingId(productCommentRating.getProductCommentRatingId())
                .productCommentRatingValue(productCommentRating.getProductCommentRatingValue())
                .createDate(formatCreateDate)
                .updateDate(formatUpdateDate)
                .build();
    }
}
