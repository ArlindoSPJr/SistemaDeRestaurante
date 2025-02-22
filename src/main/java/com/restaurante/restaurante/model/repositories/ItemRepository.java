package com.restaurante.restaurante.model.repositories;

import com.restaurante.restaurante.model.entities.Item;
import com.restaurante.restaurante.model.entities.TipoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemByTipoPedido(TipoPedido tipoPedido);
}
