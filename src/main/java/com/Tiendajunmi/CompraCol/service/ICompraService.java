package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.dto.CompraDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ICompraService {
    List<CompraDTO>  traerCompras();
    CompraDTO crearCompra(CompraDTO compraDTO);
    CompraDTO actualizarCompra(Long id,CompraDTO CompraDTO);
    ResponseEntity<Map<String,Boolean>> eliminarCompra(Long id);
}
