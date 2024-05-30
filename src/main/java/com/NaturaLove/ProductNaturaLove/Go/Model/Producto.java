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
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

   @Id
    private String id;
    private String nombreproduct;
    private int Quantity;
    private String description;
    private int precio;

 @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
 private List<DetallePedido> detallePedidos = new ArrayList<>();

 }





