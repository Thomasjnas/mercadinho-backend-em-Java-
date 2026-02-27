package com.thomas.mercadinho.controller;

import com.thomas.mercadinho.entity.Usuario;
import com.thomas.mercadinho.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

// Rotas de autenticação
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // DTO simples para receber JSON (email/senha)
    public static class RegisterRequest {
        public String email;
        public String senha;
    }

    // POST /auth/register
    // Cria um usuário no banco
    @PostMapping("/register")
    public Usuario register(@RequestBody RegisterRequest req) {
        return authService.registrar(req.email, req.senha);
    }

    // GET /auth/me
    // Rota protegida: só acessa se estiver logado.
    // Authentication vem do Spring Security (usuário autenticado)
    @GetMapping("/me")
    public Object me(Authentication auth) {
        return auth; // depois a gente retorna um DTO mais bonitinho
    }
}