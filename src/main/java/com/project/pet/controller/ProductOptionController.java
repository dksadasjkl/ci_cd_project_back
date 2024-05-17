package com.project.pet.controller;

import com.project.pet.service.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/option")
public class ProductOptionController {

    @Autowired
    private ProductOptionService productOptionService;
    @GetMapping("/types")
    public ResponseEntity<?> getProductTypes() {
        return ResponseEntity.ok(productOptionService.getAllProductTypes());
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(productOptionService.getAllCategories());
    }

    @GetMapping("/size")
    public ResponseEntity<?> getSize() {
        return ResponseEntity.ok(productOptionService.getAllSize());
    }
}
