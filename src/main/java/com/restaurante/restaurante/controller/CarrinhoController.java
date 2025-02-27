package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.controller.dto.AddItensNoCarrinhoDto;
import com.restaurante.restaurante.controller.dto.DadosDetalhamentoCarrinho;
import com.restaurante.restaurante.controller.dto.DadosDetalhamentoPedido;
import com.restaurante.restaurante.model.service.CarrinhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    public ResponseEntity adicionarItemAoCarrinho(@RequestBody AddItensNoCarrinhoDto dados){
        var carrinho = carrinhoService.adicionarItemAoCarrinho(dados.clienteId(), dados.itemId(), dados.quantidade());

        return ResponseEntity.ok().body(new DadosDetalhamentoCarrinho(carrinho));
    }

    @PostMapping("/finalizar/{carrinhoId}")
    public ResponseEntity finalizarCompra(@PathVariable long carrinhoId){
        var pedido = carrinhoService.finalizarCompra(carrinhoId);
        return ResponseEntity.ok().body(new DadosDetalhamentoPedido(pedido));
    }
}
