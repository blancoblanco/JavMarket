package com.Tiendajunmi.CompraCol.service;



import com.Tiendajunmi.CompraCol.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> traerProductos();
    ProductoDTO crearCompra(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(Long id,ProductoDTO productoDTO);
    void eliminarProducto(Long id);
}
