package com.project.pet.dto.admin.outgoingProduct.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductOutgoingCountAdminResponseDto {
    private int totalCount;
    private int maxPageNumber;
}
