package com.project.pet.dto.admin.incomingProduct.request;

import com.project.pet.entity.product.ProductStock;
import lombok.Data;

@Data
public class PutProductIncomingCheckAdminRequestDto {
    private int productIncomingStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productIncomingStockCount;

    public ProductStock toEntity() {
        return ProductStock.builder()
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productStockCount(productIncomingStockCount)
                .build();
    }
}
