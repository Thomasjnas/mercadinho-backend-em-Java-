package com.thomas.mercadinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thomas.mercadinho.entity.Produto;

// JpaRepository já traz CRUD pronto
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}