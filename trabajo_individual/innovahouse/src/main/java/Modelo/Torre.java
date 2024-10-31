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
    private int numeroapartamento;
    private String idproyecto;

    public Torre() {
    }

    public Torre(int numerotorre, int numeroapartamento, String idproyecto) {
        this.numerotorre = numerotorre;
        this.numeroapartamento = numeroapartamento;
        this.idproyecto = idproyecto;
    }

    public int getNumerotorre() {
        return numerotorre;
    }

    public void setNumerotorre(int numerotorre) {
        this.numerotorre = numerotorre;
    }

    public int getNumeroapartamento() {
        return numeroapartamento;
    }

    public void setNumeroapartamento(int numeroapartamento) {
        this.numeroapartamento = numeroapartamento;
    }

    public String getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(String idproyecto) {
        this.idproyecto = idproyecto;
    }
}
