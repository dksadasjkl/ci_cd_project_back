package com.project.pet.dto.admin.stockProduct.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductStocksCountResponseDto {
    private int totalCount;
    private int maxPageNumber;
}
