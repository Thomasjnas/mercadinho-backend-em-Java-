package com.thomas.mercadinho.service;

import com.thomas.mercadinho.model.ItemCarrinho;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {

    // Lista que guarda itens do carrinho
    private final List<ItemCarrinho> itens = new ArrayList<>();

    // Retorna todos itens
    public List<ItemCarrinho> listar() {
        return itens;
    }

    // Adiciona item
    public void adicionar(ItemCarrinho item) {
        itens.add(item);
    }

    // Remove item pelo id do produto
    public void remover(Long produtoId) {
        itens.removeIf(item -> item.getProdutoId().equals(produtoId));
    }

    // Limpa carrinho
    public void limpar() {
        itens.clear();
    }
}