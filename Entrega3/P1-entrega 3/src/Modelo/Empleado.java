package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Empleado {
    private List<Consumo> consumos;
    private String nombre;
    private String login;
    private String password;
    private PMS hotel;

    public Empleado(String nombre, String login, String password, PMS hotel) {
        consumos = new ArrayList<>();
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.hotel = hotel;
    }
    
    public void registrarConsumo(Consumo consumo) {
        consumos.add(consumo);
    }

    public void pedirProductoRestaurante(String idHabitacion, int numeroProducto, int roomService) {
        if (roomService == 2){
            for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
                if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)) {
                    Consumo consumo = new Consumo(hotel.getProductos().get(numeroProducto).getPrecio(), "12/12/2012", idHabitacion, false, hotel.getProductos().get(numeroProducto).getNombre()); 
                    hotel.getHabitaciones().get(i).agregarConsumo(consumo);
                    }
                }
        }
        else if (roomService == 1){
            for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
                if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)) {
                    Consumo consumo = new Consumo(hotel.getProductosRoomService().get(numeroProducto).getPrecio(), "12/12/2012", idHabitacion, false, hotel.getProductosRoomService().get(numeroProducto).getNombre()); 
                    hotel.getHabitaciones().get(i).agregarConsumo(consumo);
                    }
                }
        }

    }

    public void pedirProductoRestauranteInmediato(String idHabitacion, int numeroProducto, int pago) {
        if (pago == 1){
            for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
                if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)) {
                    Consumo consumo = new Consumo(0, "12/12/2012", idHabitacion, true, hotel.getProductosRoomService().get(numeroProducto).getNombre()); 
                    hotel.getHabitaciones().get(i).agregarConsumo(consumo);
                    }
                }
        }
        else if (pago == 2){
            for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
                if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)) {
                    Consumo consumo = new Consumo(0, "12/12/2012", idHabitacion, true, hotel.getProductos().get(numeroProducto).getNombre()); 
                    hotel.getHabitaciones().get(i).agregarConsumo(consumo);
                    }
                }
        }
    }

    public void registrarServicio(String idHabitacion, int numeroServicio) {
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)) {
                Consumo consumo = new Consumo(hotel.getServicios().get(numeroServicio).getPrecio(), "12/12/2012", idHabitacion, false, hotel.getServicios().get(numeroServicio).getNombre()); 
                hotel.getHabitaciones().get(i).agregarConsumo(consumo);
                }
            }
    }
    public void registrarServicioInmediato(String idHabitacion, int numeroServicio) {
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)) {
                Consumo consumo = new Consumo(0, "12/12/2012", idHabitacion, false, hotel.getServicios().get(numeroServicio).getNombre()); 
                hotel.getHabitaciones().get(i).agregarConsumo(consumo);
                }
            }
    }


    public ArrayList<String>consultarConsumos(String idHabitacion) {
        ArrayList<String> consumos = new ArrayList<>();
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)){
                for (int j = 0; j < hotel.getHabitaciones().get(i).getConsumos().size(); j++) {
                    consumos.add(hotel.getHabitaciones().get(i).getConsumos().get(j).getNombre());
                }
             }
        }
        return consumos;
    }
}

