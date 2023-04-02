package Procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import Modelo.Cama;
import Modelo.Habitacion;
import Modelo.Producto;
import Modelo.Servicio;


public class Procesamiento {

    public static ArrayList<Habitacion> cargar_habitaciones() throws FileNotFoundException, IOException
	{
		
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		String filename = "data/hab.txt";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									// las columnas
			linea = br.readLine();
			while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
			{
				// Separar los valores que estaban en una línea
				String[] partes = linea.split(";");
				Cama cama = new Cama(Float.parseFloat(partes[5]), Integer.parseInt(partes[6]), Boolean.parseBoolean(partes[7]));
				Habitacion habitacion = new Habitacion(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], Float.parseFloat(partes[4]), Boolean.parseBoolean(partes[8]), cama, Boolean.parseBoolean(partes[9]), Boolean.parseBoolean(partes[10]), Boolean.parseBoolean(partes[11]), partes[12], partes[13], Double.parseDouble(partes[14]));
				
				habitaciones.add(habitacion);
				
				
		
		
			linea = br.readLine(); // Leer la siguiente línea
	        }
		br.close();
		return habitaciones;
        }

    public static ArrayList<Producto> cargar_productos() throws FileNotFoundException, IOException
	{
		
		ArrayList<Producto> productos = new ArrayList<>();
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("/Users/juanl/Mi unidad/Cuarto Semestre/DPO/Proyecto1-1/Entrega3/P1-entrega 3/data/menuRestaurante.txt"));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									// las columnas
			linea = br.readLine();
			while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
			{
				// Separar los valores que estaban en una línea
				String[] partes = linea.split(";");
				
				
				Producto producto = new Producto(partes[0], Double.parseDouble(partes[1]), Boolean.parseBoolean(partes[2]));
				
				productos.add(producto);
				
				
		
		
			linea = br.readLine(); // Leer la siguiente línea
	        }
		br.close();
		return productos;
        }

	    public static ArrayList<Servicio> cargar_servicios() throws FileNotFoundException, IOException
	{
		
		ArrayList<Servicio> servicios = new ArrayList<>();
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("/Users/juanl/Mi unidad/Cuarto Semestre/DPO/Proyecto1-1/Entrega3/P1-entrega 3/data/servicios.txt"));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									// las columnas
			linea = br.readLine();
			while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
			{
				// Separar los valores que estaban en una línea
				String[] partes = linea.split(";");
				
				
				Servicio servicio = new Servicio(partes[0], Float.parseFloat(partes[1]), Boolean.parseBoolean(partes[2]));
				
				servicios.add(servicio);
				
				
		
		
			linea = br.readLine(); // Leer la siguiente línea
	        }
		br.close();
		return servicios;
        }

}
