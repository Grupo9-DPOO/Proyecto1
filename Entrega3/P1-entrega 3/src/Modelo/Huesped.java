package Modelo;

public class Huesped {
    private String nombre;
    private Integer documento;
    private long numeroCel;
    private String correo;
    
    public Huesped(String nombre, Integer documento, long numeroCel, String correo) {
        this.nombre = nombre;
        this.documento = documento;
        this.numeroCel = numeroCel;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
 

    public Integer getDocumento() {
        return documento;
    }

    public long getNumeroCel() {
        return numeroCel;
    }

    public String getCorreo() {
        return correo;
    }


}

