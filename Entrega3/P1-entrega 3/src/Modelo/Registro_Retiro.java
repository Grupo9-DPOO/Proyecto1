package Modelo;

public class Registro_Retiro {
    private String nombreHuesped;
    private int documento;
    private String correo;
    private int numeroCelular;
    private int personasEsperadas;
    private boolean registro;
    private boolean salida;
    private String identificador;
    private int numeroMenores;
    private String fechaInicio;
    private String fechaFin;
    
    public Registro_Retiro(String nombreHuesped, int documento, String correo, int numeroCelular, int personasEsperadas, boolean registro, boolean salida, String identificador, int numeroMenores, String fechaInicio, String fechaFin) {
        this.nombreHuesped = nombreHuesped;
        this.documento = documento;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.personasEsperadas = personasEsperadas;
        this.registro = registro;
        this.salida = salida;
        this.identificador = identificador;
        this.numeroMenores = numeroMenores;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public void generarRegistro() {
        
    }
    
    public void generarHistorial() {
        
    }
    
    public String getId() {
        
        return "";
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
}

