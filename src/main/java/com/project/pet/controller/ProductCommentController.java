package com.project.pet.controller;

import com.project.pet.dto.product.request.*;
import com.project.pet.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @PostMapping("/comment")
    public ResponseEntity<?> saveProductComment(@RequestBody PostProductCommentsRequestDto postProductCommentRequestDto) {
        productCommentService.saveProductComment(postProductCommentRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/comments-user")
    public ResponseEntity<?> getProductCommentsByUserId(GetProductCommentRequestDto getProductCommentRequestDto) {
        return ResponseEntity.ok(productCommentService.getProductComment(getProductCommentRequestDto));
    }

    @GetMapping("/comments")
    public ResponseEntity<?> getAllProductCommentsByProductId(GetProductCommentsRequestDto getProductCommentsRequestDto) {
        return ResponseEntity.ok(productCommentService.getAllProductComments(getProductCommentsRequestDto));
    }
    @DeleteMapping("/comment/delete")
    public ResponseEntity<?> deleteProductComment(@RequestBody DeleteProductCommentRequestDto deleteProductCommentRequestDto) {
        productCommentService.deleteProductComment(deleteProductCommentRequestDto);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/comment/update")
    public ResponseEntity<?> updateProductComment(@RequestBody UpdateProductCommentRequestDto updateProductCommentRequestDto){
        productCommentService.updateProductComment(updateProductCommentRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/comments/page")
    public ResponseEntity<?> getProductPage(GetProductSearchProductRequestDto getProductSearchProductRequestDto){
        return ResponseEntity.ok(productCommentService.getProductCountPage(getProductSearchProductRequestDto));
    }

    @GetMapping("/comments/count")
    public ResponseEntity<?> getProductCount(GetProductSearchProductRequestDto getProductSearchProductRequestDto) {
        return ResponseEntity.ok(productCommentService.getProductCount(getProductSearchProductRequestDto));
    }

}
