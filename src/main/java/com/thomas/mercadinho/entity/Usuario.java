package com.thomas.mercadinho.entity;

import jakarta.persistence.*;

// Essa classe vira uma tabela no banco (usuarios)
@Entity
@Table(name = "usuarios")
public class Usuario {

    // ID auto incrementado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Email será usado como "login"
    @Column(nullable = false, unique = true)
    private String email;

    // Aqui guardamos a senha já CRIPTOGRAFADA (hash)
    @Column(nullable = false)
    private String senhaHash;

    // Papel do usuário (ROLE_USER, ROLE_ADMIN etc.)
    @Column(nullable = false)
    private String role = "ROLE_USER";

    public Usuario() {}

    public Usuario(String email, String senhaHash) {
        this.email = email;
        this.senhaHash = senhaHash;
        this.role = "ROLE_USER";
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getSenhaHash() { return senhaHash; }
    public String getRole() { return role; }

    public void setEmail(String email) { this.email = email; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
    public void setRole(String role) { this.role = role; }
}