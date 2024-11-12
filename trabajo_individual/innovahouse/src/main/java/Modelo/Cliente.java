/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author omaci
 */
public class Cliente {
    private int cedula;
    private String nombre;
    private String sisben;
    private int SUBSIDIOMINISTERIO;
    private String direccion;
    private int telefono;
    private String correoelectronico;
    
    
    public Cliente(){
        
    }

    public Cliente(int cedula, String nombre, String sisben, int SUBSIDIOMINISTERIO, String direccion, int telefono, String correoelectronico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sisben = sisben;
        this.SUBSIDIOMINISTERIO = SUBSIDIOMINISTERIO;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoelectronico = correoelectronico;
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

    public int getSUBSIDIOMINISTERIO() {
        return SUBSIDIOMINISTERIO;
    }

    public void setSUBSIDIOMINISTERIO(int SUBSIDIOMINISTERIO) {
        this.SUBSIDIOMINISTERIO = SUBSIDIOMINISTERIO;
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

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

}
