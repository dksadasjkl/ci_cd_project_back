package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductCategoryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategory {
    private int productCategoryId;
    private String productCategoryName;
    private String productCategoryNameKor;

    public GetProductCategoryResponseDto toGetProductCategoryResponseDto() {
        return GetProductCategoryResponseDto.builder()
                .productCategoryId(productCategoryId)
                .productCategoryName(productCategoryName)
                .productCategoryNameKor(productCategoryNameKor)
                .build();
    }
}
