package Modelo;

import java.util.ArrayList;

public class PMS {
    
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();


    public Huesped crearHuesped(String nombre, Integer documento, Integer numeroCel, String correo){
        Huesped huesped = new Huesped(nombre, documento, numeroCel, correo);
        return huesped;
    }
    public Administrador crearAdministrador(String nombre, String login, String password){
        Administrador administrador = new Administrador(nombre, login, password);
        return administrador;
    }
    public Empleado crearEmpleado(String nombre, String login, String password){
        Empleado empleado = new Empleado(nombre, login, password);
        return empleado;
    }

        
}



