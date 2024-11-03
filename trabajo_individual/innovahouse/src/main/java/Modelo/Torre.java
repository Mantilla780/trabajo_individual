package Modelo;

public class Torre {
    private int numerotorre;
    private String idproyecto;
    private int cantidadInmuebles; // Nuevo campo para la cantidad de inmuebles

    public Torre() {}

    public Torre(int numerotorre, String idproyecto, int cantidadInmuebles) {
        this.numerotorre = numerotorre;
        this.idproyecto = idproyecto;
        this.cantidadInmuebles = cantidadInmuebles;
    }

    public int getNumerotorre() {
        return numerotorre;
    }

    public void setNumerotorre(int numerotorre) {
        this.numerotorre = numerotorre;
    }

    public String getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(String idproyecto) {
        this.idproyecto = idproyecto;
    }

    public int getCantidadInmuebles() {
        return cantidadInmuebles;
    }

    public void setCantidadInmuebles(int cantidadInmuebles) {
        this.cantidadInmuebles = cantidadInmuebles;
    }
}
