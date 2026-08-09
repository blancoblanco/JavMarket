package com.Tiendajunmi.CompraCol.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private  int stock;
    private Double precio;
    private List<CategoriaDTO> categorias;
}
