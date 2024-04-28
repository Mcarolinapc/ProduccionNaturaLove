package com.NaturaLove.ProductNaturaLove.Go.Model;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Taller {
    private String id;
    private String link;
    private String description;
    private int precio;

    //cada taller esta asociado a un unico producto
    @OneToOne
    @JoinColumn(name="producto_id", referencedColumnName = "id")
    private Producto Producto;




}
