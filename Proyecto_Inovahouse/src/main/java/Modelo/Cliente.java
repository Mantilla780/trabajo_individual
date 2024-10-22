/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente{
    @Id
    private String Cedula;
    private String Nombre;
    private String SISBEN;
    private String Subsidio_Ministerio;
    private String Direccion;
    private String Telefono;
    private String Correo_Electronico;
    
    public Cliente(){
        
    }

    public Cliente(String Cedula, String Nombre, String SISBEN, String Subsidio_Ministerio, String Direccion, String Telefono, String Correo_Electronico){
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.SISBEN = SISBEN;
        this.Subsidio_Ministerio = Subsidio_Ministerio;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo_Electronico = Correo_Electronico;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSISBEN() {
        return SISBEN;
    }

    public void setSISBEN(String SISBEN) {
        this.SISBEN = SISBEN;
    }

    public String getSubsidio_Ministerio() {
        return Subsidio_Ministerio;
    }

    public void setSubsidio_Ministerio(String Subsidio_Ministerio) {
        this.Subsidio_Ministerio = Subsidio_Ministerio;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }
    
    
    
    public void CrearCliente(){
        
    }
    public void VisualizarCliente(){
        
    }
    public void EditarCliente(){
        
    }
    public void EliminarCliente(){
        
    }
}
