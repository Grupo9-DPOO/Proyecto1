package Modelo;

public class Administrador {
    
    private List<Habitacion> habitaciones;
    private List<Producto> productos;

    public Administrador() {
        habitaciones = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public void modificarPrecioHabitacion(int habitacionId, double nuevoPrecio) {
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

    public void modificarHabitacion(int habitacionId, Habitacion habitacionModificada) {
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

    public void modificarProductos(int productoId, Producto productoModificado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == productoId) {
                productos.set(i, productoModificado);
                break;
            }
        }
    }
}
