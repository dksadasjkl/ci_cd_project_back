package com.project.pet.dto.admin.incomingProduct.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductIncomingCountResponseDto {
    private int totalCount;
    private int maxPageNumber;
}
