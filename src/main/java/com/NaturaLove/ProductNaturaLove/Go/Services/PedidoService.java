package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Customer;
import com.NaturaLove.ProductNaturaLove.Go.Model.Pedido;
import com.NaturaLove.ProductNaturaLove.Go.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Iterable <Pedido> getAllCustomers() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getCustomerById(String id) {
        return pedidoRepository.findById(id);
    }

    public void deletePedidoById(String id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido updatePedido(String id, Pedido pedido) {
        if (pedidoRepository.existsById(id)) {
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        } else {
            throw new IllegalArgumentException("Customer with id " + id + " does not exist.");
        }
    }
}

