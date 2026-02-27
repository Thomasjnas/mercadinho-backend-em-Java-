package com.thomas.mercadinho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Define o "tipo" de hash de senha que vamos usar (BCrypt é o padrão)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Regras de acesso
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // Para API, a gente desliga CSRF por enquanto (para Postman funcionar sem dor)
            .csrf(csrf -> csrf.disable())

            // Regras de autorização por rota
            .authorizeHttpRequests(auth -> auth
                // Libera cadastro sem login
                .requestMatchers("/auth/register").permitAll()

                // (Opcional) liberar H2 console se você estiver usando
                .requestMatchers("/h2-console/**").permitAll()

                // O resto exige login
                .anyRequest().authenticated()
            )

            // Basic Auth (pra testar no Postman facilmente)
            .httpBasic(httpBasic -> {});

        // Para H2 console funcionar no navegador (frames)
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}