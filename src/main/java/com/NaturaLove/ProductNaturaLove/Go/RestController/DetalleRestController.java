package com.NaturaLove.ProductNaturaLove.Go.RestController;

import com.NaturaLove.ProductNaturaLove.Go.Model.DetallePedido;
import com.NaturaLove.ProductNaturaLove.Go.Services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalleRestController {

    @Autowired
    DetallePedidoService detallePedidoService;

    @RequestMapping("/detalleCreado")
    public String creaDetallePedido() {
        detallePedidoService.createFakeDetallePedido();

        return "go ";
    }
    @RequestMapping("/detallePopulado")
    public String populatetalles() {
        detallePedidoService.populateDetallePedido();

        return "ya estan ";
    }
}
