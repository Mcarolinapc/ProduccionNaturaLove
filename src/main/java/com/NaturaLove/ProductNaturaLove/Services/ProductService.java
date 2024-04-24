package com.NaturaLove.ProductNaturaLove.Services;

import com.NaturaLove.ProductNaturaLove.Model.Productos;
import com.NaturaLove.ProductNaturaLove.Repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class ProductService {
    @Autowired
    ProductRepository simulationTiendaRepository;



    public Iterable<Productos> getAllTiendaNaturaloves () {

        return simulationTiendaRepository.findAll();
    }



        public void DataBaseProducts() {




        }





}






