package com.Tiendajunmi.CompraCol.service;


import com.Tiendajunmi.CompraCol.dto.CategoriaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ICategoriaService {
    List<CategoriaDTO> traerCategoria();
    CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO actualizarCategoria(Long id,CategoriaDTO categoriaDTO);
    ResponseEntity<Map<String,Boolean>> eliminarCategoria(Long id);
}
