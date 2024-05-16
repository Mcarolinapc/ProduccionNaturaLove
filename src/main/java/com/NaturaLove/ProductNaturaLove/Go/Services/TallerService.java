package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.Producto;
import com.NaturaLove.ProductNaturaLove.Go.Model.Taller;
import com.NaturaLove.ProductNaturaLove.Go.Repository.TallerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class TallerService {

    @Autowired
    TallerRepository tallerRepository;

    public List<Taller> createFakeTalleres() {

        // locale in Spanish
        Faker faker = new Faker(new Locale("Spanish"));
        List<Taller> talleres = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            uniqueID = UUID.randomUUID().toString();
            Taller taller=new Taller();
            taller.setId(uniqueID);
            taller.setDescription(faker.artist().name());
            taller.setPrecio(faker.number().numberBetween(20,50));
            taller.setLink(faker.internet().url());

            talleres.add(taller);


        }
        return talleres;
    }
    //lleno base de Datos
    public List<Taller> populateTalleres() {

        List<Taller> talleres = createFakeTalleres();

        for (int i = 0; i <50 ; i++ ) {
            tallerRepository.save(talleres.get(i));
            talleres.add(talleres.get(i));
        }

        return talleres;
    }




}
