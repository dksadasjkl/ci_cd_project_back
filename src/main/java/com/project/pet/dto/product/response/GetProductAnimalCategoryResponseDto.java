package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetProductAnimalCategoryResponseDto {
    private int productAnimalCategoryId;
    private String productAnimalCategoryName;
    private String productAnimalCategoryNameKor;
}
