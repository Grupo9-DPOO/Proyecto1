package Modelo;
import java.util.*;

public class Recepcionista {
    
    private List<Registro_Retiro> registro_Retiro;
    private List<Habitacion> habitaciones;
    List<Habitacion> habitacionesDisponibles = new ArrayList<>();
    private String nombre;
    private String login;
    private String password;
    private PMS hotel;
    
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
    
    public Recepcionista(String nombre, String login, String password, PMS hotel) {
        registro_Retiro = new ArrayList<>();
        habitaciones = new ArrayList<>();
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.hotel = hotel;
    }

    public boolean realizarReserva(String nombre, int documento, String email, int celular, int totalPersonas, String fechaInicio, String fechaFin, String tipoHabitacion, int numeroMenores, int cantidadHabitaciones) {  
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            boolean disponible = true;
            for (Registro_Retiro registro : registro_Retiro) {
                if (registro.habitacionOcupada(hotel.getHabitaciones().get(i).getId(), fechaInicio, fechaFin)) {
                    disponible = false;
                    break;
                }   
            }
            if (disponible || hotel.getHabitaciones().get(i).getTipo().equals(tipoHabitacion)) {

                habitacionesDisponibles.add(hotel.getHabitaciones().get(i));
            }
        }

        if (habitacionesDisponibles.isEmpty()) {
            return false; // Osea no hay habitaciones disponibles
        }

        Habitacion habitacionSeleccionada = habitacionesDisponibles.get(0);

        Registro_Retiro nuevoRegistro = new Registro_Retiro(nombre, documento, email, celular, totalPersonas, true, false, habitacionSeleccionada.getId(), numeroMenores, fechaInicio, fechaFin, cantidadHabitaciones);
        String idRegistro = nuevoRegistro.getId();
        hotel.anadirCamas(idRegistro, cantidadHabitaciones, totalPersonas);
        registro_Retiro.add(nuevoRegistro);

    return true;

    }
    


    public void cancelarReserva() {
        
    }
}

