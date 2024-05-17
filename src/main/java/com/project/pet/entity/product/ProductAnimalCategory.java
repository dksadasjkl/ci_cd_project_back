package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductAnimalCategoryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductAnimalCategory {
    private int productAnimalCategoryId;
    private String productAnimalCategoryName;
    private String productAnimalCategoryNameKor;

    public GetProductAnimalCategoryResponseDto toGetProductAnimalCategoryResponseDto(){
        return GetProductAnimalCategoryResponseDto.builder()
                .productAnimalCategoryId(productAnimalCategoryId)
                .productAnimalCategoryName(productAnimalCategoryName)
                .productAnimalCategoryNameKor(productAnimalCategoryNameKor)
                .build();
    }
}
