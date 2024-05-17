package com.project.pet.dto.product.request;

import lombok.Data;

@Data
public class DeleteProductFavoriteRequestDto {
    private int userId;
    private int productId;
}
