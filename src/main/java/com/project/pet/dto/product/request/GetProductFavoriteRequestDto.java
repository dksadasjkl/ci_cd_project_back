package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductFavorite;
import lombok.Data;

@Data
public class GetProductFavoriteRequestDto {
    private int productId;
    private int userId;

    public ProductFavorite toEntity() {
        return ProductFavorite.builder()
                .productId(productId)
                .userId(userId)
                .build();
    }
}
