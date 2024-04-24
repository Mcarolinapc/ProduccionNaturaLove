package com.NaturaLove.ProductNaturaLove.Go.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

     @Id
    private String id;
    private String name;
    private  String LastName;
    private  String direction;
    private String mail;
    private int phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    public void addSimulation(Pedido pedido) {
        this.getPedidos().add(pedido);
        //if (simulation.getId() != null) simulation.getId().getSimulations().remove(simulation);
        pedido.setCustomer(this);
    }

}
