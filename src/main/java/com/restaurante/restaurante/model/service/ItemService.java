package com.restaurante.restaurante.model.service;

import com.restaurante.restaurante.model.entities.Item;
import com.restaurante.restaurante.model.entities.TipoPedido;
import com.restaurante.restaurante.model.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public List<Item> findByTipoPedido(TipoPedido tipoPedido) {
        return itemRepository.findItemByTipoPedido(tipoPedido);
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).get();
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void delete(Item item) {
        itemRepository.delete(item);
    }
}
