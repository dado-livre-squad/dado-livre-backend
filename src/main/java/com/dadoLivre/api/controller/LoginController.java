package com.dadoLivre.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dadoLivre.api.dto.login.LoginRequestDTO;
import com.dadoLivre.api.dto.login.LoginResponseDTO;
import com.dadoLivre.api.service.LoginService;

@RestController 
@RequestMapping("api/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
        @RequestBody 
        LoginRequestDTO dto
    ) {
        return loginService.login(dto);
    }
}
