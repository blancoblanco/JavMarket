package com.Tiendajunmi.CompraCol.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleCompraDTO {

    private Long id;
    private Long idProd;
    private String nombreProd;
    private Integer cantProd;
    private Double precio;
    private Double subtotal;
}
