package com.Tiendajunmi.CompraCol.service;



import com.Tiendajunmi.CompraCol.dto.ProductoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IProductoService {
    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(Long id,ProductoDTO productoDTO);
    ResponseEntity<Map<String,Boolean>> eliminarProducto(Long id);
}
