package com.Tiendajunmi.CompraCol.service;


import com.Tiendajunmi.CompraCol.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUsuarioService {
    List<UsuarioDTO> traerUsuarios();
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO actualizarUsuario(Long id,UsuarioDTO usuarioDTO);
    ResponseEntity<Map<String,Boolean>> eliminarUsuario(Long id);
}
