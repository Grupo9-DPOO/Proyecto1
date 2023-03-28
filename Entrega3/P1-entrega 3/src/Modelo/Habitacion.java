package Modelo;

public class Habitacion {
    private String id;
    private String ubicacion;
    private Integer capacidad;
    private String tipo;
    private float precio;
    private Boolean ocupada;
    private Cama cama;
    private String tipo;
    private Boolean balcon;
    private Boolean cocina;
    private Boolean vista;
    private String fechaEntrada;
    private String fechaSalida;
}

public Hbitacion(String id, String ubicacion, Integer capacidad, String tipo, float precio, Boolean ocupada, Cama cama, String tipo, Boolean balcon, Boolean cocina, Boolean vista, String fechaEntrada, String fechaSalida) {
    this.id = id;
    this.ubicacion = ubicacion;
    this.capacidad = capacidad;
    this.tipo = tipo;
    this.precio = precio;
    this.ocupada = ocupada;
    this.cama = cama;
    this.tipo = tipo;
    this.balcon = balcon;
    this.cocina = cocina;
    this.vista = vista;
    this.fechaEntrada = fechaEntrada;
    this.fechaSalida = fechaSalida;

}
public float getPrecio() {
    return precio;
}
public void setPrecio(float precio) {
    this.precio = precio;
}
//Revisar el getter y setter de la fecha entrada y salida

public String getId() {
    return id;
}
public Boolean getOcupada() {
    return ocupada;
}
public getFechaEntrada() {
    return fechaEntrada;
}
private void setFechaEntrada(String fechaEntrada) {
    this.fechaEntrada = fechaEntrada;
}

public getFechaSalida() {
    return fechaSalida;
}

private void setFechaSalida(String fechaSalida) {
    this.fechaSalida = fechaSalida;
}

public Cama getCama() {
    return cama;
}
