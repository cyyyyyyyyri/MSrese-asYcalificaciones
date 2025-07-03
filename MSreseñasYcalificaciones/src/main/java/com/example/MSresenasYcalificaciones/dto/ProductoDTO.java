package com.example.MSresenasYcalificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private int idProducto;
    private String nombre;
    private double precio;
    private String descripcion;

}
