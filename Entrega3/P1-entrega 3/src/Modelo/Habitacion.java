package Modelo;

import java.util.ArrayList;
import java.util.*;

public class Habitacion {

    private String id;
    private String ubicacion;
    private Integer capacidad;
    private String tipo;
    private float precio;
    private Boolean ocupada;
    private ArrayList<Cama> camas;
    private Boolean balcon;
    private Boolean cocina;
    private Boolean vista;
    private String fechaEntrada;
    private String fechaSalida;
    private double precioBase;
    private float cargosAcumulados;
    private ArrayList<Consumo> consumos;
    private Huesped huesped;


    private Map<String, Double> preciosEspeciales;



    public Habitacion(String id, String ubicacion, Integer capacidad, String tipo, float precio, Boolean ocupada, Cama cama, Boolean balcon, Boolean cocina, Boolean vista, String fechaEntrada, String fechaSalida, double precioBase) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.precio = precio;
        this.ocupada = ocupada;
        this.camas = new ArrayList<>();
        this.consumos = new ArrayList<>();
        camas.add(cama);
        //camas.add(cama);
        this.tipo = tipo;
        this.balcon = balcon;
        this.cocina = cocina;
        this.vista = vista;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.preciosEspeciales = new HashMap<>();
        this.cargosAcumulados=0;

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
    public String getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Cama getCama() {
        return camas.get(0);
    }
    //anadir cama a la habitacion
    public void anadirCama(Cama cama){
        camas.add(cama);
    }

    //getter y setter de la lista camas
    public ArrayList<Cama> getCamas() {
        return camas;
    }
    public void setCamas(ArrayList<Cama> camas) {
        this.camas = camas;
    }
    // getter del tipo de habitacion
    public String getTipo() {
        return tipo;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    
    public Integer getCapacidad() {
        return capacidad;
    }
    
    public double getPrecioPorFecha(String fecha) { //Método para saber si hay un precio
        if (preciosEspeciales.containsKey(fecha)) {//especial para una habitación en cierta fecha
            return preciosEspeciales.get(fecha);
        } else {
            return precioBase;
        }
    }
    // agregar consumos
    public void agregarConsumo(Consumo consumo) {
        consumos.add(consumo);
    }

    public Map<String, Double> getPreciosEspeciales() {
        return preciosEspeciales;
}

    public void agregarCargo(float monto) {
        this.cargosAcumulados += monto;
    }

    public float getCargosAcumulados() {
        return cargosAcumulados; // Para obtener cargos acumulados 
    }

    public ArrayList<Consumo> getConsumos() {
        return consumos;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;

}
}