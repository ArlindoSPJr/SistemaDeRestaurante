package com.restaurante.restaurante.model.repositories;

import com.restaurante.restaurante.model.entities.Item;
import com.restaurante.restaurante.model.entities.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemByTipoItem(TipoItem tipoPedido);
}
