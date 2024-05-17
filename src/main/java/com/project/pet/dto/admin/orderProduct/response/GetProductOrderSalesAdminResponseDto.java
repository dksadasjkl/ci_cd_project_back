package com.project.pet.dto.admin.orderProduct.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductOrderSalesAdminResponseDto {
    private int dogSales;
    private int catSales;
    private int feedSales;
    private int snackSales;
    private int hygieneSales;
    private int beautySales;
    private int totalSales;
}
