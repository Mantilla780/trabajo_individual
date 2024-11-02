/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

public class Inmueble {
    private int matricula;
    private String numeroapartamento;
    private int valorapartamento;
    private Date fechaescritura;
    private int area;
    private String numerotorre;
    private String tipounidad;

    public Inmueble() {
    }

    public Inmueble(int matricula, String numeroapartamento, int valorapartamento, Date fechaescritura, int area, String numerotorre, String tipounidad) {
        this.matricula = matricula;
        this.numeroapartamento = numeroapartamento;
        this.valorapartamento = valorapartamento;
        this.fechaescritura = fechaescritura;
        this.area = area;
        this.numerotorre = numerotorre;
        this.tipounidad = tipounidad;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNumeroapartamento() {
        return numeroapartamento;
    }

    public void setNumeroapartamento(String numeroapartamento) {
        this.numeroapartamento = numeroapartamento;
    }

    public int getValorapartamento() {
        return valorapartamento;
    }

    public void setValorapartamento(int valorapartamento) {
        this.valorapartamento = valorapartamento;
    }

    public Date getFechaescritura() {
        return fechaescritura;
    }

    public void setFechaescritura(Date fechaescritura) {
        this.fechaescritura = fechaescritura;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getNumerotorre() {
        return numerotorre;
    }

    public void setNumerotorre(String numerotorre) {
        this.numerotorre = numerotorre;
    }

    public String getTipounidad() {
        return tipounidad;
    }

    public void setTipounidad(String tipounidad) {
        this.tipounidad = tipounidad;
    }

    
}
