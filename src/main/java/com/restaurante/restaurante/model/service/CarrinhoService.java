package com.restaurante.restaurante.model.service;

import com.restaurante.restaurante.exceptions.ResourceNotFoundException;
import com.restaurante.restaurante.model.entities.*;
import com.restaurante.restaurante.model.repositories.CarrinhoRepositoy;
import com.restaurante.restaurante.model.repositories.ClienteRepository;
import com.restaurante.restaurante.model.repositories.ItemRepository;
import com.restaurante.restaurante.model.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepositoy carrinhoRepositoy;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Carrinho adicionarItemAoCarrinho(Long clienteId,Long itemId, int quantidadeItem){

        Cliente clienteEncontrado = clienteRepository.findByClienteId(clienteId);
        if (clienteEncontrado == null) {
            throw new ResourceNotFoundException("Cliente de id: " + clienteId + " não encontrado!");
        }

        Item itemEncontrado = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado!"));

        if (itemEncontrado.getQuantidade() < quantidadeItem) {
            throw new ResourceNotFoundException("Produto sem estoque suficiente");
        }

        Carrinho carrinho = clienteEncontrado.getCarrinho();
        if (carrinho == null) {
            carrinho = new Carrinho();
            carrinho.setCliente(clienteEncontrado);
        }

        clienteEncontrado.setCarrinho(carrinho);
        CarrinhoItem carrinhoItem = new CarrinhoItem();
        carrinhoItem.setItem(itemEncontrado);
        carrinhoItem.setQuantidade(quantidadeItem);
        carrinho.addItens(carrinhoItem);
        carrinho.setValorTotal(carrinho.getValorTotal() + (itemEncontrado.getValor() * quantidadeItem));

        return carrinhoRepositoy.save(carrinho);
    }

    public Pedido finalizarCompra(Long carrinhoId){
        Carrinho carrinhoEncontrado = carrinhoRepositoy.findByCarrinhoId(carrinhoId);
        if (carrinhoEncontrado == null) {
            throw new ResourceNotFoundException("Carrinho com id: " + carrinhoId + " não encontrado!");
        }

        if (carrinhoEncontrado.getItens().isEmpty()) {
            throw new ResourceNotFoundException("Carrinho vazio. Não é possivel finalizar compra!");
        }

        Cliente clienteEncontrado = clienteRepository.findByClienteId(carrinhoEncontrado.getCliente().getClienteId());
        if (clienteEncontrado == null) {
            throw new ResourceNotFoundException("Cliente não encontrado pelo carrinho");
        }

        for (CarrinhoItem item : carrinhoEncontrado.getItens()){
            Item itemEncontrado = item.getItem();
            int novaQuantidade = itemEncontrado.getQuantidade() - item.getQuantidade();

            if (novaQuantidade < 0) {
                throw new IllegalStateException("Estoque insuficiente para o produto: " + itemEncontrado.getNome());
            }

            itemEncontrado.setQuantidade(novaQuantidade);
            itemRepository.save(itemEncontrado);
        }

        Pedido novoPedido = new Pedido();

        novoPedido.setStatusPedido(StatusPedido.CONFIRMADO);
        novoPedido.setCliente(clienteEncontrado);
        novoPedido.setValorTotal(carrinhoEncontrado.getValorTotal());
        novoPedido.setCarrinho(carrinhoEncontrado);

        carrinhoEncontrado.setFinalizado(true);
        carrinhoRepositoy.save(carrinhoEncontrado);

        return pedidoRepository.save(novoPedido);

    }

}
