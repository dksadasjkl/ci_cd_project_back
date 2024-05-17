package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductCart;
import lombok.Data;

@Data
public class UpdateProductCartRequestDto {
    private int productId;
    private int productSizeCategoryId;
    private int productCartCount;

    public ProductCart toEntity(int productCartId, int userId) {
        return ProductCart.builder()
                .productCartId(productCartId)
                .productId(productId)
                .userId(userId)
                .productSizeCategoryId(productSizeCategoryId)
                .productCartCount(productCartCount)
                .build();
    }
}
