/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    private String idPago;
    private String fechaPago;
    private int valorPago;
    private String idUsuario;
    private long ccCliente;

    
    @OneToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario idUsuario;
    
    @ManyToOne
      @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    private Venta venta;
    
    @ManyToOne
      @JoinColumn(name = "cccedula", referencedColumnName = "cedula")
    private Cliente cliente;
    
    public Pago() {
    }

    public Pago(String idPago, String fechaPago, int valorPago, String idUsuario, long ccCliente, Usuario idUsuario, Venta venta, Cliente cliente) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.valorPago = valorPago;
        this.idUsuario = idUsuario;
        this.ccCliente = ccCliente;
        this.idUsuario = idUsuario;
        this.venta = venta;
        this.cliente = cliente;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getCcCliente() {
        return ccCliente;
    }

    public void setCcCliente(long ccCliente) {
        this.ccCliente = ccCliente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
  
}
