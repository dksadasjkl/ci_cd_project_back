package com.project.pet.dto.admin.incomingProduct.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
public class GetProductIncomingStocksResponseDto {

    private int productIncomingStockId;
    private int productId;
    private String productNameKor;
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private int productIncomingStockCount;
}
