package com.Tiendajunmi.CompraCol.controller;


import com.Tiendajunmi.CompraCol.dto.CategoriaDTO;
import com.Tiendajunmi.CompraCol.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> obtenerCategorias(){
        return  ResponseEntity.ok(categoriaService.traerCategoria());
    }

    @PostMapping
    public  ResponseEntity<CategoriaDTO> crearCategoria (@RequestBody CategoriaDTO  categoriaDTO){
        CategoriaDTO nuevaCategoria =categoriaService.crearCategoria(categoriaDTO);
        return ResponseEntity.ok(nuevaCategoria);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){

        return ResponseEntity.ok(categoriaService.actualizarCategoria(id,categoriaDTO));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void>  eliminarCategoria(@PathVariable Long id){
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
