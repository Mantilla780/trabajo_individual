/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Deuda")
public class Deuda implements Serializable {
    @Id
    private String idDeuda;
    private String tipoDeuda;
    private int    ccCliente;
    
    
    @ManyToOne
      @JoinColumn(name = "cccedula", referencedColumnName = "cedula")
    private Cliente cliente;

    public Deuda() {
    }

    public Deuda(String idDeuda, String tipoDeuda, Cliente cliente) {
        this.idDeuda = idDeuda;
        this.tipoDeuda = tipoDeuda;
        this.cliente = cliente;
    }

    public String getIdDeuda() {
        return idDeuda;
    }

    public void setIdDeuda(String idDeuda) {
        this.idDeuda = idDeuda;
    }

    public String getTipoDeuda() {
        return tipoDeuda;
    }

    public void setTipoDeuda(String tipoDeuda) {
        this.tipoDeuda = tipoDeuda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
