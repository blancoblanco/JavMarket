package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.dto.CategoriaDTO;

import java.util.List;

public class CategoriaService  implements  ICategoriaService{


    @Override
    public List<CategoriaDTO> traerCategoria() {
        return List.of();
    }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        return null;
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        return null;
    }

    @Override
    public void eliminarCategoria(Long id) {

    }
}
