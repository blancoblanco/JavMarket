package com.Tiendajunmi.CompraCol.controller;


import com.Tiendajunmi.CompraCol.dto.CompraDTO;
import com.Tiendajunmi.CompraCol.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
public class CompraController {

    @Autowired
    private ICompraService  compraService;


    @GetMapping
    public ResponseEntity<List<CompraDTO>> obtenerCompras(){
        return  ResponseEntity.ok(compraService.traerCompras());
    }

    @PostMapping
    public  ResponseEntity<CompraDTO> crearCompra (@RequestBody CompraDTO  compraDTO){
        CompraDTO nuevaCompra =compraService.crearCompra(compraDTO);
        return ResponseEntity.ok(nuevaCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraDTO> actualizarCompra(@PathVariable Long id,@RequestBody CompraDTO compraDTO){

        return ResponseEntity.ok(compraService.actualizarCompra(id,compraDTO));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> eliminarCompra (@PathVariable Long id){
        compraService.eliminarCompra(id);
        return ResponseEntity.noContent().build();
    }



}
