package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Producto;
import com.NaturaLove.ProductNaturaLove.Go.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    ProductRepository simulationTiendaRepository;



    public Iterable<Producto> getAllTiendaNaturaloves () {

        return simulationTiendaRepository.findAll();
    }



        public void DataBaseProducts() {
        }




}






