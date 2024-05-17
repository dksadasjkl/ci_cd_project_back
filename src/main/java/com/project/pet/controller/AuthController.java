package com.project.pet.controller;

import com.project.pet.aop.annotation.ValidAspect;
import com.project.pet.dto.auth.request.AuthNicknameCheckRequestDto;
import com.project.pet.dto.auth.request.AuthSigninRequestDto;
import com.project.pet.dto.auth.request.AuthSignupRequestDto;
import com.project.pet.dto.auth.request.AuthUsernameCheckRequestDto;
import com.project.pet.dto.oauth2.request.OAuth2SignupRequestDto;
import com.project.pet.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ValidAspect
    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@Valid @RequestBody AuthSignupRequestDto authSignupRequestDto, BindingResult bindingResult) {
        System.out.println(authSignupRequestDto);
        authService.signup(authSignupRequestDto);

        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signin(@RequestBody AuthSigninRequestDto authSigninRequestDto) {
        return ResponseEntity.created(null).body(authService.signin(authSigninRequestDto));
    }

    @ValidAspect
    @PostMapping("/oauth2/sign-up")
    public ResponseEntity<?> oAuth2Signup(@Valid @RequestBody OAuth2SignupRequestDto oAuth2SignupRequestDto, BindingResult bindingResult) {
        authService.oAuth2Signup(oAuth2SignupRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    @ValidAspect
    @PostMapping("/username-check")
    public ResponseEntity<?> usernameCheck(@Valid @RequestBody AuthUsernameCheckRequestDto authUsernameCheckRequestDto, BindingResult bindingResult) {
        return ResponseEntity.created(null).body(Map.of("username","사용할 수 있는 유저네임입니다."));
    }

    @ValidAspect
    @PostMapping("/nickname-check")
    public ResponseEntity<?> nicknameCheck(@Valid @RequestBody AuthNicknameCheckRequestDto authNicknameCheckRequestDto, BindingResult bindingResult) {
        return ResponseEntity.created(null).body(Map.of("newNickname","사용할 수 있는 닉네임입니다."));
    }

}
