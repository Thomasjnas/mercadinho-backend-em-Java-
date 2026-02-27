package com.thomas.mercadinho.controller;

import com.thomas.mercadinho.model.ItemCarrinho;
import com.thomas.mercadinho.service.CarrinhoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService service;

    public CarrinhoController(CarrinhoService service) {
        this.service = service;
    }

    // GET /carrinho
    @GetMapping
    public List<ItemCarrinho> listar() {
        return service.listar();
    }

    // POST /carrinho
    @PostMapping
    public void adicionar(@RequestBody ItemCarrinho item) {
        service.adicionar(item);
    }

    // DELETE /carrinho/{id}
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

    // DELETE /carrinho
    @DeleteMapping
    public void limpar() {
        service.limpar();
    }
}