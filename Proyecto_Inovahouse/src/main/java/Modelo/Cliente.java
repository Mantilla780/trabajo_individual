/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
    @Id
    private int cedula;
    private String nombre;
    private String sisben;
    private String subsidioMinisterio;
    private String direccion;
    private int telefono;
    private String correoElectronico;
    
    @OneToMany(mappedBy="cliente")
   private ArrayList<Venta> listaPago;
    
    @OneToMany(mappedBy="cliente")
   private ArrayList<Venta> listaDeuda;

    public Cliente() {
    }

    public Cliente(int cedula, String nombre, String sisben, String subsidioMinisterio, String direccion, int telefono, String correoElectronico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sisben = sisben;
        this.subsidioMinisterio = subsidioMinisterio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSisben() {
        return sisben;
    }

    public void setSisben(String sisben) {
        this.sisben = sisben;
    }

    public String getSubsidioMinisterio() {
        return subsidioMinisterio;
    }

    public void setSubsidioMinisterio(String subsidioMinisterio) {
        this.subsidioMinisterio = subsidioMinisterio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
 
    
    
}
