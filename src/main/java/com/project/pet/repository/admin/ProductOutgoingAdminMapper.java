package com.project.pet.repository.admin;

import com.project.pet.entity.product.ProductOutgoingStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductOutgoingAdminMapper {

    public List<ProductOutgoingStock> getProductOutgoingStocksAdmin(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public int getProductOutgoingCountAdmin(
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

}
