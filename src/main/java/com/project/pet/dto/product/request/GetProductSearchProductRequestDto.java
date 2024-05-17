package com.project.pet.dto.product.request;

import lombok.Data;

@Data
public class GetProductSearchProductRequestDto {
    private int page;
    private int count;
    private int productCategoryId;
    private int productAnimalCategoryId;
    private int productId;
    private String searchText;
    private String orderBy;
}
