/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Apartamento{
    @Id
    public String Matricula;
    public int Valor_Apartamento;
    public String Fecha_Escritura;
    public String Area;
    
    public Apartamento(){
        
    }

    public Apartamento(String Matricula, int Valor_Apartamento, String Fecha_Escritura, String Area) {
        this.Matricula = Matricula;
        this.Valor_Apartamento = Valor_Apartamento;
        this.Fecha_Escritura = Fecha_Escritura;
        this.Area = Area;
    }
    
    public void CrearApartamento(){
        
    }
    public void VisualizarApartamento(){
        
    }
    public void EditarApartamento(){
        
    }
    public void EliminarApartamento(){
        
    }
}
