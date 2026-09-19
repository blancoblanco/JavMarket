package com.Tiendajunmi.CompraCol.controller;


import com.Tiendajunmi.CompraCol.dto.UsuarioDTO;
import com.Tiendajunmi.CompraCol.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerUsuarios(){
        return  ResponseEntity.ok(usuarioService.traerUsuarios());
    }

    @PostMapping
    public  ResponseEntity<UsuarioDTO> crearUsuario (@RequestBody UsuarioDTO  usuarioDTO){
        UsuarioDTO nuevoUsuario =usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.created(URI.create("usuarioCreado")).body(nuevoUsuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){

        return ResponseEntity.ok(usuarioService.actualizarUsuario(id,usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void>  eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }


}
