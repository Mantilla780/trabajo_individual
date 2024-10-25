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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Torre")
public class Torre {
    @Id
    private String numeroTorre;
    private int numeroApartamento;
    private String idProyecto;
    
    @ManyToOne
      @JoinColumn(name = "idProyecto", referencedColumnName = "idProyecto")
    private ProyectoVivienda proyecto;
    
    @OneToMany(mappedBy="Torre")
   private ArrayList<Venta> listaApartamentos;

    public Torre() {
    }

    public Torre(String numeroTorre, int numeroApartamento, String idProyecto, ProyectoVivienda proyecto, ArrayList<Venta> listaApartamentos) {
        this.numeroTorre = numeroTorre;
        this.numeroApartamento = numeroApartamento;
        this.idProyecto = idProyecto;
        this.proyecto = proyecto;
        this.listaApartamentos = listaApartamentos;
    }

    public String getNumeroTorre() {
        return numeroTorre;
    }

    public void setNumeroTorre(String numeroTorre) {
        this.numeroTorre = numeroTorre;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(int numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public ProyectoVivienda getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoVivienda proyecto) {
        this.proyecto = proyecto;
    }

    public ArrayList<Venta> getListaApartamentos() {
        return listaApartamentos;
    }

    public void setListaApartamentos(ArrayList<Venta> listaApartamentos) {
        this.listaApartamentos = listaApartamentos;
    }

   

  
    
            
            
}
