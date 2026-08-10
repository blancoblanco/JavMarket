package com.Tiendajunmi.CompraCol.service;

import com.Tiendajunmi.CompraCol.Mapper.Mapper;
import com.Tiendajunmi.CompraCol.dto.CategoriaDTO;
import com.Tiendajunmi.CompraCol.exception.NotFoundException;
import com.Tiendajunmi.CompraCol.model.Categoria;
import com.Tiendajunmi.CompraCol.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriaService  implements  ICategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> traerCategoria() {
        return categoriaRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria =Categoria.builder()
                .nombre(categoriaDTO.getNombre())
                .build();
        return Mapper.toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria =categoriaRepository.findById(id).orElseThrow(()->new NotFoundException("Categoria no encontrada"));
        categoria.setNombre(categoriaDTO.getNombre());
        return Mapper.toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> eliminarCategoria(Long id) {
        Categoria categoria =categoriaRepository.findById(id).orElseThrow(()->new NotFoundException("Categoria no encontrada"));
        categoriaRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
