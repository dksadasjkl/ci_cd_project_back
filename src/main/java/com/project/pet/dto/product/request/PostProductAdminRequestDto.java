package com.project.pet.dto.product.request;

import com.project.pet.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostProductAdminRequestDto {

    private int userId;
    private String productNameKor;
    private int productPrice;
    private String productImageUrl;
    private int productCategoryId;
    private int productAnimalCategoryId;
    private String productBoardContent;

    public Product toEntity() {
        return Product.builder()
                .userId(userId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productAnimalCategoryId)
                .productAnimalCategoryId(productAnimalCategoryId)
                .productBoardContent(productBoardContent)
                .build();
    }

}
