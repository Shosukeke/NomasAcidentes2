package com.example.nomasacidentes.model;

public class Mejora {
private String nombremejo;
    private String descripcionmejo;
    private String validacionmejora;
    private int autor;
    private int empresa;

    public Mejora() {

    }

    public Mejora(String nombremejo, String descripcionmejo, String validacionmejora, int autor, int empresa) {
        this.nombremejo = nombremejo;
        this.descripcionmejo = descripcionmejo;
        this.validacionmejora = validacionmejora;
        this.autor = autor;
        this.empresa = empresa;
    }

    public String getNombremejo() {
        return nombremejo;
    }

    public void setNombremejo(String nombremejo) {
        this.nombremejo = nombremejo;
    }

    public String getDescripcionmejo() {
        return descripcionmejo;
    }

    public void setDescripcionmejo(String descripcionmejo) {
        this.descripcionmejo = descripcionmejo;
    }

    public String getValidacionmejora() {
        return validacionmejora;
    }

    public void setValidacionmejora(String validacionmejora) {
        this.validacionmejora = validacionmejora;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    //    validacionmejora = models.CharField(max_length=21,choices=ESTADOS_Mejora, default='')
//    autor = models.ForeignKey('app.Empleados', on_delete=models.CASCADE)
//    empresa = models.ForeignKey('app.Empresas', on_delete=models.CASCADE)
}
