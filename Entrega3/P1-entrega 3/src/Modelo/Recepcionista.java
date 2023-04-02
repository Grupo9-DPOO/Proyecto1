package Modelo;
import java.text.BreakIterator;
import java.util.*;

public class Recepcionista {
    
    private List<Registro_Retiro> registro_Retiro;
    private List<Habitacion> habitaciones;
    List<Habitacion> habitacionesDisponibles = new ArrayList<>();
    private String nombre;
    private String login;
    private String password;
    private PMS hotel;

    
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

    public Habitacion realizarReserva(Huesped huesped, int totalPersonas, String fechaInicio, String fechaFin, String tipoHabitacion, int numeroMenores, int cantidadHabitaciones, ArrayList<Huesped> acompañantes) {  
        habitacionesDisponibles.clear();
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            boolean disponible = true;

            for (Registro_Retiro registro : registro_Retiro) {
                if (registro.habitacionOcupada(hotel.getHabitaciones().get(i).getId(), fechaInicio, fechaFin)) {
                    disponible = false;
                    break;
                }   
            }

            Habitacion habitacionActual=hotel.getHabitaciones().get(i);

            if (disponible 
            && habitacionActual.getTipo().equals(tipoHabitacion) 
            && habitacionActual.getCapacidad() >= totalPersonas) { 
                    habitacionesDisponibles.add(habitacionActual);
                    
                } 
        }

        if (habitacionesDisponibles.isEmpty()) {
            return null; // Osea no hay habitaciones disponibles
        }

        Habitacion habitacionSeleccionada = habitacionesDisponibles.get(0);
        Registro_Retiro nuevoRegistro = new Registro_Retiro(huesped, totalPersonas, true, false, habitacionSeleccionada.getId(), numeroMenores, fechaInicio, fechaFin, cantidadHabitaciones, acompañantes);
        String idRegistro = nuevoRegistro.getId();
        hotel.anadirCamas(idRegistro, cantidadHabitaciones, totalPersonas);
        registro_Retiro.add(nuevoRegistro);
        return habitacionSeleccionada;


    }
    
    public boolean cancelarReserva(int documento, String idHabitacion, int horasTranscurridas) {
        if(horasTranscurridas>48){
            return false;
        }
        Registro_Retiro registroParaEliminar = null;
    
        for (Registro_Retiro registro : registro_Retiro) {
            if (registro.getDocumento() == documento && registro.getId().equals(idHabitacion)) {
                registroParaEliminar = registro;
                break;
            }
        }
    
        if (registroParaEliminar != null) {
            registro_Retiro.remove(registroParaEliminar);
            return true;
        } else {
            return false;
        }
    }

    public float realizarCheckout(String idHabitacion){
        float totalCargos = 0;
        for (int i = 0; i < hotel.getHabitaciones().size(); i ++){
            if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)){
                for (int j = 0; j < hotel.getHabitaciones().get(i).getConsumos().size(); j++){
                    totalCargos += hotel.getHabitaciones().get(i).getConsumos().get(j).getPrecio();
                }
                //eliminar habitacion de registros
                for (int k = 0; k < registro_Retiro.size(); k++){
                    if (registro_Retiro.get(k).getId().equals(idHabitacion)){
                        registro_Retiro.remove(k);
                // eliminar consumos de la habitacion
                        hotel.getHabitaciones().get(i).getConsumos().clear();
                    }
                }
            }
        }
        return totalCargos;
    }


    public HashMap<String,String> consultarInventario(){;
        HashMap<String,String> datos = new HashMap<>();
        for(int i = 0; i < registro_Retiro.size(); i++){
            datos.put(registro_Retiro.get(i).getId(),"Habitacion a nombre de "+registro_Retiro.get(i).getNombreHuesped() + " con documento "+registro_Retiro.get(i).getDocumento());
        }
        for(int j =0; j < hotel.getHabitaciones().size(); j++){
            if (!datos.containsKey(hotel.getHabitaciones().get(j).getId()))
            datos.put(hotel.getHabitaciones().get(j).getId(),"No hay huespedes");   
        }
        return datos;
    }
}

    

