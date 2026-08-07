package com.Tiendajunmi.CompraCol.dto;

import com.Tiendajunmi.CompraCol.model.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {

    private Long id;
    private LocalDate fecha;
    private Estado estado;
    private  Double total;
    private List<DetalleCompraDTO> detalle;

}
