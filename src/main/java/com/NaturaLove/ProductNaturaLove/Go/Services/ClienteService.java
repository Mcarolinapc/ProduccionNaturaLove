package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Cliente;
import com.NaturaLove.ProductNaturaLove.Go.Model.Pedido;
import com.NaturaLove.ProductNaturaLove.Go.Model.Producto;
import com.NaturaLove.ProductNaturaLove.Go.Repository.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PedidoService pedidoService;



    /*public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Iterable <Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(String id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer with id " + id + " does not exist.");
        }
    }

     */


    public void populate() {

        // locale in english
        Faker faker = new Faker(new Locale("Spain"));

        List<Pedido> pedidos;

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <20 ; i++ ) {

            uniqueID = UUID.randomUUID().toString();
            Cliente cliente = new Cliente();
            cliente.setId(uniqueID);
            cliente.setNombre(faker.artist().name());
            cliente.setApellidos(faker.name().lastName());
            cliente.setDireccion(faker.address().fullAddress());
            cliente.setMail(faker.internet().emailAddress());
            cliente.setPhone(faker.phoneNumber().cellPhone());

            pedidos = pedidoService.createFakePedidos();
            for (int j = 0; j < 3; j++) {
                cliente.addPedido(pedidos.get(j));
            }

            customerRepository.save(cliente);

        }
    }


}
