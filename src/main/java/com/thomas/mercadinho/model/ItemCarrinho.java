package com.thomas.mercadinho.model;

// Representa um item dentro do carrinho
public class ItemCarrinho {

    private Long produtoId;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public ItemCarrinho(Long produtoId, String nome, Double preco, Integer quantidade) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getProdutoId() { return produtoId; }
    public String getNome() { return nome; }
    public Double getPreco() { return preco; }
    public Integer getQuantidade() { return quantidade; }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}