/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author omaci
 */
public class Proyecto {
     private String idproyecto;
    private String nombreproyecto;
    private int numerotorres;
    private String idusuario;
    
    public  Proyecto(){
        
    }

    public Proyecto(String idproyecto, String nombreproyecto, int numerotorres, String idusuario) {
        this.idproyecto = idproyecto;
        this.nombreproyecto = nombreproyecto;
        this.numerotorres = numerotorres;
        this.idusuario = idusuario;
    }

    public String getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(String idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public int getNumerotorres() {
        return numerotorres;
    }

    public void setNumerotorres(int numerotorres) {
        this.numerotorres = numerotorres;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    
}
