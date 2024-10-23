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
@Table(name = "ProyectoVivienda")
public class ProyectoVivienda {
    @Id
    private String idProyecto;
    private String nombreProyecto;
    private int numeroTorres;
    
    @ManyToOne
      @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;
    
    @OneToMany(mappedBy="proyecto")
   private ArrayList<Venta> listaTorre;

    public ProyectoVivienda() {
    }

    public ProyectoVivienda(String idProyecto, String nombreProyecto, int numeroTorres) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.numeroTorres = numeroTorres;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public int getNumeroTorres() {
        return numeroTorres;
    }

    public void setNumeroTorres(int numeroTorres) {
        this.numeroTorres = numeroTorres;
    }
    
    
}
