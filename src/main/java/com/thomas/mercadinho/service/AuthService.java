package com.thomas.mercadinho.service;

import com.thomas.mercadinho.entity.Usuario;
import com.thomas.mercadinho.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Registra usuário: valida email único e salva senha em formato seguro (hash)
    public Usuario registrar(String email, String senha) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("Email já cadastrado.");
        }

        // Transforma senha em hash (ex: BCrypt). Nunca salvamos senha pura.
        String hash = passwordEncoder.encode(senha);

        Usuario usuario = new Usuario(email, hash);
        return usuarioRepository.save(usuario);
    }
}