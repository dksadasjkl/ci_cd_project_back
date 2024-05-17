package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductOrder;
import com.project.pet.entity.product.ProductOrderDetail;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class PostProductOrderRequestDto {

    private int userId;
    private int productId;
    private int productSizeCategoryId;
    private int productOrderCount;
    @NotBlank(message = "배송지를 입력해주세요")
    private String productOrderAddress;
    @NotBlank(message = "상세주소를 입력해주세요")
    private String productOrderDetailAddress;

    public ProductOrder toEntity() {
        return ProductOrder.builder()
                .userId(userId)
                .productId(productId)
                .productOrderAddress(productOrderAddress)
                .productOrderDetailAddress(productOrderDetailAddress)
                .productSizeCategoryId(productSizeCategoryId)
                .productOrderCount(productOrderCount)
                .build();
    }

}
