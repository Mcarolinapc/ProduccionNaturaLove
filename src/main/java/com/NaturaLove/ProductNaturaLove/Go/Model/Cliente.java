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
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String mail;
    private String phone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido) {
        this.getPedidos().add(pedido);
        pedido.setCliente(this);
    }

}
