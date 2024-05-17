package com.project.pet.service;

import com.project.pet.dto.product.response.GetProductAnimalCategoryResponseDto;
import com.project.pet.dto.product.response.GetProductCategoryResponseDto;
import com.project.pet.dto.product.response.GetProductSizeCategoryResponseDto;
import com.project.pet.entity.product.ProductAnimalCategory;
import com.project.pet.entity.product.ProductCategory;
import com.project.pet.entity.product.ProductSizeCategory;
import com.project.pet.repository.OptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOptionService {

    @Autowired
    private OptionsMapper optionsMapper;
    public List<GetProductCategoryResponseDto> getAllProductTypes() {
        List<ProductCategory> productCategoryList = optionsMapper.getAllProductTypes();
        return productCategoryList.stream().map(ProductCategory::toGetProductCategoryResponseDto).collect(Collectors.toList());
    }

    public List<GetProductAnimalCategoryResponseDto> getAllCategories() {
        List<ProductAnimalCategory> productAnimalCategoryList = optionsMapper.getAllCategories();
        return productAnimalCategoryList.stream().map(ProductAnimalCategory::toGetProductAnimalCategoryResponseDto).collect(Collectors.toList());
    }

    public List<GetProductSizeCategoryResponseDto> getAllSize() {
        List<ProductSizeCategory> productSizeCategoryList =  optionsMapper.getAllSize();
        return productSizeCategoryList.stream().map(ProductSizeCategory::toGetProductSizeCategoryResponseDto).collect(Collectors.toList());
    }
}
