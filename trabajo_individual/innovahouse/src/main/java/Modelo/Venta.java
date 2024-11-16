/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author omaci
 */
public class Venta {
    private int idventa;
    private int PRECIOTOTALVENTA;
    private int numerocuotas;
    private String intereses;
    private String idusuario;
    private int cccliente;
    private int matinmueble;
    
    
    public Venta(){
    }

    public Venta(int idventa, int PRECIOTOTALVENTA, int numerocuotas, String intereses, String idusuario, int cccliente, int matinmueble) {
        this.idventa = idventa;
        this.PRECIOTOTALVENTA = PRECIOTOTALVENTA;
        this.numerocuotas = numerocuotas;
        this.intereses = intereses;
        this.idusuario = idusuario;
        this.cccliente = cccliente;
        this.matinmueble = matinmueble;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getPRECIOTOTALVENTA() {
        return PRECIOTOTALVENTA;
    }

    public void setPRECIOTOTALVENTA(int PRECIOTOTALVENTA) {
        this.PRECIOTOTALVENTA = PRECIOTOTALVENTA;
    }

    public int getNumerocuotas() {
        return numerocuotas;
    }

    public void setNumerocuotas(int numerocuotas) {
        this.numerocuotas = numerocuotas;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public int getCccliente() {
        return cccliente;
    }

    public void setCccliente(int cccliente) {
        this.cccliente = cccliente;
    }

    public int getMatinmueble() {
        return matinmueble;
    }

    public void setMatinmueble(int matinmueble) {
        this.matinmueble = matinmueble;
    } 
}
