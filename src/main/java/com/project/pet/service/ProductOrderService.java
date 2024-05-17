package com.project.pet.service;

import com.project.pet.dto.product.request.GetProductOrderRequestDto;
import com.project.pet.dto.product.request.GetProductOrdersRequestDto;
import com.project.pet.dto.product.request.PostProductOrderRequestDto;
import com.project.pet.dto.product.request.PutProductOrderRequestDto;
import com.project.pet.dto.product.response.DeleteProductOrderRequestDto;
import com.project.pet.dto.product.response.GetProductOrderResponseDto;
import com.project.pet.dto.product.response.GetProductOrdersResponseDto;
import com.project.pet.entity.product.ProductOrder;
import com.project.pet.entity.product.ProductOrderDetail;
import com.project.pet.entity.product.ProductOutgoingStock;
import com.project.pet.entity.product.ProductStock;
import com.project.pet.repository.ProductOrderDetailMapper;
import com.project.pet.repository.ProductOrderMapper;
import com.project.pet.repository.admin.ProductAdminMapper;
import com.project.pet.repository.admin.ProductStockAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderMapper productOrderMapper;
    @Autowired
    ProductOrderDetailMapper productOrderDetailMapper;

    @Autowired
    ProductAdminMapper productAdminMapper;

    @Autowired
    ProductStockAdminMapper productStockAdminMapper;


    public void postProductOrder(PostProductOrderRequestDto postProductOrderRequestDto) {
        ProductOrder productOrder = postProductOrderRequestDto.toEntity();
        if(postProductOrderRequestDto.getProductSizeCategoryId() == 0) {
            throw new NullPointerException("데이터 오류");
        }
        productOrderMapper.postProductOrder(productOrder);

        int productOrderId = productOrder.getProductOrderId();
        int productId = productOrder.getProductId();
        int productSizeCategoryId = productOrder.getProductSizeCategoryId();
        int productOrderCount = productOrder.getProductOrderCount();


        productOrderDetailMapper.postProductOrderDetail(
                ProductOrderDetail.builder()
                .productOrderId(productOrderId)
                .productId(productId)
                .build()
        );

        productAdminMapper.postProductOutgoingStockAdmin(
                ProductOutgoingStock.builder()
                        .productOrderId(productOrderId)
                        .productId(productId)
                        .productSizeCategoryId(productSizeCategoryId)
                        .productOutgoingStockCount(productOrderCount)
                        .build()
        );

        ProductStock productStock = productStockAdminMapper.getProductStock(productId, productSizeCategoryId);
        int productStockCount = productStock.getProductStockCount();
        productStockAdminMapper.updateProductStock(productId, productSizeCategoryId, (productStockCount - productOrderCount));
    }

    public void productOrderCarts(List<PostProductOrderRequestDto>  productOrderRequestDtoList) {
        List<ProductOrder> orders  = productOrderRequestDtoList.stream().map(PostProductOrderRequestDto::toEntity).collect(Collectors.toList());
        productOrderMapper.productOrderCarts(orders);

        for (ProductOrder productOrder : orders) {
            int productOrderId = productOrder.getProductOrderId();
            int productId = productOrder.getProductId();
            int productSizeCategoryId = productOrder.getProductSizeCategoryId();
            int productOrderCount = productOrder.getProductOrderCount();

            productOrderDetailMapper.postProductOrderDetail(
                    ProductOrderDetail.builder()
                            .productOrderId(productOrderId)
                            .productId(productId)
                            .build()
            );

            productAdminMapper.postProductOutgoingStockAdmin(
                    ProductOutgoingStock.builder()
                            .productOrderId(productOrderId)
                            .productId(productId)
                            .productSizeCategoryId(productSizeCategoryId)
                            .productOutgoingStockCount(productOrderCount)
                            .build()
            );

            ProductStock productStock = productStockAdminMapper.getProductStock(productId, productSizeCategoryId);
            int productStockCount = productStock.getProductStockCount();
            productStockAdminMapper.updateProductStock(productId, productSizeCategoryId, (productStockCount - productOrderCount));
        }
    }

    public List<GetProductOrdersResponseDto> getProductOrders(GetProductOrdersRequestDto getProductOrdersRequestDto) {
        List<ProductOrder> list = productOrderMapper.getProductOrders(getProductOrdersRequestDto.getUserId());
        return list.stream().map(ProductOrder::toGetProductOrdersResponseDto).collect(Collectors.toList());
    }

    public GetProductOrderResponseDto getProductOrder(GetProductOrderRequestDto getProductOrderRequestDto) {
        return productOrderMapper.getProductOrder(getProductOrderRequestDto.getProductOrderId()).toGetProductOrderResponseDto();
    }

    public void deleteProductOrder(DeleteProductOrderRequestDto deleteProductOrderRequestDto) {
        int productOrderId = deleteProductOrderRequestDto.getProductOrderId();

        ProductOrder productOrder = productOrderMapper.getProductOrder(productOrderId);
        int productOrderCount = productOrder.getProductOrderCount();
        int productId = productOrder.getProductId();
        int productSizeCategoryId = productOrder.getProductSizeCategoryId();

        ProductStock productStock = productStockAdminMapper.getProductStock(productId, productSizeCategoryId);
        int productStockCount = productStock.getProductStockCount();

        productOrderMapper.deleteProductOrder(productOrderId);
        productOrderDetailMapper.deleteProductOrder(productOrderId);
        productAdminMapper.deleteProductOutgoingStockAdmin(productOrderId);
        productStockAdminMapper.updateProductStock(productId, productSizeCategoryId, (productStockCount + productOrderCount));
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductOrders(List<Integer> productOrderIds) {
        productOrderMapper.deleteProductOrders(productOrderIds);
        productOrderDetailMapper.deleteProductOrders(productOrderIds);
        productAdminMapper.deleteProductOutgoingStocksAdmin(productOrderIds);
    }


    public void putProductOrder(PutProductOrderRequestDto putProductOrderRequestDto) {
        int productOrderId = putProductOrderRequestDto.getProductOrderId();
        if(putProductOrderRequestDto.getProductSizeCategoryId() == 0) {
            throw new NullPointerException("데이터 오류");
        }
        putProductOrderRequestDto.setProductOrderId(productOrderId);
        productOrderMapper.putProductOrder(putProductOrderRequestDto.toEntity());
        productAdminMapper.putProductOutgoingStockAdmin(ProductOutgoingStock
                .builder()
                .productOrderId(productOrderId)
                .productSizeCategoryId(putProductOrderRequestDto.getProductSizeCategoryId())
                .productOutgoingStockCount(putProductOrderRequestDto.getProductOrderCount())
                .build());
    }

}
