package com.project.pet.controller;

import com.project.pet.dto.product.request.GetProductRequestDto;
import com.project.pet.dto.product.request.GetProductSearchProductRequestDto;
import com.project.pet.dto.product.response.GetProductCountResponseDto;
import com.project.pet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    // 사용자 상품 조회(단건)
    @GetMapping("/one")
    public ResponseEntity<?> getProduct(GetProductRequestDto getProductRequestDto) {
        return ResponseEntity.ok(productService.getProduct(getProductRequestDto));
    }

    // 사용자 상품 조회(다건)
    @GetMapping("/")
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getProducts(GetProductSearchProductRequestDto getProductSearchProductRequestDto){
        return ResponseEntity.ok(productService.productPage(getProductSearchProductRequestDto));
    }

    @GetMapping("/count")
    public ResponseEntity<?> getProductCount(GetProductSearchProductRequestDto getProductSearchProductRequestDto) {
        return ResponseEntity.ok(productService.getProductCount(getProductSearchProductRequestDto));
    }
}
