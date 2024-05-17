package com.project.pet.repository;

import com.project.pet.entity.product.ProductAnimalCategory;
import com.project.pet.entity.product.ProductCategory;
import com.project.pet.entity.product.ProductSizeCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionsMapper {
    public List<ProductCategory> getAllProductTypes();
    public List<ProductAnimalCategory> getAllCategories();
    public List<ProductSizeCategory> getAllSize();
}
