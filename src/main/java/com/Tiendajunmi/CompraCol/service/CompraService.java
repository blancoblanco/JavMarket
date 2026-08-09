package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.dto.CompraDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService implements ICompraService{
    @Override
    public List<CompraDTO> traerCompras() {
        return List.of();
    }

    @Override
    public CompraDTO crearCompra(CompraDTO compraDTO) {
        return null;
    }

    @Override
    public CompraDTO actualizarCompra(Long id, CompraDTO CompraDTO) {
        return null;
    }

    @Override
    public void eliminarCompra(Long id) {

    }
}
