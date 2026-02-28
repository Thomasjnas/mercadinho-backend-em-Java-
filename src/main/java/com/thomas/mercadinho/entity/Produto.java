package com.thomas.mercadinho.entity;

import jakarta.persistence.*;

// Essa classe vira uma tabela no banco (JPA/Hibernate)
@Entity
@Table(name = "produto")
public class Produto {

    // ID auto-increment (gerado pelo banco)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do produto (ex: Arroz)
    @Column(nullable = false)
    private String nome;

    // Preço do produto (ex: 25.50)
    @Column(nullable = false)
    private Double preco;

    // Quantidade em estoque
    @Column(nullable = false)
    private Integer quantidade;

    // Categoria (ex: Alimentos, Bebidas, Casa)
    // Pode ser null por enquanto
    private String categoria;

    // URL da imagem (ex: https://.../arroz.png)
    // Pode ser null por enquanto
    private String imagemUrl;

    // Construtor vazio (obrigatório pro JPA)
    public Produto() {}

    // (Opcional) Construtor útil pra criar objetos rapidamente
    public Produto(String nome, Double preco, Integer quantidade, String categoria, String imagemUrl) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    // =========================
    // GETTERS
    // =========================
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    // =========================
    // SETTERS
    // =========================
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}