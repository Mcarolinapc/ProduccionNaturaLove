package com.NaturaLove.ProductNaturaLove.Go.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taller {
    @Id
    private String id;
    private String description;
    private String link;
    private int precio;

    @OneToMany(mappedBy = "taller", cascade = CascadeType.ALL)
    private List<DetallePedido>detallePedidos = new ArrayList<>();

    public void addDetallePedido (DetallePedido detallePedido) {
       this.getDetallePedidos().add(detallePedido);
        //detallePedido.setTaller(this);
    }

}
