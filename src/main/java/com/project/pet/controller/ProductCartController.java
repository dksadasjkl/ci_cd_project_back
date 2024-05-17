package com.project.pet.controller;

import com.project.pet.dto.product.request.GetProductCartRequestDto;
import com.project.pet.dto.product.request.PostProductCartRequestDto;
import com.project.pet.dto.product.request.UpdateProductCartRequestDto;
import com.project.pet.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductCartController {

    @Autowired
    private ProductCartService productCartService;

    @PostMapping("/cart")
    public ResponseEntity<?> saveProductCart(@RequestBody PostProductCartRequestDto postProductCartRequestDto) {
        productCartService.saveProductCart(postProductCartRequestDto);
        return ResponseEntity.created(null).body(true);
    }
    @GetMapping("/carts")
    public ResponseEntity<?> getProductCart(GetProductCartRequestDto getProductCartRequestDto) {
        return ResponseEntity.ok(productCartService.getProductsCart(getProductCartRequestDto));
    }

    @DeleteMapping("/delete/carts")
    public ResponseEntity<?> deleteProductCart(@RequestBody List<Integer> productCartIds) {
        productCartService.deleteProductCart(productCartIds);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update/cart/{productCartId}")
    public ResponseEntity<?> updateProductCart(@PathVariable int productCartId, @RequestBody UpdateProductCartRequestDto updateProductCartRequestDto) {
        productCartService.updateProductCart(productCartId, updateProductCartRequestDto);
        return ResponseEntity.ok(true);
    }
}
