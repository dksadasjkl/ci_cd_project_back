package com.project.pet.entity.product;

import com.project.pet.entity.user.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ProductOrderDetail {
    private int productOrderDetailId;
    private int productOrderId;
    private int productId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private ProductOrder productOrder;
    private Product product;
    private ProductSizeCategory productSizeCategory;
    private User user;
    private ProductAnimalCategory productAnimalCategory;
    private ProductCategory productCategory;

//    public GetProductOrderDetailsAdminResponseDto toGetProductOrderDetailsAdminResponseDto() {
//        return GetProductOrderDetailsAdminResponseDto.builder()
//                .productOrderDetailId(productOrderDetailId)
////                .productNameKor(product.getProductNameKor())
////                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
////                .productOrderCount(productOrder.getProductOrderCount())
////                .name(user.getName())
////                .productOrderAddress(productOrder.getProductOrderAddress())
////                .productOrderDetailAddress(productOrder.getProductOrderDetailAddress())
//                .build();
//    }
}
