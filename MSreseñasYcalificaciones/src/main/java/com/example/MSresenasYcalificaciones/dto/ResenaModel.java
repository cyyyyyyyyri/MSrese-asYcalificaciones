package com.example.MSresenasYcalificaciones.dto;

import org.springframework.hateoas.RepresentationModel;

public class ResenaModel extends RepresentationModel<ResenaModel> {

    private int idResena;
    private int idProducto;
    private int idCliente;
    private String comentario;
    private double calificacion;
    private String fechaResena;

    public ResenaModel(int idResena, int idProducto, int idCliente, String comentario, double calificacion, String fechaResena) {
        this.idResena = idResena;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fechaResena = fechaResena;
    }

    // Getters and Setters
    public int getIdResena() { return idResena; }
    public void setIdResena(int idResena) { this.idResena = idResena; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }

    public String getFechaResena() { return fechaResena; }
    public void setFechaResena(String fechaResena) { this.fechaResena = fechaResena; }
}
