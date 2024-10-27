/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author omaci
 */
public class Usuario {
    private String idusuario;
    private String nombreUsuario;
    private String contrasena;
    private int telefonousuario;
    private String correousuario;
    private String tipousuario;
    
    
    public Usuario(){
        
    }

    public Usuario(String idusuario, String nombreUsuario, String contrasena, int telefonousuario, String correousuario, String tipousuario) {
        this.idusuario = idusuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.telefonousuario = telefonousuario;
        this.correousuario = correousuario;
        this.tipousuario = tipousuario;
    }
    

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTelefonousuario() {
        return telefonousuario;
    }

    public void setTelefonousuario(int telefonousuario) {
        this.telefonousuario = telefonousuario;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public void setCorreousuario(String correousuario) {
        this.correousuario = correousuario;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
    
    
    
}


