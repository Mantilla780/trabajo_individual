package Modelo;

import java.sql.Date;

public class Inmueble {
    private int matricula;
    private int numeroInmueble;
    private long valorInmueble;
    private Date fechaEscritura;
    private int area;
    private int idTorre;
    private String tipoInmueble;

    public Inmueble() {
    }

    public Inmueble(int matricula, int numeroInmueble, long valorInmueble, Date fechaEscritura, int area, int idTorre, String tipoInmueble) {
        this.matricula = matricula;
        this.numeroInmueble = numeroInmueble;
        this.valorInmueble = valorInmueble;
        this.fechaEscritura = fechaEscritura;
        this.area = area;
        this.idTorre = idTorre;
        this.tipoInmueble = tipoInmueble;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getNumeroInmueble() {
        return numeroInmueble;
    }

    public void setNumeroInmueble(int numeroInmueble) {
        this.numeroInmueble = numeroInmueble;
    }

    public long getValorInmueble() {
        return valorInmueble;
    }

    public void setValorInmueble(long valorInmueble) {
        this.valorInmueble = valorInmueble;
    }

    public Date getFechaEscritura() {
        return fechaEscritura;
    }

    public void setFechaEscritura(Date fechaEscritura) {
        this.fechaEscritura = fechaEscritura;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(int idTorre) {
        this.idTorre = idTorre;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }
}
