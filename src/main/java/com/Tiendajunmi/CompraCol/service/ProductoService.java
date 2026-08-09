package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.Mapper.Mapper;
import com.Tiendajunmi.CompraCol.dto.ProductoDTO;
import com.Tiendajunmi.CompraCol.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository  productoRepository;

    @Override
    public List<ProductoDTO> traerProductos() {
        return productoRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearCompra(ProductoDTO productoDTO) {
        return productoRepository.save();
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {

    }
}
