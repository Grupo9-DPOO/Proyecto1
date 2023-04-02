package Modelo;
import java.util.*;

public class Registro_Retiro {
    private String nombreHuesped;
    private int documento;
    private String correo;
    private long numeroCelular;
    private int personasEsperadas;
    private boolean registro;
    private boolean salida;
    private String identificador;
    private int numeroMenores;
    private String fechaInicio;
    private String fechaFin;
    private int cantidadHabitaciones;
    private Huesped huesped;
    
    public Registro_Retiro(Huesped huesped, int personasEsperadas, boolean registro, boolean salida, String identificador, int numeroMenores, String fechaInicio, String fechaFin, int cantidadHabitaciones) {
        this.huesped = huesped;
        this.personasEsperadas = personasEsperadas;
        this.registro = registro;
        this.salida = salida;
        this.identificador = identificador;
        this.numeroMenores = numeroMenores;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadHabitaciones = cantidadHabitaciones;
    }
    
    public void generarRegistro() {
        
    }
    
    public void generarHistorial() {
        
    }
    
    public String getId() {
        
        return identificador;
    }
    
    public float getFactura() {
        
        return 0.0f;
    }

    public boolean habitacionOcupada(String idHabitacion, String fechaInicioConsulta, String fechaFinConsulta) {
        if (this.identificador.equals(idHabitacion)) {
            //Fechas están en formato "YYYY-MM-DD"
            int inicioActual = Integer.parseInt(this.fechaInicio.replace("-", ""));
            int finActual = Integer.parseInt(this.fechaFin.replace("-", ""));
            int inicioConsulta = Integer.parseInt(fechaInicioConsulta.replace("-", ""));
            int finConsulta = Integer.parseInt(fechaFinConsulta.replace("-", ""));

            // Comprobar si hay sobreposición entre las fechas
            //Si se sobreponen el método retorna true indicando que la habitación está ocupada en el rango de fechas
            if ((inicioConsulta >= inicioActual && inicioConsulta <= finActual) ||
                (finConsulta >= inicioActual && finConsulta <= finActual) ||
                (inicioConsulta <= inicioActual && finConsulta >= finActual)) {
                return true; // La habitación está ocupada en el rango de fechas especificado
            }
        }
        return false; // La habitación no está ocupada en el rango de fechas especificado
    }


    public int getDocumento() {
        return huesped.getDocumento();
    }

    public String getNombreHuesped() {
        return huesped.getNombre();
    }
}

