package com.thomas.mercadinho.entity;

import jakarta.persistence.*;
import lombok.*;

// Diz que essa classe será uma tabela no banco
@Entity

// Lombok gera getters, setters automaticamente
@Data

// Construtor vazio obrigatório para o JPA
@NoArgsConstructor

// Construtor com todos os campos
@AllArgsConstructor
public class Produto {

    // Define chave primária
    @Id

    // Auto incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    private Integer quantidade;
}