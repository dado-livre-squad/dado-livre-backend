package com.dadoLivre.api.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        // ✅ CORRIGIDO: padronizado para checar apenas ROLE_ (gerado pelo getAuthorities())
        if (roles.contains("ROLE_ADMINISTRADOR")) {
            response.sendRedirect("/dadolivre/admin");
        } else if (roles.contains("ROLE_ELEITOR")) {
            response.sendRedirect("/dadolivre/eleitor");
        } else {
            response.sendRedirect("/");
        }
    }
}
