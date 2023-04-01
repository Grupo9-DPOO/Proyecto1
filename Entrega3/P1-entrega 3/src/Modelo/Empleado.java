package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private List<Consumo> consumos;

    public Empleado() {
        consumos = new ArrayList<>();
    }

    public void registrarConsumo(Consumo consumo) {
        consumos.add(consumo);
    }

    public void pedirProductoRestaurante(String nombreProducto, String idHabitacion) {
        
    }
}

