package com.project.pet.service.admin;

import com.project.pet.dto.admin.stockProduct.request.PutProductStockAdminRequestDto;
import com.project.pet.dto.admin.stockProduct.request.GetProductStocksAdminRequestDto;
import com.project.pet.dto.admin.stockProduct.request.GetProductStocksCountRequestDto;
import com.project.pet.dto.admin.stockProduct.response.GetProductStocksAdminResponseDto;
import com.project.pet.dto.admin.stockProduct.response.GetProductStocksCountResponseDto;
import com.project.pet.entity.product.ProductStock;
import com.project.pet.repository.admin.ProductStockAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductStockAdminService {

    @Autowired
    ProductStockAdminMapper productStockAdminMapper;
    public void putProductStockAdmin(int productStockId, PutProductStockAdminRequestDto productStockAdminRequestDto) {
        productStockAdminRequestDto.setProductStockId(productStockId);
        productStockAdminMapper.putProductStockAdmin(productStockAdminRequestDto.toEntity());
    }

    public List<GetProductStocksAdminResponseDto> getProductStocksAdmin(GetProductStocksAdminRequestDto getProductStocksAdminRequestDto) {
        int startIndex = (getProductStocksAdminRequestDto.getPage() - 1) * getProductStocksAdminRequestDto.getCount();
        List<ProductStock> list = productStockAdminMapper.getProductStocksAdmin(
                startIndex,
                getProductStocksAdminRequestDto.getCount(),
                getProductStocksAdminRequestDto.getProductSizeCategoryId(),
                getProductStocksAdminRequestDto.getProductNameKor()
        );
        return list.stream().map(ProductStock::toGetProductStocksResponseDto).collect(Collectors.toList());
    }

    public GetProductStocksCountResponseDto getProductStocksCount(GetProductStocksCountRequestDto getProductStocksCountRequestDto) {
        int productStockCount = productStockAdminMapper.getProductStocksCount(
                getProductStocksCountRequestDto.getProductSizeCategoryId(),
                getProductStocksCountRequestDto.getProductNameKor()
        );
        int maxPageNumber = (int) Math.ceil(((double) productStockCount) / getProductStocksCountRequestDto.getCount());
        return GetProductStocksCountResponseDto.builder()
                .totalCount(productStockCount)
                .maxPageNumber(maxPageNumber)
                .build();
    }

}
