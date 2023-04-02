package Modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PMS {
    
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Administrador> administradores = new ArrayList<>();
    private ArrayList<Producto> productosRoomService = new ArrayList<>();
    private ArrayList<Huesped> huespedes = new ArrayList<>();
    private Administrador administrador = new Administrador("678", "345", "123", this);
    private Recepcionista recepcionista = new Recepcionista("123", "456", "789", this);
    private Empleado empleado = new Empleado("123", "456", "789", this);

    public Huesped crearHuesped(String nombre, Integer documento, long numeroCel, String correo){
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

    public void crearHabitacion(String id, String ubicacion,Integer capacidad, String tipo, float precio, Boolean ocupada, float tamagnoCama, int capacidadCama, Boolean camaNiños, Boolean balcon, Boolean cocina, Boolean vista, String fechaEntrada, String fechaSalida, double precioBase){
        Cama cama = new Cama(tamagnoCama, capacidadCama, camaNiños);
        Habitacion habitacion = new Habitacion(id, ubicacion, capacidad, tipo, precio, ocupada, cama, balcon, cocina, vista, fechaEntrada, fechaSalida, precioBase);
        administrador.agregarHabitacion(habitacion);
        //habitaciones.add(habitacion);
    }
    public HashMap<String, String> consultarInventarioRecepcionista(){
        return recepcionista.consultarInventario();
    }
    public void consultarInventario(){
        administrador.consultarInventario();
    }
    public ArrayList<String> consultarConsumos(String idHabitacion){
        return empleado.consultarConsumos(idHabitacion);
    }
    public void agregarProducto(String nombre, double precio, boolean roomService){
        administrador.agregarProducto(nombre, precio, roomService);
    }
    public void modificarTarifaServicio(String nombre, float precio){
        administrador.modificarTarifaServicio(nombre, precio);
    }
    public void anadirCamas(String idRegistro, int cantidadHabitaciones, int totalPersonas){
        administrador.anadirCamas(idRegistro, cantidadHabitaciones, totalPersonas);
    }
    public void cargarHabitaciones() throws FileNotFoundException, IOException{
        this.habitaciones = administrador.cargarHabitaciones();
    }
    //cargar productos
    public void cargarProductos() throws FileNotFoundException, IOException{
        this.productos = administrador.cargarProductos();
    }
    //cargar servicios
    public void cargarServicios() throws FileNotFoundException, IOException{
        this.servicios = administrador.cargarServicios();
    }

    //Huesped
    public Habitacion realizarReserva(String nombre, int documento, String email, long celular ,int totalPersonas, String fechaInicio, String fechaFin, String tipoHabitacion, int numeroMenores, int cantidadHabitaciones) {
        Huesped huesped = new Huesped(nombre, documento, celular, email);
        return recepcionista.realizarReserva(huesped, totalPersonas, fechaInicio, fechaFin, tipoHabitacion, numeroMenores, cantidadHabitaciones);
    }

    public void registrarServicio(String id, int numeroServicio){
        empleado.registrarServicio(id, numeroServicio);
    }
    public void registrarServicioInmediato(String id, int numeroServicio){
        empleado.registrarServicioInmediato(id, numeroServicio);
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
    //getter y setter de la lista productos room service
    public ArrayList<Producto> getProductosRoomService() {
        return productosRoomService;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }  


    // Añade este método en la clase PMS
    public Habitacion buscarHabitacion(String idHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getId().equals(idHabitacion)) {
                return habitacion;
            }
    }
    return null; // Si no se encuentra la habitación con el ID dado, devuelve null
    }
    public Boolean cancelarReserva(int documento, String idHabitacion, int horasDesdeReserva){
        return recepcionista.cancelarReserva(documento, idHabitacion, horasDesdeReserva);
    }
    public float realizarCheckoutt(String idHabitacion){
        return recepcionista.realizarCheckout(idHabitacion);
    }
    public void realizarCheckout(String idHabitacion) {
        Habitacion habitacionARealizarCheckout = null;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getId().equals(idHabitacion)) {
                habitacionARealizarCheckout = habitacion;
                break;
        }
    }
    if (habitacionARealizarCheckout != null) { //Para hacer checkout de la habitacion
        habitacionARealizarCheckout.setOcupada(false);
        habitacionARealizarCheckout.setFechaEntrada(null);
        habitacionARealizarCheckout.setFechaSalida(null);
    } else {
        System.out.println("No se encontró una habitación con el ID especificado.");
        }
    }   
    public void cambiarPrecioHabitacion(String tipoHabitacion,String fecha,float nuevoPrecio){
        administrador.cambiarPrecioHabitacion(tipoHabitacion, fecha, nuevoPrecio);
    }   

    public void pedirProductoRestaurante(String idHabitacion, int numeroProducto, int roomService){
        empleado.pedirProductoRestaurante(idHabitacion, numeroProducto, roomService);
    }
    public void pedirProductoRestauranteInmediato(String idHabitacion, int numeroProducto)
        {
        empleado.pedirProductoRestauranteInmediato(idHabitacion, numeroProducto);
    }
    //agregar productos room service

    public void agregarProductoRoomService(){
        for (Producto producto : productos) {
            if(producto.isRoomService()){
                productosRoomService.add(producto);
            }
        }
        
    }

}


