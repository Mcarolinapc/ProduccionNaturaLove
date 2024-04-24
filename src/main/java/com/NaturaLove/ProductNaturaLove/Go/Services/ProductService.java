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

            Faker faker = new Faker(new Locale("en-GB"));
            Date date = new Date();

            // ref variable creation UUID
            String uniqueID;

            for (int i = 0; i <10 ; i++ ){

                uniqueID = UUID.randomUUID().toString();
                simulationTiendaRepository.save(
                        new Productos( uniqueID,
                                date.toString(),
                                faker.number().numberBetween(100, 1250),
                                faker.artist().name() ));


            }

        }





}






