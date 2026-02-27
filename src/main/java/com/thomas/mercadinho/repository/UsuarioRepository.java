package com.thomas.mercadinho.repository;

import com.thomas.mercadinho.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interface de acesso ao banco
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Vamos buscar por email (login)
    Optional<Usuario> findByEmail(String email);

    // Ajuda no cadastro (ver se já existe)
    boolean existsByEmail(String email);
}