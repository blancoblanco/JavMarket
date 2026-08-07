package com.Tiendajunmi.CompraCol.dto;

import com.Tiendajunmi.CompraCol.model.Compra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String correo;
    private String password;
    private String telefono;
    private String direccion;
    private List<Compra> compras;

}

