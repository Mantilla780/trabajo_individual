/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Venta")
public class Venta {
    @Id
    private String idVenta;
    private int precioTotalVenta;
    private int numeroCuotas;
    private int intereses;
    private String idUsuario;
    private int ccCliente;
    private String apMatricula;
    
    
    @ManyToOne
      @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;
    
    @OneToOne
    @JoinColumn(name = "apMatricula", referencedColumnName = "matricula")
    private Apartamento matricula ;
    
    @OneToMany(mappedBy="venta")
   private ArrayList<Venta> listaPago;
    
    @OneToOne
    @JoinColumn(name = "cccedula", referencedColumnName = "cedula")
    private Cliente cliente ;

    public Venta() {
    }

    public Venta(String idVenta, int precioTotalVenta, int numeroCuotas, int intereses, String idUsuario, long ccCliente, Usuario usuario, Apartamento matricula, ArrayList<Venta> listaPago, Cliente cliente) {
        this.idVenta = idVenta;
        this.precioTotalVenta = precioTotalVenta;
        this.numeroCuotas = numeroCuotas;
        this.intereses = intereses;
        this.idUsuario = idUsuario;
        this.ccCliente = (int) ccCliente;
        this.usuario = usuario;
        this.matricula = matricula;
        this.listaPago = listaPago;
        this.cliente = cliente;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public int getPrecioTotalVenta() {
        return precioTotalVenta;
    }

    public void setPrecioTotalVenta(int precioTotalVenta) {
        this.precioTotalVenta = precioTotalVenta;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public int getIntereses() {
        return intereses;
    }

    public void setIntereses(int intereses) {
        this.intereses = intereses;
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
        this.ccCliente = (int) ccCliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Apartamento getMatricula() {
        return matricula;
    }

    public void setMatricula(Apartamento matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Venta> getListaPago() {
        return listaPago;
    }

    public void setListaPago(ArrayList<Venta> listaPago) {
        this.listaPago = listaPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
}
