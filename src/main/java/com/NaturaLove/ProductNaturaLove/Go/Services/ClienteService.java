package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Cliente;
import com.NaturaLove.ProductNaturaLove.Go.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    CustomerRepository customerRepository;

    public Cliente saveCustomer(Cliente cliente) {
        return customerRepository.save(cliente);
    }

    public Iterable <Cliente> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Cliente> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    public Cliente updateCustomer(String id, Cliente cliente) {
        if (customerRepository.existsById(id)) {
            cliente.setId(id);
            return customerRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Customer with id " + id + " does not exist.");
        }
    }
}
