package com.project.pet.dto.admin.outgoingProduct.request;

import lombok.Data;

@Data
public class GetProductOutgoingStocksAdminRequestDto {
    private int page;
    private int count;
    private int productSizeCategoryId;
    private String productNameKor;
}
