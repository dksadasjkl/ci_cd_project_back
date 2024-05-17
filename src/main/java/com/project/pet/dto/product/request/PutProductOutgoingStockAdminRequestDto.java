package com.project.pet.dto.product.request;


import com.project.pet.entity.product.ProductOutgoingStock;
import lombok.Data;

@Data
public class PutProductOutgoingStockAdminRequestDto {
    private int productOutgoingStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productOutgoingStockCount;

    public ProductOutgoingStock toEntity() {
        return ProductOutgoingStock.builder()
                .productOutgoingStockId(productOutgoingStockId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productOutgoingStockCount(productOutgoingStockCount)
                .build();
    }
}
