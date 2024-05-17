package com.project.pet.dto.admin.stockProduct.request;

import lombok.Data;

@Data
public class GetProductStocksAdminRequestDto {
    private int page;
    private int count;
    private int productSizeCategoryId;
    private String productNameKor;
}
