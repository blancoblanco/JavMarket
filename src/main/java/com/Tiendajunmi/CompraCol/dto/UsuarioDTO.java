package com.Tiendajunmi.CompraCol.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String correo;
    private String password;
    private String telefono;
    private String direccion;
    private List<CompraDTO> compras;

}

