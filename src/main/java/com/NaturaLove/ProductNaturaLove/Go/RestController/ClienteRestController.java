package com.NaturaLove.ProductNaturaLove.Go.RestController;

import com.NaturaLove.ProductNaturaLove.Go.Model.Cliente;
import com.NaturaLove.ProductNaturaLove.Go.Repository.CustomerRepository;
import com.NaturaLove.ProductNaturaLove.Go.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteRestController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ClienteService clienteService;

    @RequestMapping("/populatec")
    public Iterable<Cliente> populateCliente() {

        clienteService.populate();

        return  customerRepository.findAll();

    }






















   /* @PostMapping
    public Cliente addCustomer(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @GetMapping
    public Iterable <Cliente> getAllCustomers() {
        return clienteService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Cliente getCustomerById(@PathVariable String id) {
        return clienteService.getCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer with id " + id + " not found."));
    }

    @PutMapping("/{id}")
    public Cliente updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return clienteService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        clienteService.deleteCustomerById(id);
    }*/



}