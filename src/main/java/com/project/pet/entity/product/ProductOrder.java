package com.project.pet.entity.product;

import com.project.pet.dto.admin.orderProduct.response.GetProductOrderDetailsAdminResponseDto;
import com.project.pet.dto.product.response.GetProductOrderResponseDto;
import com.project.pet.dto.product.response.GetProductOrdersResponseDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOrder {
    private int productOrderId;
    private int userId;
    private int productId;
    private String productOrderAddress;
    private String productOrderDetailAddress;
    private int productSizeCategoryId;
    private int productOrderCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private User user;
    private Product product;
    private ProductSizeCategory productSizeCategory;



    public GetProductOrdersResponseDto toGetProductOrdersResponseDto() {
        LocalDate date = createDate.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);


        return GetProductOrdersResponseDto.builder()
                .productOrderId(productOrderId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productPrice(product.getProductPrice())
                .productImageUrl(product.getProductImageUrl())
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productSizeCategoryNameKor(productSizeCategory.getProductSizeCategoryNameKor())
                .productOrderCount(productOrderCount)
                .userId(userId)
                .username(user.getName())
                .productOrderAddress(productOrderAddress)
                .productDetailOrderAddress(productOrderDetailAddress)
                .createDate(formattedDate)
                .updateDate(updateDate)
                .build();
    }

    public GetProductOrderResponseDto toGetProductOrderResponseDto() {
        return GetProductOrderResponseDto.builder()
                .productOrderId(productOrderId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryId(productSizeCategoryId)
                .productImageUrl(product.getProductImageUrl())
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productSizeCategoryNameKor(productSizeCategory.getProductSizeCategoryNameKor())
                .productOrderCount(productOrderCount)
                .userId(userId)
                .username(user.getName())
                .productOrderAddress(productOrderAddress)
                .productDetailOrderAddress(productOrderDetailAddress)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetProductOrderDetailsAdminResponseDto toGetProductOrderDetailsAdminResponseDto() {
        return GetProductOrderDetailsAdminResponseDto.builder()
                .productOrderId(productOrderId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productOrderCount(productOrderCount)
                .name(user.getName())
                .productOrderAddress(productOrderAddress)
                .productOrderDetailAddress(productOrderDetailAddress)
                .build();
    }
}
