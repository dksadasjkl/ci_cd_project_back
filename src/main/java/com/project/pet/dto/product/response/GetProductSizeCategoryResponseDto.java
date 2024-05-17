package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetProductSizeCategoryResponseDto {
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private String productSizeCategoryNameKor;
}
