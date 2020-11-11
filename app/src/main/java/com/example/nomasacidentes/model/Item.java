package com.example.nomasacidentes.model;

public class Item {
    private String Pregunta;
    private Boolean Respuesta;

    public Item(String pregunta) {
        Pregunta = pregunta;
    }

    public Item(Boolean respuesta) {
        Respuesta = respuesta;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public Boolean getRespuesta() {
        return Respuesta;
    }
}
