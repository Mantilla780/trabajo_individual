package Modelo;

public class Torre {
    private int idtorre;
    private int numerotorre;
    private int idproyecto;
    private int cantidadInmuebles; // Campo adicional para la cantidad de inmuebles

    // Constructor vacío
    public Torre() {}

    // Constructor sin cantidadInmuebles
    public Torre(int idtorre, int numerotorre, int idproyecto) {
        this.idtorre = idtorre;
        this.numerotorre = numerotorre;
        this.idproyecto = idproyecto;
    }

    // Constructor con cantidadInmuebles
    public Torre(int idtorre, int numerotorre, int idproyecto, int cantidadInmuebles) {
        this.idtorre = idtorre;
        this.numerotorre = numerotorre;
        this.idproyecto = idproyecto;
        this.cantidadInmuebles = cantidadInmuebles;
    }

    // Constructor sin IDTORRE (para inserciones)
    public Torre(int numerotorre, int idproyecto) {
        this.numerotorre = numerotorre;
        this.idproyecto = idproyecto;
    }

    // Getters y Setters
    public int getIdtorre() {
        return idtorre;
    }

    public void setIdtorre(int idtorre) {
        this.idtorre = idtorre;
    }

    public int getNumerotorre() {
        return numerotorre;
    }

    public void setNumerotorre(int numerotorre) {
        this.numerotorre = numerotorre;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public int getCantidadInmuebles() {
        return cantidadInmuebles;
    }

    public void setCantidadInmuebles(int cantidadInmuebles) {
        this.cantidadInmuebles = cantidadInmuebles;
    }
}
