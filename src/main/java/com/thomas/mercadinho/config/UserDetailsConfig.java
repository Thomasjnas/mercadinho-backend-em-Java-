package com.thomas.mercadinho.config;

import com.thomas.mercadinho.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// Aqui a gente ensina o Spring Security a carregar usuário pelo email no banco.
@Configuration
public class UserDetailsConfig {

    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {

        return username -> usuarioRepository.findByEmail(username)
            .map(u -> User
                // username = email
                .withUsername(u.getEmail())
                // senha já está com hash no banco
                .password(u.getSenhaHash())
                // role do banco (ROLE_USER)
                .roles(u.getRole().replace("ROLE_", "")) // converte "ROLE_USER" -> "USER"
                .build()
            )
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}