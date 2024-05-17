package com.project.pet.service.admin;

import com.project.pet.dto.admin.orderProduct.request.GetProductOrderDetailsAdminCountRequestDto;
import com.project.pet.dto.admin.orderProduct.request.GetProductOrderDetailsAdminRequestDto;
import com.project.pet.dto.admin.orderProduct.response.GetProductOrderDetailsAdminCountResponseDto;
import com.project.pet.dto.admin.orderProduct.response.GetProductOrderDetailsAdminResponseDto;
import com.project.pet.dto.admin.orderProduct.response.GetProductOrderSalesAdminResponseDto;
import com.project.pet.entity.product.ProductOrder;
import com.project.pet.repository.admin.ProductOrderAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderAdminService {

    @Autowired
    ProductOrderAdminMapper productOrderAdminMapper;

    public List<GetProductOrderDetailsAdminResponseDto> getProductOrderDetailsAdmin(GetProductOrderDetailsAdminRequestDto getProductOrderDetailsAdminRequestDto) {
        int startIndex = (getProductOrderDetailsAdminRequestDto.getPage() - 1) * getProductOrderDetailsAdminRequestDto.getCount();
        List<ProductOrder> list = productOrderAdminMapper.getProductOrderDetailsAdmin(
                startIndex,
                getProductOrderDetailsAdminRequestDto.getCount(),
                getProductOrderDetailsAdminRequestDto.getProductSizeCategoryId(),
                getProductOrderDetailsAdminRequestDto.getProductNameKor()
        );
        return list.stream().map(ProductOrder::toGetProductOrderDetailsAdminResponseDto).collect(Collectors.toList());
    }

    public GetProductOrderDetailsAdminCountResponseDto getProductOrderDetailsAdminCount(GetProductOrderDetailsAdminCountRequestDto getProductOrderDetailsAdminCountRequestDto) {
        int productOrderDeatilsCount = productOrderAdminMapper.getProductOrderDetailsAdminCount(
                getProductOrderDetailsAdminCountRequestDto.getProductSizeCategoryId(),
                getProductOrderDetailsAdminCountRequestDto.getProductNameKor()
        );
        int maxPageNumber = (int) Math.ceil(((double) productOrderDeatilsCount) / getProductOrderDetailsAdminCountRequestDto.getCount());
        return GetProductOrderDetailsAdminCountResponseDto.builder()
                .maxPageNumber(maxPageNumber)
                .totalCount(productOrderDeatilsCount)
                .build();
    }

    public GetProductOrderSalesAdminResponseDto getProductOrderSalesAdmin() {
        int dogSales = productOrderAdminMapper.getDogSales();
        int catSales = productOrderAdminMapper.getCatSales();
        int feedSales = productOrderAdminMapper.getFeedSales();
        int snackSales = productOrderAdminMapper.getSnackSales();
        int hygieneSales = productOrderAdminMapper.getHygieneSales();
        int beautySales = productOrderAdminMapper.getBeautySales();
        int totalSales = productOrderAdminMapper.getTotalSales();

        return GetProductOrderSalesAdminResponseDto.builder()
                .dogSales(dogSales)
                .catSales(catSales)
                .feedSales(feedSales)
                .snackSales(snackSales)
                .hygieneSales(hygieneSales)
                .beautySales(beautySales)
                .totalSales(totalSales)
                .build();
    }

}
