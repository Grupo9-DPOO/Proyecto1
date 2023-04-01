package Modelo;

public class Producto {
    private String nombre;
    private double precio;
    private boolean roomService;

    public Producto(String nombre, double precio, boolean roomService) {
        this.nombre = nombre;
        this.precio = precio;
        this.roomService = roomService;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isRoomService() {
        return roomService;
    }

    public void setRoomService(boolean roomService) {
        this.roomService = roomService;
    }
}

