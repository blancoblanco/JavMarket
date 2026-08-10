package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.Mapper.Mapper;
import com.Tiendajunmi.CompraCol.dto.ProductoDTO;
import com.Tiendajunmi.CompraCol.exception.NotFoundException;
import com.Tiendajunmi.CompraCol.model.Producto;
import com.Tiendajunmi.CompraCol.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository  productoRepository;

    @Override
    public List<ProductoDTO> traerProductos() {
        return productoRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto= Producto.builder()
                .nombre(productoDTO.getNombre())
                .categorias(productoDTO.getCategorias()
                        .stream()
                        .map(Mapper::toEntity)
                        .toList())
                .precio(productoDTO.getPrecio())
                .stock(productoDTO.getStock())
                .build();
        return Mapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        Producto producto =productoRepository.findById(id).orElseThrow(()->new NotFoundException("Producto no encontrado"));
        producto.setNombre(productoDTO.getNombre());
        producto.setCategorias(productoDTO.getCategorias().stream().map(Mapper::toEntity).toList());
        producto.setStock(productoDTO.getStock());
        producto.setPrecio(productoDTO.getPrecio());

        return Mapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(Long id) {
        Producto producto =productoRepository.findById(id).orElseThrow(()->new NotFoundException("Producto no encontrado"));
        productoRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
