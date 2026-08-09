package com.Tiendajunmi.CompraCol.service;


import com.Tiendajunmi.CompraCol.dto.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaDTO> traerCategoria();
    CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO actualizarCategoria(Long id,CategoriaDTO categoriaDTO);
    void eliminarCategoria(Long id);
}
