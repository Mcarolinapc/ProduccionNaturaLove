package com.NaturaLove.ProductNaturaLove.Go.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

   @Id
    private String id;
    private String nombreproduct;
    private int Quantity;
    private String description;
    private int precio;

    //con esta referencia one to many: un producto puede  tener una lista de talleres asociados.
    @OneToMany(mappedBy = "producto")
     private List<Taller>talleres;









     //referencia a un producto puede estar en varios pedidos
    //@JsonIgnore
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PEDIDO_FK")
    private Pedido pedido ;*/

}
