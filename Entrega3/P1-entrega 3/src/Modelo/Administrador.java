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

    public Administrador(String nombre, String login, String password, PMS hotel) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.hotel = hotel;
    }

    public void modificarPrecioHabitacion(String habitacionId, float nuevoPrecio) {

        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {

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
            //mostrar informacion de la habitacion
            System.out.println("Habitacion " + hotel.getHabitaciones().get(i).getId());
            System.out.println("Tipo: " + hotel.getHabitaciones().get(i).getTipo());
            System.out.println("Capacidad: " + hotel.getHabitaciones().get(i).getCapacidad());
            System.out.println("Precio: " + hotel.getHabitaciones().get(i).getPrecio());
            System.out.println("Estado: " + hotel.getHabitaciones().get(i).getOcupada());
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
        if (roomService){
            hotel.getProductosRoomService().add(producto);
        }
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
    //cargar servicios
    public ArrayList<Servicio> cargarServicios() throws FileNotFoundException, IOException{
        return Procesamiento.cargar_servicios();
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

    public void cambiarPrecioHabitacion(String tipoHabitacion, String fecha, double nuevoPrecio) {
        Habitacion habitacion = hotel.buscarHabitacion(tipoHabitacion);
        if (habitacion != null) {
            habitacion.getPreciosEspeciales().put(fecha, nuevoPrecio);
        } else {
            System.out.println("Tipo de habitacion no válida");
        }
    }
    


}
