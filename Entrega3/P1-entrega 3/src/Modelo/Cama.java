package Modelo;

public class Cama {
    private float tamagnoCama;
    private int capacidadCama;
    private boolean camaNiños;

    public Cama() {
    }

    public Cama(float tamagnoCama, int capacidadCama, boolean camaNiños) {
        this.tamagnoCama = tamagnoCama;
        this.capacidadCama = capacidadCama;
        this.camaNiños = camaNiños;
    }

    public void crearCama(float tamagnoCama, int capacidadCama, boolean camaNiños) {
        this.tamagnoCama = tamagnoCama;
        this.capacidadCama = capacidadCama;
        this.camaNiños = camaNiños;
    }

    // GETTERS y SETTERS
    public float getTamagnoCama() {
        return tamagnoCama;
    }

    public void setTamagnoCama(float tamagnoCama) {
        this.tamagnoCama = tamagnoCama;
    }

    public int getCapacidadCama() {
        return capacidadCama;
    }

    public void setCapacidadCama(int capacidadCama) {
        this.capacidadCama = capacidadCama;
    }

    public boolean isCamaNiños() {
        return camaNiños;
    }

    public void setCamaNiños(boolean camaNiños) {
        this.camaNiños = camaNiños;
    }
}

