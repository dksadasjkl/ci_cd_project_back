package com.project.pet.repository.admin;

import com.project.pet.entity.product.Product;
import com.project.pet.entity.product.ProductIncomingStock;
import com.project.pet.entity.product.ProductOutgoingStock;
import com.project.pet.entity.product.ProductStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductAdminMapper {
    public int postProductAdmin(Product product);

    public Product getProductAdmin(int productId);

    public List<Product> getProductsAdmin(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("productCategoryId") int productCategoryId,
            @Param("productAnimalCategoryId") int productAnimalCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public int getProductsAdminCount(
            @Param("productCategoryId") int productCategoryId,
            @Param("productAnimalCategoryId") int productAnimalCategoryId,
            @Param("productNameKor") String productNameKor
    );

    public int deleteProductAdmin(int productId);

    public int putProductAdmin(Product product);

    public int deleteProductsAdmin(List<Integer> productIds);

    public List<ProductIncomingStock> getProductIncomingStocksTest(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("selectedValue") int selectedValue,
            @Param("searchText") String searchText
    );

    public ProductIncomingStock getProductIncomingStock(int productIncomingStockId);

    public int deleteProductIncomingStock(int productIncomingStockId);

    public int putProductIncomingStockAdmin(ProductIncomingStock productIncomingStock);

    public int postProductStockAdmin(ProductStock productStock);

    public ProductStock getProductStockAdmin(int productStockId);

    public int deleteProductStockAdmin(int productStockId);

    public int deleteProductStocksAdmin(List<Integer> productStockIds);

    public int postProductOutgoingStockAdmin(ProductOutgoingStock productOutgoingStock);

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

    public int deleteProductOutgoingStockAdmin(int productOrderId);

    public int deleteProductOutgoingStocksAdmin(List<Integer> productOrderIds);

    public int putProductOutgoingStockAdmin(ProductOutgoingStock productOutgoingStock);
}
