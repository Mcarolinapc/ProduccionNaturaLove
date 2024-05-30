package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Taller;
import com.NaturaLove.ProductNaturaLove.Go.Repository.TallerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service

public class TallerService {

    @Autowired
    TallerRepository tallerRepository;

    public Taller createFakeTaller() {

        // locale in Spanish
        Faker faker = new Faker(new Locale("Spanish"));

        // ref variable creation UUID
        String uniqueID;

        uniqueID = UUID.randomUUID().toString();
        Taller taller=new Taller();
        taller.setId(uniqueID);
        taller.setDescription(faker.artist().name());
        taller.setPrecio(faker.number().numberBetween(20,50));
        taller.setLink(faker.internet().url());

        tallerRepository.save(taller);
        return taller;
    }

    //lleno base de Datos
/**
   public List<Taller> populateTalleres() {

        List<Taller> talleres = createFakeTaller();

        for (int i = 0; i <5 ; i++ ) {
            tallerRepository.save(talleres.get(i));
            talleres.add(talleres.get(i));
        }

        return talleres;
    }
**/



}
