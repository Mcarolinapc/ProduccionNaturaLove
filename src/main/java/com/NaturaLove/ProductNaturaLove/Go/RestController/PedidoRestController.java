package com.NaturaLove.ProductNaturaLove.Go.RestController;

import com.NaturaLove.ProductNaturaLove.Go.Model.Pedido;
import com.NaturaLove.ProductNaturaLove.Go.Repository.PedidoRepository;
import com.NaturaLove.ProductNaturaLove.Go.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PedidoRestController {
    @Autowired
    PedidoService pedidoService;
    @Autowired
    PedidoRepository pedidoRepository;

    @RequestMapping("/createFakePedidos")
    public String CreateFakeepedidos() {
        pedidoService.createFakePedidos();

        return "Creado el Fake Pedidos";
    }
    @RequestMapping("/populatePedidos")
    public String PopulateFakeepedidos() {
        pedidoService.createFakePedidos();

        return "populado el Fake Pedidos";
    }

    @DeleteMapping("/delete")
    public String deleteSimulation(@RequestParam String id) {

        //System.out.println("id:" + id);
        Optional<Pedido> simulationFound = pedidoRepository.findById(id);
        long countBefore = pedidoRepository.count();
        //System.out.println("simulationFound:" + simulationFound);

        if (simulationFound.isPresent()){
            pedidoRepository.deleteById(id);
            long countAfter = pedidoRepository.count();
            String response = "simulation deleted: " + id + " count: " + countBefore + "/" + countAfter;
            return response;
        } else return "id: " + id +  " not found " + " count: " + countBefore;

    }



}
