package com.project.pet.service.admin;

import com.project.pet.dto.admin.incomingProduct.request.PutProductIncomingStockAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingCountAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingStocksAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.response.GetProductOutgoingCountAdminResponseDto;
import com.project.pet.dto.admin.outgoingProduct.response.GetProductOutgoingStocksAdminResponseDto;
import com.project.pet.dto.product.request.*;
import com.project.pet.dto.product.response.*;
import com.project.pet.entity.product.*;
import com.project.pet.repository.ProductOrderDetailMapper;
import com.project.pet.repository.admin.ProductAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAdminService {

    @Autowired
    ProductAdminMapper productAdminMapper;

    @Autowired
    ProductOrderDetailMapper productOrderDetailMapper;

    public void postProductAdmin(PostProductAdminRequestDto postProductAdminRequestDto) {
        Product product = postProductAdminRequestDto.toEntity();
        productAdminMapper.postProductAdmin(product);
        int productId = product.getProductId();
        productAdminMapper.postProductStockAdmin(ProductStock.builder().productId(productId).build());
    }

    public GetProductAdminResponseDto getProductAdmin(int productId) {
        Product product = productAdminMapper.getProductAdmin(productId);
        return product.toGetProductAdminResponseDto();
    }

    public List<GetProductsAdminResponseDto> getProductsAdmin(GetProductsAdminRequestDto getProductsAdminRequestDto) {
        int startIndex = (getProductsAdminRequestDto.getPage() - 1) * getProductsAdminRequestDto.getCount();
        List<Product> list = productAdminMapper.getProductsAdmin(
                startIndex,
                getProductsAdminRequestDto.getCount(),
                getProductsAdminRequestDto.getProductCategoryId(),
                getProductsAdminRequestDto.getProductAnimalCategoryId(),
                getProductsAdminRequestDto.getProductNameKor()
        );
        return list.stream().map(Product::toGetProductsAdminResponseDto).collect(Collectors.toList());
    }

    public GetProductsAdminCountResponseDto getProductsAdminCount(GetProductsAdminCountRequestDto getProductsAdminCountRequestDto) {
        int productCount = productAdminMapper.getProductsAdminCount(
                getProductsAdminCountRequestDto.getProductCategoryId(),
                getProductsAdminCountRequestDto.getProductAnimalCategoryId(),
                getProductsAdminCountRequestDto.getProductNameKor()
        );

        int maxPageNumber = (int) Math.ceil(((double) productCount) / getProductsAdminCountRequestDto.getCount());

        return GetProductsAdminCountResponseDto.builder()
                .totalCount(productCount)
                .maxPageNumber(maxPageNumber)
                .build();
    }

    public void deleteProductAdmin(int productId) {
        int success = productAdminMapper.deleteProductAdmin(productId);
    }

    public void putProductAdmin(int productId, PutProductAdminRequestDto putProductAdminRequestDto) {
        putProductAdminRequestDto.setProductId(productId);
        productAdminMapper.putProductAdmin(putProductAdminRequestDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductsAdmin(List<Integer> productIds) {
        productAdminMapper.deleteProductsAdmin(productIds);
    }


    public List<GetProductIncomingStocksTestResponseDto> getProductIncomingStocksTest(GetProductIncomingStocksTestRequestDto getProductIncomingStocksTestRequestDto) {
        int startIndex = (getProductIncomingStocksTestRequestDto.getPage() - 1) * getProductIncomingStocksTestRequestDto.getCount();
        List<ProductIncomingStock> list = productAdminMapper.getProductIncomingStocksTest(
                startIndex,
                getProductIncomingStocksTestRequestDto.getCount(),
                getProductIncomingStocksTestRequestDto.getSelectedValue(),
                getProductIncomingStocksTestRequestDto.getSearchText()
        );
        return list.stream().map(ProductIncomingStock::toGetProductIncomingStocksTestResponseDto).collect(Collectors.toList());
    }

    public GetProductIncomingStockResponseDto getProductIncomingStock(int productIncomingStockId) {
        ProductIncomingStock productIncomingStock = productAdminMapper.getProductIncomingStock(productIncomingStockId);
        return productIncomingStock.toGetProductIncomingStockResponseDto();
    }

    public void deleteProductIncomingStock(int productIncomingStockId) {
        productAdminMapper.deleteProductIncomingStock(productIncomingStockId);
    }

    public void putProductIncomingStockAdmin(int productIncomingStockId, PutProductIncomingStockAdminRequestDto putProductIncomingStockAdminRequestDto) {
        putProductIncomingStockAdminRequestDto.setProductIncomingStockId(productIncomingStockId);
        productAdminMapper.putProductIncomingStockAdmin(putProductIncomingStockAdminRequestDto.toEntity());
    }

    public void postProductStockAdmin(PostProductStockAdminRequestDto postProductStockAdminRequestDto) {
        productAdminMapper.postProductStockAdmin(postProductStockAdminRequestDto.toEntity());
    }

    public GetProductStockAdminResponseDto getProductStockAdmin(int productStockId) {
        ProductStock productStock = productAdminMapper.getProductStockAdmin(productStockId);
        return productStock.toGetProductStockAdminResponseDto();
    }

    public void deleteProductStockAdmin(int productStockId) {
        productAdminMapper.deleteProductStockAdmin(productStockId);
    };

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductStocksAdmin(List<Integer> productStockIds) {
        productAdminMapper.deleteProductStocksAdmin(productStockIds);
    }

    public void postProductOutgoingStockAdmin(PostProductOutgoingStockAdminRequestDto postProductOutgoingStockAdminRequestDto) {
        productAdminMapper.postProductOutgoingStockAdmin(postProductOutgoingStockAdminRequestDto.toEntity());
    }

    public List<GetProductOutgoingStocksAdminResponseDto> getProductOutgoingStocksAdmin(GetProductOutgoingStocksAdminRequestDto getProductOutgoingStocksAdminRequestDto) {
        int startIndex = (getProductOutgoingStocksAdminRequestDto.getPage() - 1) * getProductOutgoingStocksAdminRequestDto.getCount();

        List<ProductOutgoingStock> list = productAdminMapper.getProductOutgoingStocksAdmin(
                startIndex,
                getProductOutgoingStocksAdminRequestDto.getCount(),
                getProductOutgoingStocksAdminRequestDto.getProductSizeCategoryId(),
                getProductOutgoingStocksAdminRequestDto.getProductNameKor()
        );
        return list.stream().map(ProductOutgoingStock::toGetProductOutgoingStocksAdminResponseDto).collect(Collectors.toList());
    }

    public GetProductOutgoingCountAdminResponseDto getProductOutgoingCountAdmin(GetProductOutgoingCountAdminRequestDto getProductOutgoingCountAdminRequestDto) {
        int productOutgoingCount = productAdminMapper.getProductOutgoingCountAdmin(
                getProductOutgoingCountAdminRequestDto.getProductSizeCategoryId(),
                getProductOutgoingCountAdminRequestDto.getProductNameKor()
        );
        int maxPageNumber = (int) Math.ceil(((double) productOutgoingCount) / getProductOutgoingCountAdminRequestDto.getCount());
        return GetProductOutgoingCountAdminResponseDto.builder()
                .maxPageNumber(maxPageNumber)
                .totalCount(productOutgoingCount)
                .build();
    }

    public void deleteProductOutgoingStockAdmin(int productOutgoingStockId) {
        productAdminMapper.deleteProductOutgoingStockAdmin(productOutgoingStockId);
    }

    public void deleteProductOutgoingStocksAdmin(List<Integer> productOutgoingStockIds) {
        productAdminMapper.deleteProductOutgoingStocksAdmin(productOutgoingStockIds);
    }

    public void putProductOutgoingStockAdmin(int productOutgoingStockId, PutProductOutgoingStockAdminRequestDto putProductOutgoingStockAdminRequestDto) {
        putProductOutgoingStockAdminRequestDto.setProductOutgoingStockId(productOutgoingStockId);
        productAdminMapper.putProductOutgoingStockAdmin(putProductOutgoingStockAdminRequestDto.toEntity());
    }

}
