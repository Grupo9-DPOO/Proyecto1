package Modelo;

public class Huesped {
    private String nombre;
    private Integer documento;
    private Integer numeroCel;
    private String correo; 
    


    public Huesped(String nombre, Integer documento, Integer numeroCel, String correo) {
        this.nombre = nombre;
        this.documento = documento;
        this.numeroCel = numeroCel;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getDocumento() {
        return documento;
    }
    private void setDocumento(Integer documento) {
        this.documento = documento;
    }
    public Integer getNumeroCel() {
        return numeroCel;
    }
    private void setNumeroCel(Integer numeroCel) {
        this.numeroCel = numeroCel;
    }
    public String getCorreo() {
        return correo;
    }
    private void setCorreo(String correo) {
        this.correo = correo;
    }

}

