package Modelo;

public class Producto {
    private String nombre;
    private float precio;

}

public Producto(String nombre, float precio) {
    this.nombre = nombre;
    this.precio = precio;
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


