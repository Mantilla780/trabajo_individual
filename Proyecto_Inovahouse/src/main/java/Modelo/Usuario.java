/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
   private String idUsuario;
   private String nombreUsuario;
   private int telefonoUsuario;
   private String correoUsuario;
   private String contrasena;
   private String tipoUsuario;
   
   @OneToMany(mappedBy="usuario")
   private ArrayList<Venta> listaVentas;
   
   @OneToMany(mappedBy="usuario")
   private ArrayList<Venta> listaProyectos;
    

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombreUsuario, int telefonoUsuario, String correoUsuario, String contraseña, String tipoUsuario, ArrayList<Venta> listaVentas, ArrayList<Venta> listaProyectos) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasena = contraseña;
        this.tipoUsuario = tipoUsuario;
        this.listaVentas = listaVentas;
        this.listaProyectos = listaProyectos;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public ArrayList<Venta> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(ArrayList<Venta> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }


   
}
