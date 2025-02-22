package com.restaurante.restaurante.model.repositories;

import com.restaurante.restaurante.model.entities.CarrinhoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoItemRepository extends JpaRepository<CarrinhoItem, Long> {

}
