package Consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import Modelo.PMS;
import Modelo.Habitacion;


public class App {

    private PMS hotel = new PMS();

    public void ejecutarAplicacion() throws FileNotFoundException, IOException {
	    boolean continuar = true;
        while (continuar)
		{
        mostrarMenuHotel();
        int opciones_hotel = Integer.parseInt(input("Por favor seleccione una opcion \n"));
        //Crear y asignar al huesped
        if (opciones_hotel == 1) {
            crearHuesped();
        }

        //Opciones que puede escoger el huesped
        else if (opciones_hotel == 5) {
            mostrarMenuHuesped();
            int opciones_huesped = Integer.parseInt(input("Por favor seleccione una opcion \n"));
            if (opciones_huesped == 1){
                pedirProductoRestaurante();
            }
            else if (opciones_huesped == 2){
                solicitarServicio();
            }
            else if (opciones_huesped == 3){
                realizarCheckout();
            }
            else{
                System.out.println("Opcion no valida");
            }
        }   

        //Funcionalidades del administrador
        else if (opciones_hotel == 2) {
            mostrarMenuAdmin();
            int opciones_admin = Integer.parseInt(input("Por favor seleccione una opcion \n"));
            //Modificar precios habitaciones
            if (opciones_admin == 1){
                 modificarPrecioHabitacion();
            }
            //Cargar y agragar habitaciones
            else if (opciones_admin == 2){
                System.out.println("1. Agregar habitacion. ");
                System.out.println("2. Cargar habitaciones. ");
                int carga = Integer.parseInt(input("Por favor seleccione una opcion \n"));
                if (carga == 1){
                    crearHabitacion();
                }
                else if (carga == 2){
                    hotel.cargarHabitaciones();
                    hotel.cargarServicios();
                }
                else{
                    System.out.println("Opcion no valida");
                }
            }
            //Consultar inventario
            else if (opciones_admin == 3){
                hotel.consultarInventario();
            }
            //Cargar y agregar productos
            else if (opciones_admin == 4){
                System.out.println("1. Agregar producto. ");
                System.out.println("2. Cargar productos. ");
                int carga_prod = Integer.parseInt(input("Por favor seleccione una opcion \n"));
                //Crear prod
                if (carga_prod == 1){
                    agregarProducto();
                }
                //Cargar prod
                else if (carga_prod == 2){
                    hotel.cargarProductos();
                }
                else{
                    System.out.println("Opcion no valida");
                }
            }
            //Modificar tarifa servicio
            else if (opciones_admin == 5){
                modificarTarifaServicio();
            }

            else{
                System.out.println("Opcion no valida");
            }
        }

        //Funcionalidades del empleado
            else if (opciones_hotel == 3) {
                mostrarMenuEmpleado();
                HashMap<String, String> datos = hotel.consultarConsumos();
                for (String key : datos.keySet()) {
                    System.out.println(" El consumo de la habitacion " + key + "es: " + datos.get(key));
                }
            }

            //Opciones huesped
            else if (opciones_hotel == 5) {
                mostrarMenuHuesped();
                int opciones_huesped = Integer.parseInt(input("Por favor seleccione una opcion \n"));
                if (opciones_huesped == 4){
                    System.out.println("Por favor, ingrese su nombre:");
                    String nombre = input("Nombre");
                    System.out.println("Por favor, ingrese su documento:");
                    int documento = Integer.parseInt(input("Documento"));
                    System.out.println("Por favor, ingrese la fecha en que realizó la reserva (AAAA/MM/DD):");
                    String fechaReserva = input("Fecha de reserva");
                    System.out.println("Por favor, ingrese cuántas horas han pasado desde que realizó la reserva:");
                    int horasDesdeReserva = Integer.parseInt(input("Horas desde la reserva"));
                    String idHabitacion= input("Por favor ingrese el Id de su habitacion");
                    boolean cancelacionExitosa = hotel.cancelarReserva(documento, idHabitacion, horasDesdeReserva);
                
                    if (cancelacionExitosa) {
                        System.out.println("Reserva cancelada con éxito.");
                    } 
                    else {
                        System.out.println("No se pudo cancelar la reserva. Han pasado más de 48 horas desde que se realizó la reserva.");
                    }
                }

                }
            //Funcionalidades del recepcionista
            else if (opciones_hotel == 4) {
                mostrarMenuRecepcionista();
                int recepcion = Integer.parseInt(input("Por favor seleccione una opcion \n"));
                if (recepcion ==1){
                    HashMap<String, String> datos = hotel.consultarInventarioRecepcionista();
                    System.out.println("El inventario actual es: ");
                    for (String key : datos.keySet()) {
                        System.out.println(key + " : " + datos.get(key));
                    }
                }
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
        System.out.println("4. Si es un huesped ");
    }

    public void mostrarMenuHotel(){
        System.out.println("Escoga que usuario es: ");
        System.out.println("1. Quiero reservar una habitacion. ");
        System.out.println("2. Si es un administrador.");
        System.out.println("3. Si es un empleado.");
        System.out.println("4. Si es un recepcionista.");
        System.out.println("5. Solicitar un servicio.");
    }

    private void mostrarMenuAdmin(){
        System.out.println("1. Modificar el precio de una habitacion. ");
        System.out.println("2. Agregar o cargar habitaciones. ");
        System.out.println("3. Consultar el inventario de habitaciones. ");
        System.out.println("4. Agregar o cargar productos ");
        System.out.println("5. Modificar tarifa Servicio ");
    }   
    private void mostrarMenuHuesped(){
        System.out.println("1. Pedir algo del restaurante. ");
        System.out.println("2. Solicitar un servicio ");
        System.out.println("3. hacer check out. ");
        System.out.println("4. Cancelar reserva.");
    }
    private void mostrarMenuRecepcionista(){
        System.out.println("1. Consultar habitaciones. ");

    }
    private void mostrarMenuEmpleado(){
        System.out.println("1. Consultar cosumos de una habitacion. ");

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
        float precioBase = 0;
        hotel.crearHabitacion(id, ubicacion, capacidad, tipo, precio, ocupada, tamanoCama, capacidadCama, camaNinos, balcon, cocina, vista, fechaEntrada, fechaSalida,precioBase );

    }

    private void agregarProducto(){
        //System.out.println("Por favor ingrese el nombre del producto");
        String nombre = input("Por favor ingrese el nombre del producto \n");
        //System.out.println("Por favor ingrese el precio del producto");
        double precio = Float.parseFloat(input("Por favor ingrese el precio del producto \n"));
        //System.out.println("Por favor ingrese las horas disponibles del producto");
        boolean roomService = Boolean.parseBoolean(input(("Por favor ingrese si tiene este producto se puede llevar por room service o no \n")));
        hotel.agregarProducto(nombre, precio, roomService);
    }
    private void modificarTarifaServicio(){
        //System.out.println("Por favor ingrese el nombre del servicio");
        String nombre = input("Por favor ingrese el nombre del servicio \n");
        //System.out.println("Por favor ingrese el nuevo precio del servicio");
        float precio = Float.parseFloat(input("Por favor ingrese el nuevo precio del servicio \n"));
        hotel.modificarTarifaServicio(nombre, precio);
    }

    private void pedirProductoRestaurante() {
        System.out.println("Por favor, ingrese el número de la habitación:");
        String idHabitacion = input("Número de habitación");
        for (int i = 0; i < hotel.getProductos().size();i++){
            System.out.println(i + ". Nombre del producto: " + hotel.getProductos().get(i).getNombre());
            System.out.println("Precio del producto: " + hotel.getProductos().get(i).getPrecio());;
        }
        System.out.println("Por favor, ingrese el nnumero de producto que desea:");
        Integer numeroProducto = Integer.parseInt(input("Número de producto"));
        String nombreProducto = hotel.getProductos().get(numeroProducto).getNombre();
        System.out.println("¿Desea pagar el producto ahora (1) o agregarlo a la cuenta de la habitación (2)?");
        int opcionPago = Integer.parseInt(input("Opción de pago"));
        if (opcionPago == 2){
            hotel.pedirProductoRestaurante(idHabitacion, numeroProducto);
            System.out.println("Se agrego correctamente" + nombreProducto + " a sus consumos para pagar en checkout" );
        }
        else if (opcionPago == 1){
            System.out.println("Gracias por haber hecho el pago inmediatamente!!!");
        }
        else{
            System.out.println("Opcion no valida");
        }
    }

    private void solicitarServicio(){
        System.out.println("Por favor, ingrese el número de la habitación:");
        String idHabitacion = input("Número de habitación");
        for (int i = 0; i < hotel.getServicios().size(); i++){
            System.out.println(i + ". Nombre del servicio: " + hotel.getServicios().get(i).getNombre());
            System.out.println("Precio del servicio: " + hotel.getServicios().get(i).getPrecio());
        }
        System.out.println("Por favor, ingrese el numero de servicio que desea:");
        Integer numeroServicio = Integer.parseInt(input("Número de servicio"));
        System.out.println("¿Desea pagar el producto ahora (1) o agregarlo a la cuenta de la habitación (2)?");
        int opcionPago = Integer.parseInt(input("Opción de pago"));
        if (opcionPago == 2){
            hotel.registrarServicio(idHabitacion, numeroServicio);
            System.out.println("Se agrego correctamente" + hotel.getServicios().get(numeroServicio).getNombre() + "a sus consumos para pagar en checkout" );
        }
        else if (opcionPago == 1){
            System.out.println("Gracias por haber hecho el pago inmediatamente!!!");
        }
        else{
            System.out.println("Opcion no valida");
        }
    }
    
    //Esta función sirve para hacer el "check-out". Aquí está planteado para utilizar los cargos añadidos por los servicios
    private void realizarCheckout() {
        System.out.println("Por favor, ingrese el número de la habitación:");
        String idHabitacion = input("Número de habitación");
    
        float totalCargos = hotel.realizarCheckoutt(idHabitacion);
    
        if (totalCargos >= 0) {
            System.out.println("Gracias por desocupar la habitacion" + idHabitacion  + " tiene un saldo a pagar de: " + totalCargos);
            System.out.println("Check-out realizado con éxito.");
        } else {
            System.out.println("Lo sentimos, no se pudo realizar el check-out.");
        }
    }
    

    //Todo lo del huesped
    private void crearHuesped(){
        System.out.println("Por favor ingrese su nombre");
        String nombre = input("Nombre");
        System.out.println("Por favor ingrese su documento");
        int documento = Integer.parseInt(input("Documento"));
        System.out.println("Por favor ingrese su numero de celular");
        long numeroCel = Long.parseLong(input("Numero de celular"));
        System.out.println("Por favor ingrese su correo electronico");
        String correo = input("Correo electronico");
        hotel.crearHuesped(nombre, documento, numeroCel, correo);
        System.out.println("Huesped creado con exito, ahora podemos reservarle una habitacion!!!");
        Habitacion habitacionAsignada;
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

            habitacionAsignada = hotel.realizarReserva(nombre, documento, correo, numeroCel, cantidadPersonas, fechaEntrada, fechaSalida, tipoHabitacion, numMenores, numHabitaciones);

            //Info de la habitación asignada
            if(habitacionAsignada!=null){
            System.out.println("Habitación asignada:");
            System.out.println("Número de habitación: " + habitacionAsignada.getId());
            System.out.println("Ubicación: " + habitacionAsignada.getUbicacion());
            System.out.println("Capacidad: " + habitacionAsignada.getCapacidad());
            System.out.println("Tipo de habitación: " + habitacionAsignada.getTipo());
            System.out.println("Precio: " + habitacionAsignada.getPrecio());

            hotel.realizarReserva(nombre, documento, correo, numeroCel, cantidadPersonas, fechaEntrada, fechaSalida, tipoHabitacion, numMenores, numHabitaciones);
            System.out.println("Reserva realizada con éxito.");
            }
            else{
                System.out.println("Lo sentimos, no hay habitaciones disponibles que cumplan con los requisitos.");

            }
        }
    }

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		App consola = new App();
		consola.ejecutarAplicacion();
	}

}

