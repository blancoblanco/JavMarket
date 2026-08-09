package com.Tiendajunmi.CompraCol.Mapper;

import com.Tiendajunmi.CompraCol.dto.*;
import com.Tiendajunmi.CompraCol.model.Categoria;
import com.Tiendajunmi.CompraCol.model.Compra;
import com.Tiendajunmi.CompraCol.model.Producto;
import com.Tiendajunmi.CompraCol.model.Usuario;

import java.util.stream.Collectors;

public class Mapper {

    public static CategoriaDTO toDTO(Categoria ca) {
        if (ca == null) return null;
        return CategoriaDTO.builder()
                .id(ca.getId())
                .nombre(ca.getNombre())
                .build();
    }

    //Mapeo de Producto a productoDto
    public static ProductoDTO toDTO(Producto p) {
        if (p == null) return null;
        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .stock(p.getStock())
                .precio(p.getPrecio())
                .categorias(p.getCategorias()
                        .stream().map(Mapper::toDTO)
                        .collect(Collectors.toList()))

                .build();
        }
    //Mapeo de Compra a compraDto
    public static CompraDTO toDTO(Compra c) {
        if (c == null) return null;
        var detalle = c.getDetalle().stream().map(
                det ->
                        DetalleCompraDTO.builder()
                                .id(det.getProducto().getId())
                                .nombreProd(det.getProducto().getNombre())
                                .cantProd(det.getCantProd())
                                .precio(det.getPrecio())
                                .subtotal(det.getPrecio() * det.getCantProd())
                                .build()
        ).collect(Collectors.toList());

        var total =detalle.stream().map(DetalleCompraDTO ::getSubtotal)
                .reduce(0.0,Double::sum);

        return  CompraDTO.builder()
                .id(c.getId())
                .fecha(c.getFecha())
                .estado(c.getEstado())
                .detalle(detalle)
                .total(total)
                .build();
    }


    //Mapeo de usuario a usuarioDto
    public static UsuarioDTO toDTO(Usuario u) {
        if (u == null) return null;
        return UsuarioDTO.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .correo(u.getCorreo())
                .password(u.getPassword())
                .telefono(u.getTelefono())
                .direccion(u.getDireccion())
                .build();
    }
}
