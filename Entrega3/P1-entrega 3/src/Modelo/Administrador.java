package Modelo;

import java.util.ArrayList;

public class Administrador{
    
    //private List<Habitacion> habitaciones;
    //private List<Producto> productos;
    private String nombre;
    private String login;
    private String password;
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();

    public Administrador(String nombre, String login, String password) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
    }

    public void modificarPrecioHabitacion(String habitacionId, float nuevoPrecio) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getId() == habitacionId) {
                habitacion.setPrecio(nuevoPrecio);
                break;
            }
        }
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void consultarInventario() {
        System.out.println("Inventario de habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
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

    public void agregarProductos(Producto producto) {
        productos.add(producto);
    }

    public void modificarProductos(String productoId, Producto productoModificado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre() == productoId) {
                productos.set(i, productoModificado);
                break;
            }
        }
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
}
