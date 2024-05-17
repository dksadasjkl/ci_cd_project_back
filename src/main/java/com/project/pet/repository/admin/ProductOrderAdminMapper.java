package com.project.pet.repository.admin;

import com.project.pet.entity.product.ProductOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductOrderAdminMapper {

    public List<ProductOrder> getProductOrderDetailsAdmin(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public int getProductOrderDetailsAdminCount(
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public int getDogSales();

    public int getCatSales();

    public int getFeedSales();

    public int getSnackSales();

    public int getHygieneSales();

    public int getBeautySales();

    public int getTotalSales();
}
