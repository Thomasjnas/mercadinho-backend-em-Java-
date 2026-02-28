package com.thomas.mercadinho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // ATIVA CORS dentro do Spring Security
            .cors(cors -> {})

            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
    .requestMatchers("/auth/register").permitAll()
    .requestMatchers("/h2-console/**").permitAll()

    // ✅ Libera só leitura de produtos (catálogo)
    .requestMatchers(HttpMethod.GET, "/produtos/**").permitAll()

    // 🔒 Todo o resto exige login
    .anyRequest().authenticated()
)

            .httpBasic(basic -> {});

        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

    // CONFIGURAÇÃO GLOBAL CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        // endereço do React
        config.setAllowedOrigins(List.of("http://localhost:5173"));

        // métodos permitidos
        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));

        // headers permitidos
        config.setAllowedHeaders(List.of("*"));

        // permitir envio de credenciais (importantíssimo para auth)
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}