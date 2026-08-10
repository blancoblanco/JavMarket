package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.mapper.Mapper;
import com.Tiendajunmi.CompraCol.dto.UsuarioDTO;
import com.Tiendajunmi.CompraCol.exception.NotFoundException;

import com.Tiendajunmi.CompraCol.model.Usuario;
import com.Tiendajunmi.CompraCol.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService implements IUsuarioService{

     @Autowired
     private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> traerUsuarios() {
        return usuarioRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario=Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .correo(usuarioDTO.getCorreo())
                .password(usuarioDTO.getPassword())
                .direccion(usuarioDTO.getDireccion())
                .telefono(usuarioDTO.getTelefono()).build();

        return   Mapper.toDTO(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario =usuarioRepository.findById(id).orElseThrow(()->new NotFoundException("Usuario no encontrado"));
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setTelefono(usuarioDTO.getTelefono());

        return Mapper.toDTO(usuarioRepository.save(usuario));

    }

    @Override
    public ResponseEntity<Map<String, Boolean>> eliminarUsuario(Long id) {
        Usuario usuario =usuarioRepository.findById(id).orElseThrow(()->new NotFoundException("Usuario no encontrado"));
        usuarioRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
