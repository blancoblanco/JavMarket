package com.Tiendajunmi.CompraCol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //compra
    @ManyToOne
    private Compra compra;
    //producto
    @ManyToOne
    private  Producto producto;
    private  Integer cantProd;
    private Double precio;

}
