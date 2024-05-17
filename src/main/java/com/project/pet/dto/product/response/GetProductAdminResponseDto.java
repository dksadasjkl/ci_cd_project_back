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
public class GetProductAdminResponseDto {
    private int productId;
    private String productNameKor;
    private int productPrice;
    private String productImageUrl;
    private int productCategoryId;
    private String productCategoryNameKor;
    private int productAnimalCategoryId;
    private String productAnimalCategoryNameKor;
    private String productBoardContent;
    private int userId;
    private String userName;
    private String userNickname;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
