package com.project.pet.service;

import com.project.pet.dto.product.request.GetProductCartRequestDto;
import com.project.pet.dto.product.request.PostProductCartRequestDto;
import com.project.pet.dto.product.request.UpdateProductCartRequestDto;
import com.project.pet.dto.product.response.GetProductCartResponseDto;
import com.project.pet.entity.product.ProductCart;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.repository.ProductCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCartService {

    @Autowired
    private ProductCartMapper productCartMapper;

    private PrincipalUser getPrincipalUser () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return principalUser;
    }

    public void saveProductCart(PostProductCartRequestDto postProductCartRequestDto) {
        if(postProductCartRequestDto.getProductSizeCategoryId() == 0) {
            throw new NullPointerException("데이터 오류");
        }
        productCartMapper.saveProductCart(postProductCartRequestDto.toEntity());
    }

    public List<GetProductCartResponseDto> getProductsCart (GetProductCartRequestDto getProductCartRequestDto) {
        List<ProductCart> productCarts = productCartMapper.getProductsCart(getProductCartRequestDto.getUserId());
        return productCarts.stream().map(ProductCart::toGetProductCartResponseDto).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductCart(List<Integer> productCartIds) {
        productCartMapper.deleteProductCarts(productCartIds);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateProductCart(int productCartId, UpdateProductCartRequestDto updateProductCartRequestDto) {
        productCartMapper.updateProductCart(updateProductCartRequestDto.toEntity(productCartId, getPrincipalUser().getUserId()));
    }
}
