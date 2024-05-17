package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetProductOrdersDetailAdminResponseDto {
    private int productOrderDetailId;
    private int productOrderId;
    private int productId;

}
