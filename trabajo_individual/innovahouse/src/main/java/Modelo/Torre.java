/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Torre {
    private int numerotorre;
    private String idproyecto;

    public Torre() {
    }
    
    public Torre(int numerotorre, String idproyecto) {
        this.numerotorre = numerotorre;
        this.idproyecto = idproyecto;
    }

    public int getNumerotorre() {
        return numerotorre;
    }

    public void setNumerotorre(int numerotorre) {
        this.numerotorre = numerotorre;
    }

    public String getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(String idproyecto) {
        this.idproyecto = idproyecto;
    }   

    
}
