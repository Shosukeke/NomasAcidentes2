package com.example.nomasacidentes.model;

import java.util.Date;

public class solicitudesCbox {
    private String id;
    private String titulo;
    private String descripcion;
    private String tipo;
    private Integer autor;
    private String fecha;
    private Boolean estado;

    public solicitudesCbox(
            String id,
            String titulo,
            String descripcion,
            String tipo,
            Integer autor,
            String fecha,
            Boolean estado


    ) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.autor = autor;
        this.fecha = fecha;
        this.estado = estado;
    }
    public String getId() {return id;}
    public String getTitulo() { return titulo; }
    public String getDecripcion() {return descripcion;}
    public String getTipo() { return tipo; }
    public Integer getAutor() {return autor;}
    public String getFecha() { return fecha; }
    public Boolean getEstado() {return estado;}



}

