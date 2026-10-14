package com.dadoLivre.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService usuarioService;

    @Autowired
    private CustomSuccessHandler successHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        // ✅ CORRIGIDO: construtor vazio + setters (construtor com UserDetailsService
        //    foi removido no Spring Security 6.3)
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usuarioService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                // Áreas públicas
                .requestMatchers(
                    "/",
                    "/index.html",
                    "/dadolivre/cad",
                    "/dadolivre/login",
                    "/h2-console/**",
                    "/js/**",
                    "/css/**"
                ).permitAll()
                .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                // Leitura de candidatos é pública (RF01, RF04, RF05, RF06)
                .requestMatchers(HttpMethod.GET, "/api/candidatos/**").permitAll()

                // Escrita/exclusão restrita ao ADMIN
                .requestMatchers(HttpMethod.POST, "/api/candidatos/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/api/candidatos/**").hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/api/candidatos/**").hasRole("ADMINISTRADOR")
                .requestMatchers("/dadolivre/eleitor/**").hasRole("ELEITOR")
                .requestMatchers("/dadolivre/admin/**").hasRole("ADMINISTRADOR")
                .requestMatchers("/usuarios").hasRole("ADMINISTRADOR")

                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/dadolivre/login")
                .loginProcessingUrl("/perform_login")
                .usernameParameter("email")
                .passwordParameter("senha")
                .successHandler(successHandler)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/dadolivre/logout")
                .logoutSuccessUrl("/dadolivre/login?logout")
                .permitAll()
            )
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}
