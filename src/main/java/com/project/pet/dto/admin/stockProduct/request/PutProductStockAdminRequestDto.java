package com.project.pet.dto.admin.stockProduct.request;

import com.project.pet.entity.product.ProductStock;
import lombok.Data;

@Data
public class PutProductStockAdminRequestDto {
    private int productStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productStockCount;

    public ProductStock toEntity() {
        return ProductStock.builder()
                .productStockId(productStockId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productStockCount(productStockCount)
                .build();
    }
}
