package Modelo;

public class Consumo {
    private float precio;
    private String fecha;
    private String habitacion;
    private boolean tipoPago;

    public Consumo() {
    }

    public Consumo(float precio, String fecha, String habitacion, boolean tipoPago) {
        this.precio = precio;
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.tipoPago = tipoPago;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public boolean isTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(boolean tipoPago) {
        this.tipoPago = tipoPago;
    }
}

