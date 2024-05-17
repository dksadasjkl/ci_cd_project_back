package com.project.pet.dto.admin.outgoingProduct.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductOutgoingStocksAdminResponseDto {
    private int productOutgoingStockId;
    private String productNameKor;
    private String productSizeCategoryName;
    private int productOutgoingStockCount;
    private LocalDateTime updateDate;
}
