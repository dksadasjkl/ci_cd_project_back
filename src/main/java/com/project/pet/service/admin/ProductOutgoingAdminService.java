package com.project.pet.service.admin;

import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingCountAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingStocksAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.response.GetProductOutgoingCountAdminResponseDto;
import com.project.pet.dto.admin.outgoingProduct.response.GetProductOutgoingStocksAdminResponseDto;
import com.project.pet.entity.product.ProductOutgoingStock;
import com.project.pet.repository.admin.ProductOutgoingAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOutgoingAdminService {

    @Autowired
    ProductOutgoingAdminMapper productOutgoingAdminMapper;

    public List<GetProductOutgoingStocksAdminResponseDto> getProductOutgoingStocksAdmin(GetProductOutgoingStocksAdminRequestDto getProductOutgoingStocksAdminRequestDto) {
        int startIndex = (getProductOutgoingStocksAdminRequestDto.getPage() - 1) * getProductOutgoingStocksAdminRequestDto.getCount();

        List<ProductOutgoingStock> list = productOutgoingAdminMapper.getProductOutgoingStocksAdmin(
                startIndex,
                getProductOutgoingStocksAdminRequestDto.getCount(),
                getProductOutgoingStocksAdminRequestDto.getProductSizeCategoryId(),
                getProductOutgoingStocksAdminRequestDto.getProductNameKor()
        );
        return list.stream().map(ProductOutgoingStock::toGetProductOutgoingStocksAdminResponseDto).collect(Collectors.toList());
    }

    public GetProductOutgoingCountAdminResponseDto getProductOutgoingCountAdmin(GetProductOutgoingCountAdminRequestDto getProductOutgoingCountAdminRequestDto) {
        int productOutgoingCount = productOutgoingAdminMapper.getProductOutgoingCountAdmin(
                getProductOutgoingCountAdminRequestDto.getProductSizeCategoryId(),
                getProductOutgoingCountAdminRequestDto.getProductNameKor()
        );
        int maxPageNumber = (int) Math.ceil(((double) productOutgoingCount) / getProductOutgoingCountAdminRequestDto.getCount());
        return GetProductOutgoingCountAdminResponseDto.builder()
                .maxPageNumber(maxPageNumber)
                .totalCount(productOutgoingCount)
                .build();
    }


}
