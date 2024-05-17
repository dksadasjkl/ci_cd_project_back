package com.project.pet.dto.admin.stockProduct.request;

import lombok.Data;

@Data
public class GetProductStocksCountRequestDto {
    private int count;
    private int productSizeCategoryId;
    private String productNameKor;
}
