package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductCart;
import com.project.pet.entity.product.ProductComment;
import com.project.pet.entity.product.ProductOrder;
import lombok.Data;

@Data
public class PostProductCartRequestDto {
    private int userId;
    private int productId;
    private int productSizeCategoryId;
    private int productCartCount;

    public ProductCart toEntity() {
        return ProductCart.builder()
                .userId(userId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productCartCount(productCartCount)
                .build();
    }
}
