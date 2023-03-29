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

        mostrarMenuHotel();
        int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opcion \n"));
        if (opcion_seleccionada2 == 1) {
            crearHuesped();
        } 
        else if (opcion_seleccionada2 == 2) {
            mostrarMenuAdmin();
            int opcion_seleccionada3 = Integer.parseInt(input("Por favor seleccione una opcion \n"));
            if (opcion_seleccionada3 == 1){
                 modificarPrecioHabitacion();
               }
            else if (opcion_seleccionada3 == 2){
                crearHabitacion();
            }
            else if (opcion_seleccionada3 == 3){
                hotel.consultarInventario();
            }
            else if (opcion_seleccionada3 == 4){
                agregarProducto();
            }
            else if (opcion_seleccionada3 == 5){
                modificarTarifaServicio();
            }

            else{
                System.out.println("Opcion no valida");
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
        System.out.println("Escoga que tipo de usuario a es: ");
        System.out.println("1. Si es un administrador.");
        System.out.println("2. Si es un empleado.");
        System.out.println("3. Si es un recepcionista.");
    }

    public void mostrarMenuHotel(){
        System.out.println("Escoga que usuario es: ");
        System.out.println("1. Quiero reservar una habitacion. ");
        System.out.println("2. Si es un administrador.");
        System.out.println("3. Si es un empleado.");
        System.out.println("4. Si es un recepcionista.");
    }

    private void mostrarMenuAdmin(){
        System.out.println("1. Modificar el precio de una habitacion. ");
        System.out.println("2. Agregar una habitacion. ");
        System.out.println("3. Consultar el inventario de habitaciones. ");
        System.out.println("4. Agregar productos ");
        System.out.println("5. Modificar tarifa Servicio ");
    }   

    private void crearAdministrador(){
        System.out.println("Por favor ingrese su nombre");
        String nombre = input("Nombre");
        System.out.println("Por favor ingrese su login");
        String login = input("Login");
        System.out.println("Por favor ingrese su password");
        String password = input("Password");
        //hotel.crearAdministrador(nombre, login, password);
        System.out.println("Administrador creado con exito, ahora puede gestionar el hotel!!!");
    }

    
    private void crearEmpleado(){
        System.out.println("Por favor ingrese su nombre");
        String nombre = input("Nombre");
        System.out.println("Por favor ingrese su login");
        String login = input("Login");
        System.out.println("Por favor ingrese su password");
        String password = input("Password");
        //hotel.crearEmpleado(nombre, login, password);
        System.out.println("Empleado creado con exito, ahora puede registrar consumos!!!");
    }
    //Modificaciones que hace el administrador
    private void modificarHabitacion(){
        System.out.println("Por favor ingrese el numero de la habitacion");
        int numero = Integer.parseInt(input("Numero"));
        System.out.println("Por favor ingrese el precio de la habitacion");
        int precio = Integer.parseInt(input("Precio"));
        //hotel.modificarHabitacion(numero, precio);
        System.out.println("Habitacion modificada con exito!!!");
    }
    private void modificarPrecioHabitacion(){
        //System.out.println("Por favor ingrese el numero de la habitacion");
        String numero = input("Por favor ingrese el numero de la habitacion \n");
        //System.out.println("Por favor ingrese el nuevo precio de la habitacion");
        float precio = Float.parseFloat(input("Por favor ingrese el nuevo precio de la habitacion \n"));
        hotel.modificarPrecioHabitacion(numero, precio); 
    }
    
    private void crearHabitacion(){
        //System.out.println("Por favor ingrese el numero de la habitacion");
        String id = input("Por favor ingrese el numero de la habitacion \n");
        //System.out.println("Por favor ingrese la ubicacion de la habitacion");
        String ubicacion = input("Por favor ingrese la ubicacion de la habitacion \n");
        //System.out.println("Por favor ingrese la capacidad de la habitacion");
        int capacidad = Integer.parseInt(input("Por favor ingrese la capacidad de la habitacion \n"));
        //System.out.println("Por favor ingrese el tipo de la habitacion");
        String tipo = input("Por favor ingrese el tipo de la habitacion \n");
        //System.out.println("Por favor ingrese el precio de la habitacion");
        float precio = Float.parseFloat(input("Por favor ingrese el precio de la habitacion \n"));
        Boolean ocupada = false;
        //System.out.println("Por favor ingrese el tamaño de la cama");
        float tamanoCama = Float.parseFloat(input("Por favor ingrese el tamaño de la cama \n"));
        //System.out.println("Por favor ingrese la capacidad de la cama");
        int capacidadCama = Integer.parseInt(input("Por favor ingrese la capacidad de la cama \n"));
        //System.out.println("¿ Es cama para niños?");
        Boolean camaNinos = Boolean.parseBoolean(input("¿ Es cama para niños? 1 en caso de que si, 0 en caso de que no \n"));
        //System.out.println("Por favor ingrese si tiene balcon");
        Boolean balcon = Boolean.parseBoolean(input("Por favor ingrese si tiene balcon 1 en caso de que si, 0 en caso de que no \n"));
        //System.out.println("Por favor ingrese si tiene vista");
        Boolean vista = Boolean.parseBoolean(input("Por favor ingrese si tiene vista 1 en caso de que si, 0 en caso de que no \n"));
        //System.out.println("Por favor ingrese si tiene cocina");
        Boolean cocina = Boolean.parseBoolean(input("Por favor ingrese si tiene cocina 1 en caso de que si, 0 en caso de que no \n"));
        String fechaEntrada = null;
        String fechaSalida = null;
        hotel.crearHabitacion(id, ubicacion, capacidad, tipo, precio, ocupada, tamanoCama, capacidadCama, camaNinos, balcon, cocina, vista, fechaEntrada, fechaSalida);

    }

    private void agregarProducto(){
        //System.out.println("Por favor ingrese el nombre del producto");
        String nombre = input("Por favor ingrese el nombre del producto \n");
        //System.out.println("Por favor ingrese el precio del producto");
        float precio = Float.parseFloat(input("Por favor ingrese el precio del producto \n"));
        //System.out.println("Por favor ingrese las horas disponibles del producto");
        String horas = input("Por favor ingrese las horas disponibles del producto \n");
        hotel.agregarProducto(nombre, precio, horas);
    }
    private void modificarTarifaServicio(){
        //System.out.println("Por favor ingrese el nombre del servicio");
        String nombre = input("Por favor ingrese el nombre del servicio \n");
        //System.out.println("Por favor ingrese el nuevo precio del servicio");
        float precio = Float.parseFloat(input("Por favor ingrese el nuevo precio del servicio \n"));
        hotel.modificarTarifaServicio(nombre, precio);
    }

    //Todo lo del huesped
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
        Integer numHabitaciones = Integer.parseInt(input("Ingrese el numero de habitaciones que desea reservar"));
        
        for (int i = 1; i <= numHabitaciones; i++) {
            
            System.out.println("Por favor ingrese la cantidad de personas para la habitacioón");
            int cantidadPersonas = Integer.parseInt(input("Cantidad de personas"));
            System.out.println("Por favor ingrese la fecha de entrada");
            String fechaEntrada = input("Fecha de entrada formato: AAAA/MM/DD");
            System.out.println("Por favor ingrese la fecha de salida");
            String fechaSalida = input("Fecha de salida en formato: AAAA/MM/DD");
            System.out.println("Por facor ingrese el tipo de habitacion que desea");
            String tipoHabitacion = input("Tipo de habitacion: suite, suite doble o estandard");
            Integer numMenores = Integer.parseInt(input("Ingrese el numero de menores de edad"));
            hotel.realizarReserva(nombre, documento, correo, numeroCel, cantidadPersonas, fechaEntrada, fechaSalida, tipoHabitacion, numMenores);
            }

    }



	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		App consola = new App();
		consola.ejecutarAplicacion();
	}

}

