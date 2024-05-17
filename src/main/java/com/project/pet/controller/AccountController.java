package com.project.pet.controller;

import com.project.pet.aop.annotation.ValidAspect;
import com.project.pet.dto.account.request.AccountEditNicknameRequestDto;
import com.project.pet.dto.account.request.AccountEditPasswordRequestDto;
import com.project.pet.dto.account.request.AccountEditProfileImageUrlRequestDto;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/principal")
    public ResponseEntity<?> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return ResponseEntity.ok(principalUser);
    }

    @ValidAspect
    @PutMapping("/edit/password")
    public ResponseEntity<?> editPassword (@Valid @RequestBody AccountEditPasswordRequestDto accountEditPasswordRequestDto, BindingResult bindingResult) {
        accountService.editPassword(accountEditPasswordRequestDto);
        return ResponseEntity.ok(true);
    }


    @ValidAspect
    @PutMapping("/edit/nickname/profileImg")
    public ResponseEntity<?> editNicknameAndProfileImageUrl (@Valid @RequestBody AccountEditNicknameRequestDto accountEditNicknameRequestDto, BindingResult bindingResult) {
        accountService.editNicknameAndProfileImageUrl(accountEditNicknameRequestDto);
        return ResponseEntity.ok(true);
    }
}
