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
    
    public Registro_Retiro(String nombreHuesped, int documento, String correo, int numeroCelular, int personasEsperadas, boolean registro, boolean salida, String identificador, int numeroMenores) {
        this.nombreHuesped = nombreHuesped;
        this.documento = documento;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.personasEsperadas = personasEsperadas;
        this.registro = registro;
        this.salida = salida;
        this.identificador = identificador;
        this.numeroMenores = numeroMenores;
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
}
