package com.example.nomasacidentes.model;

public class AseAccidente {
    private String titulo;
    private Integer soli;
    private String tipacc;
    private String involucrados;
    private String info;




    public AseAccidente(
            String titulo,
            Integer soli,
            String tipacc,
            String involucrados,
            String info

    ) {
        this.titulo = titulo;
        this.soli = soli;
        this.tipacc = tipacc;
        this.involucrados = involucrados;
        this.info = info;

    }
}
