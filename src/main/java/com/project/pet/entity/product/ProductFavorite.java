package com.project.pet.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductFavorite {

    private int productFavoriteId;
    private int productId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int totalUserIdCount;

}
