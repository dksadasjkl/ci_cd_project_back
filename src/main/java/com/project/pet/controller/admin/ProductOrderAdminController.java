package com.project.pet.controller.admin;

import com.project.pet.dto.admin.orderProduct.request.GetProductOrderDetailsAdminCountRequestDto;
import com.project.pet.dto.admin.orderProduct.request.GetProductOrderDetailsAdminRequestDto;
import com.project.pet.service.admin.ProductOrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ProductOrderAdminController {

    @Autowired
    ProductOrderAdminService productOrderAdminService;

    @GetMapping("/order")
    public ResponseEntity<?> getProductOrderDetailsAdmin(GetProductOrderDetailsAdminRequestDto getProductOrderDetailsAdminRequestDto) {
        return ResponseEntity.ok(productOrderAdminService.getProductOrderDetailsAdmin(getProductOrderDetailsAdminRequestDto));
    }

    // 관리자 애완용품 주문 현황 페이지네이션 조회(다건)
    @GetMapping("/order/count")
    public ResponseEntity<?> getProductOrderDetailsAdminCount(GetProductOrderDetailsAdminCountRequestDto getProductOrderDetailsAdminCountRequestDto) {
        return ResponseEntity.ok(productOrderAdminService.getProductOrderDetailsAdminCount(getProductOrderDetailsAdminCountRequestDto));
    }

    // 관리자 매출 현황 조회
    @GetMapping("/order/sales")
    public ResponseEntity<?> getProductOrderSalesAdmin() {
        return ResponseEntity.ok(productOrderAdminService.getProductOrderSalesAdmin());
    }

}
