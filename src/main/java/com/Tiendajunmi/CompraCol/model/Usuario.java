package com.Tiendajunmi.CompraCol.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String password;
    private String telefono;
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;


}
