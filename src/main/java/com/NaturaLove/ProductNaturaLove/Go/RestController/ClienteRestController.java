package com.NaturaLove.ProductNaturaLove.Go.RestController;

import com.NaturaLove.ProductNaturaLove.Go.Model.Cliente;
import com.NaturaLove.ProductNaturaLove.Go.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public Cliente addCustomer(@RequestBody Cliente cliente) {
        return clienteService.saveCustomer(cliente);
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
    public Cliente updateCustomer(@PathVariable String id, @RequestBody Cliente cliente) {
        return clienteService.updateCustomer(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        clienteService.deleteCustomerById(id);
    }
}