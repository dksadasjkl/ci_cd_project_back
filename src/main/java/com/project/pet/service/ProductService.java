package com.project.pet.service;

import com.project.pet.dto.product.request.GetProductRequestDto;
import com.project.pet.dto.product.request.GetProductSearchProductRequestDto;
import com.project.pet.dto.product.response.GetProductCountResponseDto;
import com.project.pet.dto.product.response.GetProductResponseDto;
import com.project.pet.dto.product.response.GetProductsResponseDto;
import com.project.pet.entity.product.Product;
import com.project.pet.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;
    public GetProductResponseDto getProduct(GetProductRequestDto getProductRequestDto) {
        Product product = productMapper.getProduct(getProductRequestDto.getProductId());

        return product.toGetProductResponseDto();
    }

    public List<GetProductsResponseDto> getProducts( ) {
        List<Product> list = productMapper.getProducts();
        return list.stream().map(Product::toGetProductsResponseDto).collect(Collectors.toList());
    }

    public List<GetProductsResponseDto> productPage(GetProductSearchProductRequestDto getProductSearchProductRequestDto){
        int startIndex = (getProductSearchProductRequestDto.getPage() - 1) * getProductSearchProductRequestDto.getCount();
        List<Product>  productList = productMapper.findProducts(
                startIndex,
                getProductSearchProductRequestDto.getCount(),
                getProductSearchProductRequestDto.getProductCategoryId(),
                getProductSearchProductRequestDto.getProductAnimalCategoryId(),
                getProductSearchProductRequestDto.getSearchText(),
                getProductSearchProductRequestDto.getOrderBy());

        return productList.stream().map(Product::toGetProductsResponseDto).collect(Collectors.toList());
    }

    public GetProductCountResponseDto getProductCount(GetProductSearchProductRequestDto getProductSearchProductRequestDto) {
        int productCount = productMapper.getProductCount(
                getProductSearchProductRequestDto.getProductCategoryId(),
                getProductSearchProductRequestDto.getProductAnimalCategoryId(),
                getProductSearchProductRequestDto.getSearchText());
        int maxPageNumber = (int) Math.ceil(((double) productCount) / getProductSearchProductRequestDto.getCount());

        return GetProductCountResponseDto.builder()
                .totalCount(productCount)
                .maxPageNumber(maxPageNumber)
                .build();
    }
}
