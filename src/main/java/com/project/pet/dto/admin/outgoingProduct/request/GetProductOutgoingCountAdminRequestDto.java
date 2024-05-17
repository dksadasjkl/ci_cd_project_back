package com.project.pet.dto.admin.outgoingProduct.request;

import lombok.Data;

@Data
public class GetProductOutgoingCountAdminRequestDto {
    private int count;
    private int productSizeCategoryId;
    private String productNameKor;
}
