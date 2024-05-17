package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductOrdersResponseDto {
    private int productOrderId;
    private int productId;
    private String productNameKor;
    private int productPrice;
    private String productImageUrl;
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private String productSizeCategoryNameKor;
    private int productOrderCount;
    private int userId;
    private String username;
    private String productOrderAddress;
    private String productDetailOrderAddress;
    private String createDate;
    private LocalDateTime updateDate;
}
