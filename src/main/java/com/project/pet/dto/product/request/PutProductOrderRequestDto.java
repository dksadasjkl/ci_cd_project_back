package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductOrder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PutProductOrderRequestDto {
    private int productOrderId;
    @NotBlank(message = "배송지를 입력해주세요")
    private String productOrderAddress;
    @NotBlank(message = "상세주소를 입력해주세요")
    private String productDetailOrderAddress;
    private int productSizeCategoryId;
    private int productOrderCount;

    public ProductOrder toEntity() {
        return ProductOrder.builder()
                .productOrderId(productOrderId)
                .productOrderAddress(productOrderAddress)
                .productOrderDetailAddress(productDetailOrderAddress)
                .productSizeCategoryId(productSizeCategoryId)
                .productOrderCount(productOrderCount)
                .build();
    }
}
