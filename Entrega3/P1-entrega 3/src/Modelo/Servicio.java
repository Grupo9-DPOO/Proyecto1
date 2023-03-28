package Modelo;

public class Servicio {
    private float precio;
    private String nombre;
    private boolean individual;
    private float totalConsumido;
    private float totalPagado;
    
    public Servicio(float precio, String nombre, boolean individual) {
        this.precio = precio;
        this.nombre = nombre;
        this.individual = individual;
        this.totalConsumido = 0;
        this.totalPagado = 0;
    }
    
    public void crearServicio() {
        
    }
    
    public void registrarServiciosConsumidos(float cantidad) {
        if (individual) {
            this.totalConsumido += cantidad;
        } else {
            this.totalConsumido++;
        }
    }
    
    public void registrarPagosHechos(float cantidad) {
        this.totalPagado += cantidad;
    }
    
    // Getters y setters
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
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


