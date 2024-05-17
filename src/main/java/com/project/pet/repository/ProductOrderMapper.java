package com.project.pet.repository;

import com.project.pet.entity.product.ProductOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductOrderMapper {
    public int postProductOrder(ProductOrder productOrder);
    public int productOrderCarts(List<ProductOrder> productOrders);
    public List<ProductOrder> getProductOrders(int userId);

    public ProductOrder getProductOrder(int productOrderId);

    public int deleteProductOrder(int productOrderId);

    public int deleteProductOrders(List<Integer> productOrderIds);

    public int putProductOrder(ProductOrder productOrder);
}
