package com.example.MSresenasYcalificaciones.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(nullable = false, length = 250)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(length = 500)
    private String descripcion;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resena> resenas = new ArrayList<>();

    // Constructor adicional para el test
    public Producto(int idProducto, String nombre, double precio, String descripcion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}