package com.project.pet.dto.product.request;

import lombok.Data;

@Data
public class GetProductIncomingStocksTestRequestDto {
    private int page;
    private int count;
    private int selectedValue;
    private String searchText;
}
