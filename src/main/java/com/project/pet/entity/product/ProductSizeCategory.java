package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductAnimalCategoryResponseDto;
import com.project.pet.dto.product.response.GetProductSizeCategoryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSizeCategory {
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private String productSizeCategoryNameKor;


    public GetProductSizeCategoryResponseDto toGetProductSizeCategoryResponseDto(){
        return GetProductSizeCategoryResponseDto.builder()
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategoryName)
                .productSizeCategoryNameKor(productSizeCategoryNameKor)
                .build();
    }
}
