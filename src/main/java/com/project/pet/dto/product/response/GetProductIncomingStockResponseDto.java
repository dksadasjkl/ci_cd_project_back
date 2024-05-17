package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductIncomingStockResponseDto {
    private int productIncomingStockId;
    private int productId;
    private String productNameKor;
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private String productSizeCategoryNameKor;
    private int productIncomingStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
