package com.project.pet.controller.admin;

import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingCountAdminRequestDto;
import com.project.pet.dto.admin.outgoingProduct.request.GetProductOutgoingStocksAdminRequestDto;
import com.project.pet.service.admin.ProductOutgoingAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ProductOutgoingAdminController {

    @Autowired
    ProductOutgoingAdminService productOutgoingAdminService;

    // 관리자 상품 출고 테이블 조회(다건)
    @GetMapping("/outgoing/stocks")
    public ResponseEntity<?> getProductOutgoingStocksAdmin(GetProductOutgoingStocksAdminRequestDto getProductOutgoingStocksAdminRequestDto) {
        return ResponseEntity.ok(productOutgoingAdminService.getProductOutgoingStocksAdmin(getProductOutgoingStocksAdminRequestDto));
    }

    // 관리자 상품 출고 테이블 페이지네이션 조회
    @GetMapping("/outgoing/count")
    public ResponseEntity<?> getProductOutgoingCountAdmin(GetProductOutgoingCountAdminRequestDto getProductOutgoingCountAdminRequestDto) {
        return ResponseEntity.ok(productOutgoingAdminService.getProductOutgoingCountAdmin(getProductOutgoingCountAdminRequestDto));
    }

}
