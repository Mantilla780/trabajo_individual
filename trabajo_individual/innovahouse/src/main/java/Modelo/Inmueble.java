/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

public class Inmueble {
    private int matricula;
    private String numeroinmueble;
    private int valorinmueble;
    private Date fechaescritura;
    private String tipounidad;
    private int area;
    private int idtorre;

    public Inmueble() {
    }

    public Inmueble(int matricula, String numeroinmueble, int valorinmueble, Date fechaescritura, String tipounidad, int area, int idtorre) {
        this.matricula = matricula;
        this.numeroinmueble = numeroinmueble;
        this.valorinmueble = valorinmueble;
        this.fechaescritura = fechaescritura;
        this.tipounidad = tipounidad;
        this.area = area;
        this.idtorre = idtorre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNumeroinmueble() {
        return numeroinmueble;
    }

    public void setNumeroinmueble(String numeroinmueble) {
        this.numeroinmueble = numeroinmueble;
    }

    public int getValorinmueble() {
        return valorinmueble;
    }

    public void setValorinmueble(int valorinmueble) {
        this.valorinmueble = valorinmueble;
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

    public String getTipounidad() {
        return tipounidad;
    }

    public void setTipounidad(String tipounidad) {
        this.tipounidad = tipounidad;
    }

    public int getIdtorre() {
        return idtorre;
    }

    public void setIdtorre(int idtorre) {
        this.idtorre = idtorre;
    }
    
}
