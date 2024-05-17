package com.project.pet.controller.admin;

import com.project.pet.dto.admin.incomingProduct.request.PutProductIncomingStockAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingCountAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingStocksAdminRequestDto;
import com.project.pet.dto.product.request.*;
import com.project.pet.service.admin.ProductAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductAdminController {

    @Autowired
    private ProductAdminService productAdminService;

    // [애완용품 쇼핑몰 상품]
    // 관리자 상품 등록(단건)
    @PostMapping("/admin/product")
    public ResponseEntity<?> postProductAdmin(@RequestBody PostProductAdminRequestDto postProductAdminRequestDto) {
        productAdminService.postProductAdmin(postProductAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 조회(단건)
    @GetMapping("/admin/product/{productId}")
    public ResponseEntity<?> getProductAdmin(@PathVariable int productId) {
        return ResponseEntity.ok(productAdminService.getProductAdmin(productId));
    }

    // 관리자 상품 조회(다건)
    @GetMapping("/admin/products")
    public ResponseEntity<?> getProductsAdmin(GetProductsAdminRequestDto getProductsAdminRequestDto) {
        return ResponseEntity.ok(productAdminService.getProductsAdmin(getProductsAdminRequestDto));
    }

    // 관리자 상품 페이지네이션 조회(다건)
    @GetMapping("/admin/products/count")
    public ResponseEntity<?> getProductsAdminCount(GetProductsAdminCountRequestDto getProductsAdminCountRequestDto) {
        return ResponseEntity.ok(productAdminService.getProductsAdminCount(getProductsAdminCountRequestDto));
    }

    // 관리자 상품 삭제(단건)
    @DeleteMapping("/admin/product/{productId}")
    public ResponseEntity<?> deleteProductAdmin(@PathVariable Integer productId) {
        productAdminService.deleteProductAdmin(productId);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 수정(단건)
    @PutMapping("/admin/product/{productId}")
    public ResponseEntity<?> putProductAdmin(@PathVariable Integer productId, @RequestBody PutProductAdminRequestDto putProductAdminRequestDto) {
        productAdminService.putProductAdmin(productId, putProductAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 삭제(다건)
    @DeleteMapping("/admin/products")
    public ResponseEntity<?> deleteProductsAdmin(@RequestBody List<Integer> productIds) {
        productAdminService.deleteProductsAdmin(productIds);
        return ResponseEntity.ok(true);
    }

    //[애완용품 쇼핑몰 가입고]
    @GetMapping("admin/incoming/stocks/test")
    public ResponseEntity<?> getProductIncomingStocksTest(GetProductIncomingStocksTestRequestDto getProductIncomingStocksTestRequestDto) {
        return ResponseEntity.ok(productAdminService.getProductIncomingStocksTest(getProductIncomingStocksTestRequestDto));
    }

    // 관리자 상품 가입고 테이블 조회(단건)
    @GetMapping("admin/incoming/stock/{productIncomingStockId}")
    public ResponseEntity<?> getProductIncomingStock(@PathVariable int productIncomingStockId) {
        return ResponseEntity.ok(productAdminService.getProductIncomingStock(productIncomingStockId));
    }

    // 관리자 상품 가입고 테이블 삭제(단건)
    @DeleteMapping("admin/incoming/stock/{productIncomingStockId}")
    public ResponseEntity<?> deleteProductIncomingStock(@PathVariable int productIncomingStockId) {
        productAdminService.deleteProductIncomingStock(productIncomingStockId);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 가입고 테이블 수정(단건)
    @PutMapping("admin/incoming/stock/{productIncomingStockId}")
    public ResponseEntity<?> putProductIncomingStockAdmin(@PathVariable int productIncomingStockId, @RequestBody PutProductIncomingStockAdminRequestDto putProductIncomingStockAdminRequestDto) {
        productAdminService.putProductIncomingStockAdmin(productIncomingStockId, putProductIncomingStockAdminRequestDto);
        return ResponseEntity.ok(true);
    }

    // [애완용품 쇼핑몰 재고]
    // 관리자 상품 재고 테이블 등록(단건)
    @PostMapping("admin/stock")
    public ResponseEntity<?> postProductStockAdmin(@RequestBody PostProductStockAdminRequestDto postProductStockAdminRequestDto) {
        productAdminService.postProductStockAdmin(postProductStockAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 재고 테이블 조회(단건)
    @GetMapping("admin/stock/{productStockId}")
    public ResponseEntity<?> getProductStockAdmin(@PathVariable int productStockId) {
        return ResponseEntity.ok(productAdminService.getProductStockAdmin(productStockId));
    }

    // 관리자 상품 재고 테이블 삭제(단건)
    @DeleteMapping("admin/stock/{productStockId}")
    public ResponseEntity<?> deleteProductStockAdmin(@PathVariable int productStockId) {
        productAdminService.deleteProductStockAdmin(productStockId);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 재고 테이블 삭제(다건)
    @DeleteMapping("admin/stocks")
    public ResponseEntity<?> deleteProductStocksAdmin(@RequestBody List<Integer> productStockIds) {
        productAdminService.deleteProductStocksAdmin(productStockIds);
        return ResponseEntity.ok(true);
    }

    // [애완용품 쇼핑몰 출고 재고]
    // 관리자 상품 출고 테이블 등록(단건)
    @PostMapping("admin/outgoing/stock")
    public ResponseEntity<?> postProductOutgoingStockAdmin(@RequestBody PostProductOutgoingStockAdminRequestDto postProductOutgoingStockAdminRequestDto) {
        productAdminService.postProductOutgoingStockAdmin(postProductOutgoingStockAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 출고 테이블 조회(다건)
    @GetMapping("admin/outgoing/stocks")
    public ResponseEntity<?> getProductOutgoingStocksAdmin(GetProductOutgoingStocksAdminRequestDto getProductOutgoingStocksAdminRequestDto) {
        return ResponseEntity.ok(productAdminService.getProductOutgoingStocksAdmin(getProductOutgoingStocksAdminRequestDto));
    }

    // 관리자 상품 출고 테이블 페이지네이션 조회
    @GetMapping("admin/outgoing/count")
    public ResponseEntity<?> getProductOutgoingCountAdmin(GetProductOutgoingCountAdminRequestDto getProductOutgoingCountAdminRequestDto) {
        return ResponseEntity.ok(productAdminService.getProductOutgoingCountAdmin(getProductOutgoingCountAdminRequestDto));
    }

    // 관리자 상품 출고 테이블 삭제(단건)
    @DeleteMapping("admin/outgoing/stock/{productOutgoingStockId}")
    public ResponseEntity<?> deleteProductOutgoingStockAdmin(@PathVariable int productOutgoingStockId) {
        productAdminService.deleteProductOutgoingStockAdmin(productOutgoingStockId);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 출고 테이블 삭제(다건)
    @DeleteMapping("admin/outgoing/stocks")
    public ResponseEntity<?> deleteProductOutgoingStocksAdmin(@RequestBody List<Integer> productOutgoingStockIds){
        productAdminService.deleteProductOutgoingStocksAdmin(productOutgoingStockIds);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 출고 테이블 수정(단건)
    @PutMapping("admin/outgoing/stock/{productOutgoingStockId}")
    public ResponseEntity<?> putProductOutgoingStockAdmin(@PathVariable int productOutgoingStockId, @RequestBody PutProductOutgoingStockAdminRequestDto putProductOutgoingStockAdminRequestDto) {
        productAdminService.putProductOutgoingStockAdmin(productOutgoingStockId, putProductOutgoingStockAdminRequestDto);
        return ResponseEntity.ok(true);
    }
}
