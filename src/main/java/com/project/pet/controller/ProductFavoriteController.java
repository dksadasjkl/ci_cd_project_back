package com.project.pet.controller;

import com.project.pet.dto.product.request.DeleteProductFavoriteRequestDto;
import com.project.pet.dto.product.request.GetProductFavoriteRequestDto;
import com.project.pet.dto.product.request.PostProductFavoriteRequestDto;
import com.project.pet.service.ProductFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductFavoriteController {

    @Autowired
    private ProductFavoriteService productFavoriteService;


    @GetMapping("/favorites/count")
    public ResponseEntity<?> getProductFavoritesCount (GetProductFavoriteRequestDto getProductFavoriteRequestDto) {
        return ResponseEntity.ok(productFavoriteService.getProductFavoritesCount(getProductFavoriteRequestDto));
    }

    @PostMapping("/favorite")
    public ResponseEntity<?> saveProductFavorite (@RequestBody PostProductFavoriteRequestDto postProductFavoriteRequestDto) {
        productFavoriteService.saveProductFavorite(postProductFavoriteRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    @DeleteMapping("/favorite/delete")
    public ResponseEntity<?> deleteProductFavorite (@RequestBody DeleteProductFavoriteRequestDto deleteProductFavoriteRequestDto) {
        productFavoriteService.deleteProductFavorite(deleteProductFavoriteRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/like")
    public ResponseEntity<?> getUserLikeStatus(GetProductFavoriteRequestDto getProductFavoriteRequestDto) {
        boolean isLiked = productFavoriteService.getUserLikeStatus(getProductFavoriteRequestDto);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/likes")
    public ResponseEntity<?> getUserLikesStatus(GetProductFavoriteRequestDto getProductFavoriteRequestDto) {
        boolean isLiked = productFavoriteService.getUserLikeStatus(getProductFavoriteRequestDto);
        return ResponseEntity.ok(isLiked);
    }
}
