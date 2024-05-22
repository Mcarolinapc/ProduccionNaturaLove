package com.NaturaLove.ProductNaturaLove.Go.Services;

import com.NaturaLove.ProductNaturaLove.Go.Model.DetallePedido;
import com.NaturaLove.ProductNaturaLove.Go.Model.Producto;
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

    // private String id;
    //    private String idPedido;
    //    private String idProducto;
    //    private int cantidad;
    //    private int precio;

    public List<DetallePedido> createFakeDetallePedidos() {


        // locale in english
        Faker faker = new Faker(new Locale("Spanish"));
        List<DetallePedido> detallePedidos = new ArrayList<>();

        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i < 10; i++) {

            uniqueID = UUID.randomUUID().toString();
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setId(uniqueID);
            //detallePedido.setIdProducto(uniqueID);
            detallePedido.setCantidad(faker.number().numberBetween(0, 10));
            detallePedido.setPrecio(faker.number().numberBetween(5, 20));

            detallePedidos.add(detallePedido);

        }

        return detallePedidos;




    }

    //lleno base de Datos
    public List<DetallePedido> populateDettalles() {

        List<DetallePedido> detallePedidos = createFakeDetallePedidos();

        for (int i = 0; i < 10; i++) {
            detallePedidoRepository.save(detallePedidos.get(i));
            detallePedidos.add(detallePedidos.get(i));
        }

        return detallePedidos;


    }
}
