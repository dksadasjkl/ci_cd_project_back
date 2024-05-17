package com.project.pet.entity.product;

import com.project.pet.dto.product.response.*;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private int productId;
    private int userId;
    private String productNameKor;
    private int productPrice;
    private String productImageUrl;
    private int productCategoryId;
    private int productAnimalCategoryId;
    private String productBoardContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private ProductFavorite productFavorite;
    private ProductCategory productCategory;
    private ProductAnimalCategory productAnimalCategory;
    private User user;

    public GetProductsAdminResponseDto toGetProductsAdminResponseDto() {
        return GetProductsAdminResponseDto.builder()
                .productId(productId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productCategoryId)
                .productCategoryNameKor(productCategory.getProductCategoryNameKor())
                .productAnimalCategoryId(productAnimalCategoryId)
                .productAnimalCategoryNameKor(productAnimalCategory.getProductAnimalCategoryNameKor())
                .productBoardContent(productBoardContent)
                .userId(userId)
                .userName(user.getName())
                .userNickname(user.getNickname())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public ProductFavoriteResponseDto toProductFavoriteResponseDto() {
        return ProductFavoriteResponseDto.builder()
                .productId(productId)
                .userId(userId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productCategoryId)
                .productAnimalCategoryId(productAnimalCategoryId)
                .productBoardContent(productBoardContent)
                .totalUserIdCount(productFavorite.getTotalUserIdCount())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetProductResponseDto toGetProductResponseDto() {
        return GetProductResponseDto.builder()
                .productId(productId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productCategoryId)
                .productCategoryNameKor(productCategory.getProductCategoryNameKor())
                .productAnimalCategoryId(productCategoryId)
                .productAnimalCategoryNameKor(productAnimalCategory.getProductAnimalCategoryNameKor())
                .productBoardContent(productBoardContent)
                .build();
    }

    public GetProductsResponseDto toGetProductsResponseDto() {
        return GetProductsResponseDto.builder()
                .productId(productId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productCategoryId)
                .productCategoryNameKor(productCategory.getProductCategoryNameKor())
                .productAnimalCategoryId(productCategoryId)
                .productAnimalCategoryNameKor(productAnimalCategory.getProductAnimalCategoryNameKor())
                .productBoardContent(productBoardContent)
                .build();
    }

    public GetProductAdminResponseDto toGetProductAdminResponseDto() {
        return GetProductAdminResponseDto.builder()
                .productId(productId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productCategoryId)
                .productCategoryNameKor(productCategory.getProductCategoryNameKor())
                .productAnimalCategoryId(productAnimalCategoryId)
                .productAnimalCategoryNameKor(productAnimalCategory.getProductAnimalCategoryNameKor())
                .productBoardContent(productBoardContent)
                .userId(userId)
                .userName(user.getName())
                .userNickname(user.getNickname())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
