/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Proyecto_vivienda{
    @Id
    public String ID_Proyecto;
    public String Nombre_Proyecto;
    public int Numero_Torres;
    
    public Proyecto_vivienda(){
    }

    public Proyecto_vivienda(String ID_Proyecto, String Nombre_Proyecto, int Numero_Torres){
        this.ID_Proyecto = ID_Proyecto;
        this.Nombre_Proyecto = Nombre_Proyecto;
        this.Numero_Torres = Numero_Torres;
    }
    
    public void CrearProyectoVivienda(){
        
    }
    public void VisualizarProyectoVivienda(){
        
    }
    public void EditarProyectoVivienda(){
        
    }
    public void EliminarProyectoVivienda(){
        
    }
}
