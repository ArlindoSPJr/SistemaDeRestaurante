package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.controller.dto.DadosCadastroItens;
import com.restaurante.restaurante.controller.dto.DadosDetalhamentoItens;
import com.restaurante.restaurante.model.entities.Item;
import com.restaurante.restaurante.model.service.ItemService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarItem(@RequestBody DadosCadastroItens dados,
                                        UriComponentsBuilder uriBuilder){

        try {
            var itemNovo = new Item(dados);
            itemService.save(itemNovo);

            var uri = uriBuilder.path("/item/{id}").buildAndExpand(itemNovo.getItemId()).toUri();
            return ResponseEntity.created(uri).body(new DadosDetalhamentoItens(itemNovo));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar o item.");
        }
    }
}
