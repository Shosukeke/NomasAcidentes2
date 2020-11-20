package com.example.nomasacidentes.model;

public class Empleado {

    private String nombre_emple;
    private String telefono_emple;
    private String correo_emple;
    private String viencia_emple;
    private String locacion_emple;
    private int user;

    public Empleado() {
    }

    public Empleado(String nombre_emple, String telefono_emple, String correo_emple, String viencia_emple, String locacion_emple, int user) {
        this.nombre_emple = nombre_emple;
        this.telefono_emple = telefono_emple;
        this.correo_emple = correo_emple;
        this.viencia_emple = viencia_emple;
        this.locacion_emple = locacion_emple;
        this.user = user;
    }

    public String getNombre_emple() {
        return nombre_emple;
    }

    public void setNombre_emple(String nombre_emple) {
        this.nombre_emple = nombre_emple;
    }

    public String getTelefono_emple() {
        return telefono_emple;
    }

    public void setTelefono_emple(String telefono_emple) {
        this.telefono_emple = telefono_emple;
    }

    public String getCorreo_emple() {
        return correo_emple;
    }

    public void setCorreo_emple(String correo_emple) {
        this.correo_emple = correo_emple;
    }

    public String getViencia_emple() {
        return viencia_emple;
    }

    public void setViencia_emple(String viencia_emple) {
        this.viencia_emple = viencia_emple;
    }

    public String getLocacion_emple() {
        return locacion_emple;
    }

    public void setLocacion_emple(String locacion_emple) {
        this.locacion_emple = locacion_emple;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
//    nombre_emple = models.CharField(max_length=20)
//            telefono_emple = models.CharField(max_length=9)
//            correo_emple = models.CharField(max_length=100)
//            viencia_emple = models.CharField(max_length=30, choices=vigencia, default='')
//        locacion_emple = models.CharField(max_length=30, choices=ESTADOS_locacion, default='')
//        user = models.OneToOneField('auth.User', on_delete=models.CASCADE)