package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductCartResponseDto {
    private int productCartId;
    private int userId;
    private int productId;
    private int productSizeCategoryId;
    private int productCartCount;
    private int productOrderId;
    private String productOrderAddress;
    private String productOrderDetailAddress;
    private int productOrderCount;
    private String productNameKor;
    private int productPrice;
    private String productImageUrl;
}
