package com.restaurante.restaurante.model.repositories;

import com.restaurante.restaurante.model.entities.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepositoy extends JpaRepository<Carrinho, Integer> {
}
