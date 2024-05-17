package com.project.pet.dto.admin.incomingProduct.request;

import com.project.pet.entity.product.ProductIncomingStock;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PutProductIncomingStockAdminRequestDto {

    private int productIncomingStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productIncomingStockCount;

    public ProductIncomingStock toEntity() {
        return ProductIncomingStock.builder()
                .productIncomingStockId(productIncomingStockId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productIncomingStockCount(productIncomingStockCount)
                .build();
    }

}
