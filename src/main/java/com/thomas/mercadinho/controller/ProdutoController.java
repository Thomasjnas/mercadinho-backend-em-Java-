package com.thomas.mercadinho.controller;

import com.thomas.mercadinho.entity.Produto;
import com.thomas.mercadinho.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    // =========================
    // 1) LISTAR TODOS
    // GET /produtos
    // =========================
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // =========================
    // 2) BUSCAR POR ID
    // GET /produtos/{id}
    // ResponseEntity ajuda a retornar 404 se não achar
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)           // achou -> 200 + produto
                .orElse(ResponseEntity.notFound().build()); // não achou -> 404
    }

    // =========================
    // 3) CRIAR
    // POST /produtos
    // O @RequestBody pega o JSON do corpo da requisição
    // =========================
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        // Quando salva com id = null, o banco gera o id automaticamente
        return repository.save(produto);
    }

    // =========================
    // 4) ATUALIZAR
    // PUT /produtos/{id}
    // Atualiza apenas se existir
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto dados) {
        return repository.findById(id).map(produtoExistente -> {

            // Atualiza os campos (você pode escolher atualizar todos ou só alguns)
            produtoExistente.setNome(dados.getNome());
            produtoExistente.setPreco(dados.getPreco());
            produtoExistente.setQuantidade(dados.getQuantidade());

            // Salva de volta no banco
            Produto atualizado = repository.save(produtoExistente);

            return ResponseEntity.ok(atualizado); // 200

        }).orElse(ResponseEntity.notFound().build()); // 404 se não existir
    }

    // =========================
    // 5) DELETAR
    // DELETE /produtos/{id}
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // existsById evita dar erro ao deletar id inexistente
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build(); // 404
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 (ok, sem corpo)
    }
}