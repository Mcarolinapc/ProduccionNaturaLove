package com.NaturaLove.ProductNaturaLove.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {
   @Id
    private String id;
    private String product;
    private int Quantity;
    private String description;
    private int precio;



}
