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
    @Autowired
    PedidoService pedidoService;
    @Autowired
    TallerService tallerService;
    @Autowired
    ProductService productService;
    @Autowired
    DetallePedidoService detallePedidoService;

    @RequestMapping("/populatec")
    public String populateCliente(){

        clienteService.populate();

        return "ok";
    }
    @RequestMapping("/populatepr")
    public String populateProductos(){

    productService.createFakeProductos();

        return "ok";
    }
    @RequestMapping("/populatet")
    public String populattalleres(){


        productService.populateProductos();

        return "ok";
    }
    @RequestMapping("/populatep")
    public String populatepedidos(){
        pedidoService.populate();

        return "ok";
    }

    @RequestMapping("/crea")
    public String populatetaller() {
        tallerService.createFakeTalleres();

        return "ya esta ";
    }

        @RequestMapping("/sueña")
        public String populatetalleress() {
            tallerService.populateTalleres();

            return "go ";
        }

    @RequestMapping("/DETALLE")
    public String populatedetalle() {
       detallePedidoService.createFakeDetallePedidos();

        return "ya esta ";
    }

    @RequestMapping("/detalleCreado")
    public String populatetalles() {
        detallePedidoService.populateDettalles();

        return "go ";
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