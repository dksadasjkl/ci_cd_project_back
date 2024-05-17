package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductStock;
import lombok.Data;

@Data
public class PostProductStockAdminRequestDto {
    private int productId;
    private int productSizeCategoryId;
    private int productStockCount;

    public ProductStock toEntity() {
        return ProductStock.builder()
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productStockCount(productStockCount)
                .build();
    }
}
