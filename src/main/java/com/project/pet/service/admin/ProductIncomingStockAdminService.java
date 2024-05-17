package com.project.pet.service.admin;

import com.project.pet.dto.admin.incomingProduct.request.*;
import com.project.pet.dto.admin.incomingProduct.response.GetProductIncomingCountResponseDto;
import com.project.pet.dto.admin.incomingProduct.response.GetProductIncomingStocksResponseDto;
import com.project.pet.entity.product.ProductIncomingStock;
import com.project.pet.entity.product.ProductStock;
import com.project.pet.repository.admin.ProductIncomingStockAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductIncomingStockAdminService {

    @Autowired
    ProductIncomingStockAdminMapper productIncomingStockAdminMapper;
    public void putProductIncomingCheckAdmin(PutProductIncomingCheckAdminRequestDto putProductIncomingCheckAdminRequestDto) {
        int productIncomingStockCount = putProductIncomingCheckAdminRequestDto.getProductIncomingStockCount();

        ProductStock productStock = productIncomingStockAdminMapper.getProductStock(putProductIncomingCheckAdminRequestDto.toEntity());

        putProductIncomingCheckAdminRequestDto.setProductIncomingStockCount(productIncomingStockCount + productStock.getProductStockCount());

        productIncomingStockAdminMapper.putProductIncomingCheckAdmin(putProductIncomingCheckAdminRequestDto.toEntity());
    }

    public void postProductIncomingStock(PostProductIncomingStockRequestDto postProductIncomingStockRequestDto) {
        productIncomingStockAdminMapper.postProductIncomingStock(postProductIncomingStockRequestDto.toEntity());
    }

    public void putProductIncomingStockAdmin(int productIncomingStockId, PutProductIncomingStockAdminRequestDto putProductIncomingStockAdminRequestDto) {
        putProductIncomingStockAdminRequestDto.setProductIncomingStockId(productIncomingStockId);
        productIncomingStockAdminMapper.putProductIncomingStockAdmin(putProductIncomingStockAdminRequestDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductIncomingStocksAdmin(List<Integer> productIncomingStockIds) {
        productIncomingStockAdminMapper.deleteProductIncomingStocksAdmin(productIncomingStockIds);
    }

    public List<GetProductIncomingStocksResponseDto> getProductIncomingStocks(GetProductIncomingStocksRequestDto getProductIncomingStocksRequestDto) {
        int startIndex = (getProductIncomingStocksRequestDto.getPage() - 1) * getProductIncomingStocksRequestDto.getCount();
        List<ProductIncomingStock> list = productIncomingStockAdminMapper.getProductIncomingStocks(
                startIndex,
                getProductIncomingStocksRequestDto.getCount(),
                getProductIncomingStocksRequestDto.getProductSizeCategoryId(),
                getProductIncomingStocksRequestDto.getProductNameKor()
        );
        return list.stream().map(ProductIncomingStock::toGetProductIncomingStocksResponseDto).collect(Collectors.toList());
    }

    public GetProductIncomingCountResponseDto getProductIncomingCount(GetProductIncomingCountRequestDto getProductIncomingCountRequestDto) {
        int productCount = productIncomingStockAdminMapper.getProductIncomingCount(
                getProductIncomingCountRequestDto.getProductSizeCategoryId(),
                getProductIncomingCountRequestDto.getProductNameKor()
        );

        int maxPageNumber = (int) Math.ceil(((double) productCount) / getProductIncomingCountRequestDto.getCount());

        return GetProductIncomingCountResponseDto.builder()
                .totalCount(productCount)
                .maxPageNumber(maxPageNumber)
                .build();
    }

}
