package com.example.nomasacidentes.model;

public class Mejora {
private String nombremejo;
    private String descripcionmejo;
    private int validacionmejora;
    private String autor;
    private String empresa;

    public Mejora() {
    }

    public Mejora(String nombremejo, String descripcionmejo, int validacionmejora, String autor, String empresa) {
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

    public int getValidacionmejora() {
        return validacionmejora;
    }

    public void setValidacionmejora(int validacionmejora) {
        this.validacionmejora = validacionmejora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    //    validacionmejora = models.CharField(max_length=21,choices=ESTADOS_Mejora, default='')
//    autor = models.ForeignKey('app.Empleados', on_delete=models.CASCADE)
//    empresa = models.ForeignKey('app.Empresas', on_delete=models.CASCADE)
}
