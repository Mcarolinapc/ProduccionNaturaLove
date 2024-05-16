package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Pedido;
import com.NaturaLove.ProductNaturaLove.Go.Model.Producto;
import com.NaturaLove.ProductNaturaLove.Go.Repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


//creo base de datos fake de productos
    public List<Producto> createFakeProductos() {



        // locale in english
        Faker faker = new Faker(new Locale("Spanish"));
        List<Producto> productos = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            uniqueID = UUID.randomUUID().toString();
            Producto producto=new Producto();
            producto.setId(uniqueID);
            producto.setNombreproduct(faker.artist().name());
            producto.setQuantity(faker.number().numberBetween(0,10));
            producto.setDescription(faker.address().fullAddress());
            producto.setPrecio(faker.number().numberBetween(5,20));

            productos.add(producto);

        }

        return productos;
    }
//lleno base de Datos
    public List <Producto> populateProductos() {

        List<Producto> productos = createFakeProductos();

        for (int i = 0; i < 10; i++) {
            productRepository.save(productos.get(i));
            productos.add(productos.get(i));
        }

        return productos;


    }
}







