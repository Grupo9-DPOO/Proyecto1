package Modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Procesamiento.Procesamiento;

public class Administrador{
    
    //private List<Habitacion> habitaciones;
    //private List<Producto> productos;
    private String nombre;
    private String login;
    private String password;
    private PMS hotel;
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Habitacion> habitacionesVacias = new ArrayList<>();
    private ArrayList<Habitacion> habitacionesOcupadas = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    
    public Administrador(String nombre, String login, String password, PMS hotel) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.hotel = hotel;
    }

    public void modificarPrecioHabitacion(String habitacionId, float nuevoPrecio) {
        //for (Habitacion habitacion : hotel.getHabitaciones()) {
        //    if (habitacion.getId() == habitacionId) {
        //        habitacion.setPrecio(nuevoPrecio);
        //        break;
        //    }
        //}

        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            //System.out.println(hotel.getHabitaciones().get(i).getId() instanceof String);
            //System.out.println(habitacionId instanceof String);
            //Boolean bandera = hotel.getHabitaciones().get(i).getId() == habitacionId;
            //System.out.println(bandera);
            if (hotel.getHabitaciones().get(i).getId().equals(habitacionId)) {
                hotel.getHabitaciones().get(i).setPrecio(nuevoPrecio);
                break;
            }
        }
    }

    public void agregarHabitacion(Habitacion habitacion) {
        hotel.getHabitaciones().add(habitacion);
    }

    public void consultarInventario() {
        System.out.println("Inventario de habitaciones:");
        for (int i= 0 ; i < hotel.getHabitaciones().size(); i++) {
            System.out.println(hotel.getHabitaciones().get(i).getPrecio());
        }
    }


    public void modificarHabitacion(String habitacionId, Habitacion habitacionModificada) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getId() == habitacionId) {
                habitaciones.set(i, habitacionModificada);
                break;
            }
        }
    }

    public void agregarProducto(String nombre, double precio, boolean roomService) {
        Producto producto = new Producto(nombre, precio, roomService);
        hotel.getProductos().add(producto);
    }

    public void modificarProductos(String productoId, Producto productoModificado) {
        for (int i = 0; i < hotel.getProductos().size(); i++) {
            if (hotel.getProductos().get(i).getNombre().equals(productoId)) {
                productos.set(i, productoModificado);
                break;
            }
        }
    }

    public void modificarTarifaServicio(String nombre, float precio){
        for (int i = 0; i < hotel.getServicios().size(); i++) {
            if (hotel.getServicios().get(i).getNombre().equals(nombre)) {
                hotel.getServicios().get(i).setPrecio(precio);
                break;
            }
        }
    }
    public void anadirCamas(String idRegistro, int cantidadHabitaciones, int totalPersonas){
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            if (hotel.getHabitaciones().get(i).getId().equals(idRegistro)) {
                for (int k = 0; k < totalPersonas; k++) {
                    Cama cama = new Cama(90, 1, false);
                    hotel.getHabitaciones().get(i).anadirCama(cama);
                    }
                }
                break;
            }
        }

    public ArrayList<Habitacion> cargarHabitaciones() throws FileNotFoundException, IOException{
        return Procesamiento.cargar_habitaciones();
    }
    //cargar productos
    public ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException{
        return Procesamiento.cargar_productos();
    }
    

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void cambiarPrecioHabitacion(String idHabitacion, String fecha, double nuevoPrecio) {
        Habitacion habitacion = hotel.buscarHabitacion(idHabitacion);
        if (habitacion != null) {
            habitacion.getPreciosEspeciales().put(fecha, nuevoPrecio);
        } else {
            System.out.println("Habitación no encontrada");
        }
    }
    


}
