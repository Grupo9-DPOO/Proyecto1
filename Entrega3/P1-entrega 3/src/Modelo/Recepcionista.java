package Modelo;
import java.util.*;

public class Recepcionista {
    
    private List<Registro_Retiro> registro_Retiro;
    private List<Habitacion> habitaciones;
    
    
    public void consultarInventario() {
       
    }
    
    public void registrarLlegada() {
        
    }
    
    public void registrarSalida() {
        
    }
    
    public void verificarDisponibilidad() {
        
    }
    
    public void verFactura() {
        
    }
    
    public Recepcionista() {
        registro_Retiro = new ArrayList<>();
        habitaciones = new ArrayList<>();
    }

    public boolean realizarReserva(String nombre, int documento, String email, int celular, int totalPersonas, String fechaInicio, String fechaFin, int numeroMenores) {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            boolean disponible = true;
            for (Registro_Retiro registro : registro_Retiro) {
                if (registro.habitacionOcupada(habitacion.getId(), fechaInicio, fechaFin)) {
                    disponible = false;
                    break;
                }   
            }
            if (disponible) {
                habitacionesDisponibles.add(habitacion);
            }
        }

        if (habitacionesDisponibles.isEmpty()) {
            return false; // Osea no hay habitaciones disponibles
        }

        Habitacion habitacionSeleccionada = habitacionesDisponibles.get(0);

        Registro_Retiro nuevoRegistro = new Registro_Retiro(nombre, documento, email, celular, totalPersonas, true, false, habitacionSeleccionada.getId(), numeroMenores, fechaInicio, fechaFin);
        registro_Retiro.add(nuevoRegistro);
    return true;

    }



    public void cancelarReserva() {
        
    }
}

