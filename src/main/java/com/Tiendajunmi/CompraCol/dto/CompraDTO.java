package com.Tiendajunmi.CompraCol.dto;

import com.Tiendajunmi.CompraCol.model.Estado;
import lombok.*;


import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraDTO {

    private Long id;
    private LocalDate fecha;
    private Estado estado;
    private  Double total;
    private List<DetalleCompraDTO> detalle;

}
