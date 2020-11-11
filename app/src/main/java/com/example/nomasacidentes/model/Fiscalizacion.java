package com.example.nomasacidentes.model;

public class Fiscalizacion {

    private String nombre;
    private int soli;
    private String fiscalizador;
    private String diligencias;
    private String informacion;
    private String descripcion;



    public Fiscalizacion(
            String nombre,
            int soli,
            String fiscalizador,
            String diligencias,
            String informacion,
            String descripcion
    ) {
        this.nombre = nombre;
        this.soli = soli;
        this.fiscalizador = fiscalizador;
        this.diligencias = diligencias;
        this.diligencias = diligencias;
        this.informacion = informacion;
        this.descripcion = descripcion;
    }


}
