package com.project.pet.entity.product;

import com.project.pet.dto.admin.outgoingProduct.response.GetProductOutgoingStocksAdminResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOutgoingStock {
    private int productOutgoingStockId;
    private int productOrderId;
    private int productId;
    private int productSizeCategoryId;
    private int productOutgoingStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private ProductOrder productOrder;
    private Product product;
    private ProductSizeCategory productSizeCategory;

    public GetProductOutgoingStocksAdminResponseDto toGetProductOutgoingStocksAdminResponseDto() {
        return GetProductOutgoingStocksAdminResponseDto.builder()
                .productOutgoingStockId(productOutgoingStockId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productOutgoingStockCount(productOutgoingStockCount)
                .updateDate(updateDate)
                .build();
    }
}
