package com.example.nomasacidentes.model;

public class Empresa {

    private String nombre_empre;
    private String rut;
    private String direccion_empre;
    private String correo_empre;
    private String rubro_empre;
    private String fono_empre;
    private int user;
    private int empleado;

    public Empresa() {
    }

    public Empresa(String nombre_empre, String rut, String direccion_empre, String correo_empre, String rubro_empre, String fono_empre, int user, int empleado) {
        this.nombre_empre = nombre_empre;
        this.rut = rut;
        this.direccion_empre = direccion_empre;
        this.correo_empre = correo_empre;
        this.rubro_empre = rubro_empre;
        this.fono_empre = fono_empre;
        this.user = user;
        this.empleado = empleado;
    }

    public String getNombre_empre() {
        return nombre_empre;
    }

    public void setNombre_empre(String nombre_empre) {
        this.nombre_empre = nombre_empre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion_empre() {
        return direccion_empre;
    }

    public void setDireccion_empre(String direccion_empre) {
        this.direccion_empre = direccion_empre;
    }

    public String getCorreo_empre() {
        return correo_empre;
    }

    public void setCorreo_empre(String correo_empre) {
        this.correo_empre = correo_empre;
    }

    public String getRubro_empre() {
        return rubro_empre;
    }

    public void setRubro_empre(String rubro_empre) {
        this.rubro_empre = rubro_empre;
    }

    public String getFono_empre() {
        return fono_empre;
    }

    public void setFono_empre(String fono_empre) {
        this.fono_empre = fono_empre;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }
}


//    nombre_empre = models.CharField(max_length=21)
//            rut = models.CharField(max_length=21) #agregado
//            direccion_empre = models.CharField(max_length=100)
//            correo_empre = models.CharField(max_length=100)
//            rubro_empre = models.CharField(max_length=15,choices=ESTADOS_rubro)
//            fono_empre = models.CharField(max_length=9)
//            user = models.OneToOneField('auth.User', on_delete=models.CASCADE)
//            empleado = models.ForeignKey('app.Empleados', on_delete=models.CASCADE)