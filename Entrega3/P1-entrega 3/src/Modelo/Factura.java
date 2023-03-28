package Modelo;

public class Factura {
    private float totalPago;
    private String fechaPago;

    public Factura() {
    }

    public Factura(float totalPago, String fechaPago) {
        this.totalPago = totalPago;
        this.fechaPago = fechaPago;
    }

    public float getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(float totalPago) {
        this.totalPago = totalPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void generarFacturaServicio() {
        // Implementar lógica
    }

    public void generarFacturaSalida() {
        // Implementar lógica 
    }
}
