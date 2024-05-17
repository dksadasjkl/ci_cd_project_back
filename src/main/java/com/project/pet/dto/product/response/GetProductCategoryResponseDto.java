package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductCategoryResponseDto {
    private int productCategoryId;
    private String productCategoryName;
    private String productCategoryNameKor;
}
