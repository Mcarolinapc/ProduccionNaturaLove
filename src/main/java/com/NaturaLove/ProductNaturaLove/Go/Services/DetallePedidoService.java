package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.DetallePedido;
import com.NaturaLove.ProductNaturaLove.Go.Model.Taller;
import com.NaturaLove.ProductNaturaLove.Go.Repository.DetallePedidoRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoService {

    @Autowired
    DetallePedidoRepository detallePedidoRepository;
    @Autowired
    PedidoService pedidoService;
    @Autowired
    TallerService tallerService;



    private String id;
    private int cantidad;
    private int precio;

    public List<DetallePedido> createFakeDetallePedido() {
        Faker faker = new Faker(new Locale("Spanish"));

        List<DetallePedido> detallePedidos = new ArrayList<>();


        String uniqueID;

        for (int i = 0; i < 10; i++) {
            Taller taller = tallerService.createFakeTaller();

            uniqueID = UUID.randomUUID().toString();
            DetallePedido detallePedido = new DetallePedido();
                    detallePedido.setIdDetallePedido(uniqueID);
                   detallePedido.setCantidad(faker.number().numberBetween(5, 10));
                   detallePedido.setPrecio( faker.number().numberBetween(20, 50));
                   detallePedido.setTaller(taller);
                   detallePedido.setPedido(null);
                   detallePedido.setProducto(null);

            detallePedidos.add(detallePedido);

        }

        return detallePedidos;
    }

        public List<DetallePedido> populateDetallePedido () {



            List<DetallePedido> detallePedidos = createFakeDetallePedido();

            for (int i = 0; i < 10; i++) {
                detallePedidoRepository.save(detallePedidos.get(i));
                //detallePedidos.add(detallePedidos.get(i));
            }

            return detallePedidos;

        }
    }
