package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private boolean roomService;
    private List<Plato> platos;

    public Restaurante(boolean roomService, String archivoPlatos) {
        this.roomService = roomService;
        platos = new ArrayList<>();
        cargarPlatos(archivoPlatos);
    }

    private void cargarPlatos(String archivoPlatos) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoPlatos))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                float precio = Float.parseFloat(datos[1].trim());
                platos.add(new Plato(nombre, precio));
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo de platos: " + e.getMessage());
        }
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    class Plato {
        private String nombre;
        private float precio;

        public Plato(String nombre, float precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public float getPrecio() {
            return precio;
        }
    }

public String realizarPago(List<Producto> consumos, boolean pagarAhora, Habitacion habitacion) {
    float total = 0;
    StringBuilder factura = new StringBuilder();

    factura.append("Factura del Restaurante:\n");
    for (Producto consumo : consumos) {
        total += consumo.getPrecio();
        factura.append(consumo.getNombre())
                .append(" - $")
                .append(consumo.getPrecio())
                .append('\n');
    }
    factura.append("---------------------------\n");
    factura.append("Total: $").append(total).append('\n');

    if (pagarAhora) {
        factura.append("Pago realizado al momento.\n");
    } else {
        factura.append("Consumo agregado a la habitación ").append(habitacion.getId()).append(".\n");
        habitacion.agregarCargo(total);
    }

    return factura.toString();
    }
}
