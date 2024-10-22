/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Torre {
    @Id
    public String Numero_Torre;
    public int Numero_Apartamentos;
    
    public Torre(){
        
    }

    public Torre(String Numero_Torre, int Numero_Apartamentos) {
        this.Numero_Torre = Numero_Torre;
        this.Numero_Apartamentos = Numero_Apartamentos;
    }
    
    public void CrearTorre(){
        
    }
    public void VisualizarTorre(){
        
    }
    public void EditarTorre(){
        
    }
    public void EliminarTorre(){
        
    }
}
