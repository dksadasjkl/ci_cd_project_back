package com.project.pet.repository;

import com.project.pet.entity.product.ProductCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCartMapper {
    public int saveProductCart(ProductCart productCart);
    public List<ProductCart> getProductsCart(int userId);
    public int deleteProductCarts (List<Integer> productCartIds);
    public int updateProductCart (ProductCart productCart);
}
