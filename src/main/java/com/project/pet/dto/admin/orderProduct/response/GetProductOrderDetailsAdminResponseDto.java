package com.project.pet.dto.admin.orderProduct.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetProductOrderDetailsAdminResponseDto {
    private int productOrderId;
    private String productNameKor;
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private int productOrderCount;
    private String name;
    private String productOrderAddress;
    private String productOrderDetailAddress;
}
