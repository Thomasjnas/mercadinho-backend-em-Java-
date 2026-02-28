package com.thomas.mercadinho.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

// Rota protegida (por padrão, precisa estar logado)
@RestController
public class CheckoutController {

    // Recebe um “pedido” e devolve pagamento OK (mock)
    @PostMapping("/checkout")
    public Map<String, Object> checkout(@RequestBody Map<String, Object> payload) {

        // Aqui você poderia salvar em banco depois (Pedido/Itens)
        String pedidoId = UUID.randomUUID().toString().substring(0, 8);

        return Map.of(
            "status", "PAID",
            "pedidoId", pedidoId,
            "payloadRecebido", payload
        );
    }
}