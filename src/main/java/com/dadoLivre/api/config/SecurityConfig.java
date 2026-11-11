package com.dadoLivre.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desativa a proteção CSRF, que é padrão para formulários web, mas atrapalha APIs REST
                .csrf(csrf -> csrf.disable())

                // Define que a API não vai guardar estado/sessão do usuário na memória
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Desativa a tela HTML de login automático
                .formLogin(form -> form.disable())

                // Desativa pop-up de login do próprio navegador
                .httpBasic(basic -> basic.disable())

                // Temporariamente libera todos os endpoints para conseguir testar a API
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }
}
