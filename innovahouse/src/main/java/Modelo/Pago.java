package Modelo;

public class Pago {
    private int idPago;
    private String fechaPago;
    private double valorPago;
    private String estadoPago;
    private int idVenta;
    private int ccCliente;

    // Constructor vacío
    public Pago() {}

    // Constructor con parámetros
    public Pago(int idPago, String fechaPago, double valorPago, String estadoPago, int idVenta, int ccCliente) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.valorPago = valorPago;
        this.estadoPago = estadoPago;
        this.idVenta = idVenta;
        this.ccCliente = ccCliente;
    }

    // Getters y setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCcCliente() {
        return ccCliente;
    }

    public void setCcCliente(int ccCliente) {
        this.ccCliente = ccCliente;
    }
}
