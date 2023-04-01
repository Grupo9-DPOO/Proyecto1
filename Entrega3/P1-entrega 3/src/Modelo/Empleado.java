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

    public void pedirProductoRestaurante(String idHabitacion, int numeroProducto) {
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            if (hotel.getHabitaciones().get(i).getId().equals(idHabitacion)) {
                Consumo consumo = new Consumo(hotel.getProductos().get(numeroProducto).getPrecio(), "12/12/2012", idHabitacion, false, hotel.getProductos().get(numeroProducto).getNombre()); 
                hotel.getHabitaciones().get(i).agregarConsumo(consumo);
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
    public HashMap<String, String> consultarConsumos(){
        HashMap<String, String> consumos = new HashMap<>();
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            for (int j = 0; j < hotel.getHabitaciones().get(i).getConsumos().size(); j++) {
                consumos.put(hotel.getHabitaciones().get(i).getId(), hotel.getHabitaciones().get(i).getConsumos().get(j).getNombre());
            }
        }
        return consumos;
    }
}

