package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductIncomingStockResponseDto;
import com.project.pet.dto.admin.incomingProduct.response.GetProductIncomingStocksResponseDto;
import com.project.pet.dto.product.response.GetProductIncomingStocksTestResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductIncomingStock {

    private int productIncomingStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productIncomingStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private Product product;
    private ProductSizeCategory productSizeCategory;

    public GetProductIncomingStocksResponseDto toGetProductIncomingStocksResponseDto() {
        return GetProductIncomingStocksResponseDto.builder()
                .productIncomingStockId(productIncomingStockId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productIncomingStockCount(productIncomingStockCount)
                .build();
    }

    public GetProductIncomingStockResponseDto toGetProductIncomingStockResponseDto() {
        return GetProductIncomingStockResponseDto.builder()
                .productIncomingStockId(productIncomingStockId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productSizeCategoryNameKor(productSizeCategory.getProductSizeCategoryNameKor())
                .productIncomingStockCount(productIncomingStockCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetProductIncomingStocksTestResponseDto toGetProductIncomingStocksTestResponseDto() {
        return GetProductIncomingStocksTestResponseDto.builder()
                .productIncomingStockId(productIncomingStockId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productSizeCategoryNameKor(productSizeCategory.getProductSizeCategoryNameKor())
                .productIncomingStockCount(productIncomingStockCount)
                .build();
    }

}
