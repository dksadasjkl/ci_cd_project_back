package com.project.pet.dto.admin.incomingProduct.request;

import lombok.Data;

@Data
public class GetProductIncomingCountRequestDto {
    private int count;
    private int productSizeCategoryId;
    private String productNameKor;
}
