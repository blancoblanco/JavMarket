package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.mapper.Mapper;
import com.Tiendajunmi.CompraCol.dto.CompraDTO;
import com.Tiendajunmi.CompraCol.dto.DetalleCompraDTO;
import com.Tiendajunmi.CompraCol.exception.NotFoundException;
import com.Tiendajunmi.CompraCol.model.Compra;
import com.Tiendajunmi.CompraCol.model.DetalleCompra;
import com.Tiendajunmi.CompraCol.model.Producto;
import com.Tiendajunmi.CompraCol.repository.CompraRepository;
import com.Tiendajunmi.CompraCol.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompraService implements ICompraService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CompraRepository compraRepository;


    @Override
    public List<CompraDTO> traerCompras() {
        return compraRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public CompraDTO crearCompra(CompraDTO compraDTO) {

        if (compraDTO == null) throw new RuntimeException("compraDTO esta vacia");
        if (compraDTO.getDetalle() == null || compraDTO.getDetalle().isEmpty())
            throw new RuntimeException("el detalle esta vacio");
        //crear compra
        Compra compra = new Compra();
        compra.setFecha(compraDTO.getFecha());
        compra.setEstado(compraDTO.getEstado());
        compra.setTotal(compraDTO.getTotal());
        //lista detalles

        List<DetalleCompra> detalles = new ArrayList<>();


        for (DetalleCompraDTO detDTO : compraDTO.getDetalle()) {
            Producto producto = productoRepository.findById(detDTO.getIdProd()).orElseThrow(() -> new RuntimeException("producto no encontrado"));

            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setProducto(producto);
            detalleCompra.setPrecio(producto.getPrecio());
            detalleCompra.setCantProd(detDTO.getCantProd());
            detalleCompra.setCompra(compra);
            detalles.add(detalleCompra);
        }
        compra.setDetalle(detalles);

        return Mapper.toDTO(compraRepository.save(compra));

    }

    @Override
    public CompraDTO actualizarCompra(Long id, CompraDTO compraDTO) {
        Compra compra = compraRepository.findById(id).orElseThrow(() -> new NotFoundException("La compra con ese id no existe"));

        compra.setFecha(compraDTO.getFecha());
        compra.setEstado(compraDTO.getEstado());
        compra.setTotal(compraDTO.getTotal());

        return  Mapper.toDTO(compraRepository.save(compra));

    }

    @Override
    public ResponseEntity<Map<String, Boolean>> eliminarCompra(Long id) {
        Compra compra = compraRepository.findById(id).orElseThrow(() -> new NotFoundException("La compra con ese id no existe"));
        compraRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
