package com.example.MSresenasYcalificaciones.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reseña")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Resena {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResena;

    @Column(nullable = false)
    private int idProducto;

    @Column(nullable = false)
    private int idCliente;

    @Column(nullable = false, length = 500)
    private String comentario;

    @Column(nullable = false)
    private double calificacion; // valor entre 1 y 5 

    @Column(nullable = false)
    private String fechaResena;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;


}
