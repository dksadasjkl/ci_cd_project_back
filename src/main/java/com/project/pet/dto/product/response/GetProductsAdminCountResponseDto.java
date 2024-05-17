package com.project.pet.dto.product.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductsAdminCountResponseDto {
    private int totalCount;
    private int maxPageNumber;
}
