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
     private int idproyecto;
    private String nombreProyecto;
    private int numeroTorres;
    private String idUsuario;
    
    public  Proyecto(){
        
    }

    public Proyecto(int idproyecto, String nombreProyecto, int numeroTorres, String idUsuario) {
        this.idproyecto = idproyecto;
        this.nombreProyecto = nombreProyecto;
        this.numeroTorres = numeroTorres;
        this.idUsuario = idUsuario;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

   

   

    
   
    
}
