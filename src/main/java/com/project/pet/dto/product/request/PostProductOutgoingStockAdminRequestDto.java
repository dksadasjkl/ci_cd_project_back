package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductOutgoingStock;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostProductOutgoingStockAdminRequestDto {
    private int productId;
    private int productSizeCategoryId;
    private int productOutgoingStockCount;

    public ProductOutgoingStock toEntity() {
        return ProductOutgoingStock.builder()
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productOutgoingStockCount(productOutgoingStockCount)
                .build();
    }
}
