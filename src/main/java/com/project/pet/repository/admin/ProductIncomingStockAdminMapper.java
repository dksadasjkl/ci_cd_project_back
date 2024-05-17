package com.project.pet.repository.admin;

import com.project.pet.entity.product.ProductIncomingStock;
import com.project.pet.entity.product.ProductStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductIncomingStockAdminMapper {

    public ProductStock getProductStock(ProductStock productStock);
    public int putProductIncomingCheckAdmin(ProductStock productStock);

    public int postProductIncomingStock(ProductIncomingStock productIncomingStock);

    public int putProductIncomingStockAdmin(ProductIncomingStock productIncomingStock);

    public int deleteProductIncomingStocksAdmin(List<Integer> productIncomingStockIds);

    public List<ProductIncomingStock> getProductIncomingStocks(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public int getProductIncomingCount(
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );

}
