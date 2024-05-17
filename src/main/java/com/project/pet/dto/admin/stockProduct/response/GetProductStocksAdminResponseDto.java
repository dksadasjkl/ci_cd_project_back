package com.project.pet.dto.admin.stockProduct.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductStocksAdminResponseDto {
    private int productStockId;
    private int productId;
    private String productNameKor;
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private int productStockCount;
}
