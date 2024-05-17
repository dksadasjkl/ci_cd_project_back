package com.project.pet.dto.admin.orderProduct.request;

import lombok.Data;

@Data
public class GetProductOrderDetailsAdminCountRequestDto {
    private int count;
    private int productSizeCategoryId;
    private String productNameKor;
}
