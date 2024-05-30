package com.NaturaLove.ProductNaturaLove.Go.Services;
import com.NaturaLove.ProductNaturaLove.Go.Model.Cliente;
import com.NaturaLove.ProductNaturaLove.Go.Model.Pedido;
import com.NaturaLove.ProductNaturaLove.Go.Repository.DetallePedidoRepository;
import com.NaturaLove.ProductNaturaLove.Go.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

import java.util.*;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    /*public Pedido savePedido(Pedido pedido) {
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

     */

    public List<Pedido> createFakePedidos() {

        // locale in english
        Faker faker = new Faker(new Locale("Spain"));
        Date date = new Date();
        List<Pedido> pedidos = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            uniqueID = UUID.randomUUID().toString();
            Pedido pedido = new Pedido(uniqueID,
                    date.toString(),
                    null,
                    null);

            pedidos.add(pedido);

        }
        return pedidos;
    }
    public List<Pedido> populate() {

        List<Pedido> pedidos = createFakePedidos();

        for (int i = 0; i <10 ; i++ ){
            pedidoRepository.save(pedidos.get(i));
            pedidos.add(pedidos.get(i));
        }

        return pedidos;

    }

}
