/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Apartamento")
public class Apartamento {
    @Id
    private String matricula;
    private String numeroApartamento;
    private int valorApartamento;
    private String fechaEscritura;
    private int area;
    private String numeroTorre;
    
    
    
    @ManyToOne
      @JoinColumn(name = "numeroTorre", referencedColumnName = "numeroTorre")
    private Torre Torre;
    

    public Apartamento() {
    }

    public Apartamento(String matricula, String numeroApartamento, int valorApartamento, String fechaEscritura, int area, String numeroTorre, Torre Torre) {
        this.matricula = matricula;
        this.numeroApartamento = numeroApartamento;
        this.valorApartamento = valorApartamento;
        this.fechaEscritura = fechaEscritura;
        this.area = area;
        this.numeroTorre = numeroTorre;
        this.Torre = Torre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public int getValorApartamento() {
        return valorApartamento;
    }

    public void setValorApartamento(int valorApartamento) {
        this.valorApartamento = valorApartamento;
    }

    public String getFechaEscritura() {
        return fechaEscritura;
    }

    public void setFechaEscritura(String fechaEscritura) {
        this.fechaEscritura = fechaEscritura;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getNumeroTorre() {
        return numeroTorre;
    }

    public void setNumeroTorre(String numeroTorre) {
        this.numeroTorre = numeroTorre;
    }

    public Torre getTorre() {
        return Torre;
    }

    public void setTorre(Torre Torre) {
        this.Torre = Torre;
    }

    
}
