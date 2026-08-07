package com.Tiendajunmi.CompraCol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private  int stock;
    private Double precio;
    @ManyToMany
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompra;

}
