package Procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Modelo.Habitacion;
import Modelo.Producto;


public class Procesamiento {

    public static ArrayList<Habitacion> cargar_habitacion() throws FileNotFoundException, IOException
	{
		
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		
		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									// las columnas
			linea = br.readLine();
			while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
			{
				// Separar los valores que estaban en una línea
				String[] partes = linea.split(";");
				
				
				Habitacion habitacion = new Habitacion(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6]);
				
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
		BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
									// las columnas
			linea = br.readLine();
			while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
			{
				// Separar los valores que estaban en una línea
				String[] partes = linea.split(";");
				
				
				Producto producto = new Producto(partes[0], partes[1]);
				
				productos.add(producto);
				
				
		
		
			linea = br.readLine(); // Leer la siguiente línea
	        }
		br.close();
		return productos;
        }

}
