package Consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import Modelo.PMS;

public class App {

    private PMS hotel = new PMS();

    public void ejecutarAplicacion() throws FileNotFoundException, IOException {
	    boolean continuar = true;
        while (continuar)
		{
            mostrarMenuInicial();
            int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion \n"));
            if (opcion_seleccionada == 1) {
                crearAdministrador();
            } 
            else if (opcion_seleccionada == 2) {
                crearEmpleado();
            } 
            else if (opcion_seleccionada == 3) {
            } 
            else {
                System.out.println("Opcion no valida");
            }

            mostrarMenuHotel();
            int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opcion \n"));
            if (opcion_seleccionada2 == 1) {
                crearHuesped();
            } 
            else if (opcion_seleccionada2 == 2) {
                mostrarMenuAdmin();
                int opcion_seleccionada3 = Integer.parseInt(input("Por favor seleccione una opcion \n"));
                if (opcion_seleccionada3 == 1){
                }
            } 
            else if (opcion_seleccionada2 == 3) {
            } 
            else if (opcion_seleccionada2 == 4) {
            } 
            else {
                System.out.println("Opcion no valida");
            }
        }
    }

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
		

			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

    public void mostrarMenuInicial(){
        System.out.println("Escoga que tipo de usuario a crear: ");
        System.out.println("1. Si es un administrador.");
        System.out.println("2. Si es un empleado.");
        System.out.println("3. Si es un recepcionista.");
    }

    public void mostrarMenuHotel(){
        System.out.println("Escoga que usuario es: ");
        System.out.println("1. Si es un huesped. ");
        System.out.println("2. Si es un administrador.");
        System.out.println("3. Si es un empleado.");
        System.out.println("4. Si es un recepcionista.");
    }

    private void mostrarMenuAdmin(){
        System.out.println("1. Modificar el precio de una habitacion. ");
        System.out.println("2. Agregar una habitacion. ");
        System.out.println("3. Consultar el inventario de habitaciones. ");
        System.out.println("4. Modificar una habitacion. ");
        System.out.println("5. Agregar productos ");
        System.out.println("6. Modificar productos ");
    }   
    private void crearHuesped(){
        System.out.println("Por favor ingrese su nombre");
        String nombre = input("Nombre");
        System.out.println("Por favor ingrese su documento");
        int documento = Integer.parseInt(input("Documento"));
        System.out.println("Por favor ingrese su numero de celular");
        int numeroCel = Integer.parseInt(input("Numero de celular"));
        System.out.println("Por favor ingrese su correo electronico");
        String correo = input("Correo electronico");
        hotel.crearHuesped(nombre, documento, numeroCel, correo);
        System.out.println("Huesped creado con exito, ahora podemos reservarle una habitacion!!!");

    }
    private void crearAdministrador(){
        System.out.println("Por favor ingrese su nombre");
        String nombre = input("Nombre");
        System.out.println("Por favor ingrese su login");
        String login = input("Login");
        System.out.println("Por favor ingrese su password");
        String password = input("Password");
        hotel.crearAdministrador(nombre, login, password);
        System.out.println("Administrador creado con exito, ahora puede gestionar el hotel!!!");
    }
    private void crearEmpleado(){
        System.out.println("Por favor ingrese su nombre");
        String nombre = input("Nombre");
        System.out.println("Por favor ingrese su login");
        String login = input("Login");
        System.out.println("Por favor ingrese su password");
        String password = input("Password");
        hotel.crearEmpleado(nombre, login, password);
        System.out.println("Empleado creado con exito, ahora puede registrar consumos!!!");
    }
    private void modificarHabitacion(){
        System.out.println("Por favor ingrese el numero de la habitacion");
        int numero = Integer.parseInt(input("Numero"));
        System.out.println("Por favor ingrese el precio de la habitacion");
        int precio = Integer.parseInt(input("Precio"));
        //hotel.modificarHabitacion(numero, precio);
        System.out.println("Habitacion modificada con exito!!!");
    }



	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		App consola = new App();
		consola.ejecutarAplicacion();
	}

}

