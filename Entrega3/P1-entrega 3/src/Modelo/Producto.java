package Modelo;

public class Producto {
    private String nombre;
    private float precio;
    private String horas;


    public Producto(String nombre, float precio, String horas) {
        this.nombre = nombre;
        this.precio = precio;
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    private void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getHoras() {
        return horas;
    }
    private void setHoras(String horas) {
        this.horas = horas;
    }

}


