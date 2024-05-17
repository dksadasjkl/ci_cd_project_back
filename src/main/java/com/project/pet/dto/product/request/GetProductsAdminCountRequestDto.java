package com.project.pet.dto.product.request;

import lombok.Data;

@Data
public class GetProductsAdminCountRequestDto {
    private int page;
    private int count;
    private int productCategoryId;
    private int productAnimalCategoryId;
    private String productNameKor;
}
