package com.NaturaLove.ProductNaturaLove.Go.RestController;


import com.NaturaLove.ProductNaturaLove.Go.Model.Productos;
import com.NaturaLove.ProductNaturaLove.Go.Services.CustomerService;
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
    CustomerService customerService;

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

    public Iterable<Productos> getAllTiendaNaturaloves () {

        return productService.getAllTiendaNaturaloves();


    }
}