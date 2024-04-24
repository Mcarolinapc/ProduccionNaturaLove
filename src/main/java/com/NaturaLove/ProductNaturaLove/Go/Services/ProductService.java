package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Productos;
import com.NaturaLove.ProductNaturaLove.Go.Repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

import java.util.Locale;


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






