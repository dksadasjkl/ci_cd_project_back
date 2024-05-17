package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductStockAdminResponseDto;
import com.project.pet.dto.admin.stockProduct.response.GetProductStocksAdminResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStock {
    private int productStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private Product product;
    private ProductSizeCategory productSizeCategory;

    public GetProductStocksAdminResponseDto toGetProductStocksResponseDto() {
        return GetProductStocksAdminResponseDto.builder()
                .productStockId(productStockId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productStockCount(productStockCount)
                .build();
    }

    public GetProductStockAdminResponseDto toGetProductStockAdminResponseDto() {
        return GetProductStockAdminResponseDto.builder()
                .productStockId(productStockId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryNameKor(product.getProductNameKor())
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productSizeCategoryNameKor(productSizeCategory.getProductSizeCategoryNameKor())
                .productStockCount(productStockCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
