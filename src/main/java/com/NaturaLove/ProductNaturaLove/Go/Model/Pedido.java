package com.NaturaLove.ProductNaturaLove.Go.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {

    @Id
    private String id;
    private String fecha;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_FK")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void addDetallePedido(DetallePedido detallePedido) {
        this.getDetallePedidos().add(detallePedido);
        detallePedido.setPedido(this);
    }




    }






