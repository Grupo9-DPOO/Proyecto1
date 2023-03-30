package Modelo;

import java.util.ArrayList;

public class PMS {
    
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Recepcionista> recepcionistas = new ArrayList<>();
    private ArrayList<Huesped> huespedes = new ArrayList<>();
    private Administrador administrador = new Administrador("678", "345", "123", this);
    private Recepcionista recepcionista = new Recepcionista("123", "456", "789", this);

    public Huesped crearHuesped(String nombre, Integer documento, Integer numeroCel, String correo){
        Huesped huesped = new Huesped(nombre, documento, numeroCel, correo);
        huespedes.add(huesped);
        return huesped;
    }
    public Administrador crearAdministrador(String nombre, String login, String password){
        Administrador administrador = new Administrador(nombre, login, password, this);
        administradores.add(administrador);
        return administrador;
    }
    
            
    //public Empleado crearEmpleado(String nombre, String login, String password){
      //  Empleado empleado = new Empleado(nombre, login, password);
       // empleados.add(empleado);
        //return empleado;
    //}
    //public Recepcionista crearRecepcionista(String nombre, String login, String password){
    //    Recepcionista recepcionista = new Recepcionista(nombre, login, password);
    //    recepcionistas.add(recepcionista);
    //    return recepcionista;
    //}            
         
    // Modificaciones del administrador
    public void modificarPrecioHabitacion(String numero, float precio){
        administrador.modificarPrecioHabitacion(numero, precio);
    }

    public void crearHabitacion(String id, String ubicacion,Integer capacidad, String tipo, float precio, Boolean ocupada, float tamagnoCama, int capacidadCama, Boolean camaNiños, Boolean balcon, Boolean cocina, Boolean vista, String fechaEntrada, String fechaSalida){
        Cama cama = new Cama(tamagnoCama, capacidadCama, camaNiños);
        Habitacion habitacion = new Habitacion(id, ubicacion, capacidad, tipo, precio, ocupada, cama, balcon, cocina, vista, fechaEntrada, fechaSalida);
        administrador.agregarHabitacion(habitacion);
        //habitaciones.add(habitacion);
    }

    public void consultarInventario(){
        administrador.consultarInventario();
    }
    public void agregarProducto(String nombre, float precio, String horas){
        administrador.agregarProducto(nombre, precio, horas);
    }
    public void modificarTarifaServicio(String nombre, float precio){
        administrador.modificarTarifaServicio(nombre, precio);
    }
    public void anadirCamas(String idRegistro, int cantidadHabitaciones, int totalPersonas){
        administrador.anadirCamas(idRegistro, cantidadHabitaciones, totalPersonas);
    }

    //Huesped
    public Habitacion realizarReserva(String nombre, int documento, String email, int celular ,int totalPersonas, String fechaInicio, String fechaFin, String tipoHabitacion, int numeroMenores, int cantidadHabitaciones) {
        Huesped huesped = new Huesped(nombre, documento, celular, email);
        return recepcionista.realizarReserva(nombre, documento, email, celular , totalPersonas, fechaInicio, fechaFin, tipoHabitacion, numeroMenores, cantidadHabitaciones);
    }

    

    // getter y setter de la lista habitaciones
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    // getter y setter de la lista servicios
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    // getter y setter de la lista productos
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }        
}



