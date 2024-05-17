package com.project.pet.repository.admin;

import com.project.pet.entity.product.ProductStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductStockAdminMapper {

    public int putProductStockAdmin(ProductStock productStock);

    public List<ProductStock> getProductStocksAdmin(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public int getProductStocksCount(
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public ProductStock getProductStock(
            @Param("productId") int productId,
            @Param("productSizeCategoryId") int productSizeCategoryId
    );

    public int updateProductStock(
            @Param("productId") int productId,
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productStockCount") int productStockCount
    );


}
