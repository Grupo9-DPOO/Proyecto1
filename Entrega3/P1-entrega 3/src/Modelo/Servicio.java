package Modelo;

public class Servicio {
    private double precio;
    private String nombre;
    private boolean individual;
    private double totalConsumido;
    private double totalPagado;
    
    public Servicio(String nombre, double precio,  boolean individual) {
        this.precio = precio;
        this.nombre = nombre;
        this.individual = individual;
        this.totalConsumido = 0;
        this.totalPagado = 0;
    }
    
    public void registrarServiciosConsumidos(double cantidad) {
        if (individual) {
            this.totalConsumido += cantidad;
        } else {
            this.totalConsumido++;
        }
    }
    
    public void registrarPagosHechos(double cantidad) {
        this.totalPagado += cantidad;
    }
    
    public double montoAdeudado() {
        return totalConsumido * precio;
    }
    
    public double montoRestante() {
        return montoAdeudado() - totalPagado;
    }
    
    // Getters y setters
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isIndividual() {
        return individual;
    }
    public void setIndividual(boolean individual) {
        this.individual = individual;
    }
}
