package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.dto.CompraDTO;

import java.util.List;

public interface ICompraService {
    List<CompraDTO>  traerCompras();
    CompraDTO crearCompra(CompraDTO compraDTO);
    CompraDTO actualizarCompra(Long id,CompraDTO CompraDTO);
    void eliminarCompra(Long id);
}
