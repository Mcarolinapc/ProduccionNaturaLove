package com.NaturaLove.ProductNaturaLove.Go.RestController;

import com.NaturaLove.ProductNaturaLove.Go.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @RequestMapping("/creapr")
    public String creaProductos() {

        productService.createFakeProductos();

        return "ok";
    }

    @RequestMapping("/populatepr")
    public String populateProductos() {

        productService.populateProductos();

        return "ok";
    }
}
