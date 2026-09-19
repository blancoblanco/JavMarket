package com.Tiendajunmi.CompraCol.controller;


import com.Tiendajunmi.CompraCol.dto.ProductoDTO;
import com.Tiendajunmi.CompraCol.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerProductos(){
        return  ResponseEntity.ok(productoService.traerProductos());
    }

    @PostMapping
    public  ResponseEntity<ProductoDTO> crearProducto (@RequestBody ProductoDTO  productoDTO){
        ProductoDTO nuevoProducto =productoService.crearProducto(productoDTO);
        return ResponseEntity.created(URI.create("productoCreado")).body(nuevoProducto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id,@RequestBody ProductoDTO productoDTO){

        return ResponseEntity.ok(productoService.actualizarProducto(id,productoDTO));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void>  eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

}
