package com.NaturaLove.ProductNaturaLove.Go.RestController;


import com.NaturaLove.ProductNaturaLove.Go.Model.Producto;
import com.NaturaLove.ProductNaturaLove.Go.Services.ClienteService;
import com.NaturaLove.ProductNaturaLove.Go.Services.ProductService;
import com.NaturaLove.ProductNaturaLove.Go.Repository.CustomerRepository;
import com.NaturaLove.ProductNaturaLove.Go.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;
    @Autowired
    ClienteService clienteService;

    @Autowired
    ProductRepository simulationProductRepository;

    @Autowired
    CustomerRepository simulationCustomerRepository;
    @RequestMapping("/DataBaseProdutcs") //creo los datos Json

    public String Product() {

        productService.DataBaseProducts();


        return " los datos de Simulations";
    }

    @RequestMapping("/Products")  //visualizo los datos json

    public Iterable<Producto> getAllTiendaNaturaloves () {

        return productService.getAllTiendaNaturaloves();


    }
}