package com.project.pet.controller.admin;

import com.project.pet.dto.admin.stockProduct.request.PutProductStockAdminRequestDto;
import com.project.pet.dto.admin.stockProduct.request.GetProductStocksAdminRequestDto;
import com.project.pet.dto.admin.stockProduct.request.GetProductStocksCountRequestDto;
import com.project.pet.service.admin.ProductStockAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class ProductStockAdminController {

    @Autowired
    ProductStockAdminService productStockAdminService;

    // 관리자 상품 재고 테이블 수정(단건)
    @PutMapping("/stock/{productStockId}")
    public ResponseEntity<?> putProductStockAdmin(@PathVariable int productStockId, @RequestBody PutProductStockAdminRequestDto putProductStockAdminRequestDto) {
        productStockAdminService.putProductStockAdmin(productStockId, putProductStockAdminRequestDto);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 재고 테이블 조회(다건)
    @GetMapping("/stocks")
    public ResponseEntity<?> getProductStocksAdmin(GetProductStocksAdminRequestDto getProductStocksAdminRequestDto) {
        return ResponseEntity.ok(productStockAdminService.getProductStocksAdmin(getProductStocksAdminRequestDto));
    }

    // 관리자 상품 재고 페이지네이션 조회
    @GetMapping("/stocks/count")
    public ResponseEntity<?> getProductStocksCount(GetProductStocksCountRequestDto getProductStocksCountRequestDto) {
        return ResponseEntity.ok(productStockAdminService.getProductStocksCount(getProductStocksCountRequestDto));
    }

}
