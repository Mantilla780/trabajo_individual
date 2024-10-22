/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venta {
    @Id
    private String ID_Venta;
    private int Precio_Total_Venta;
    private int Numero_Cuotas;
    private int Intereses;
    
    public Venta(){
        
    }

    public Venta(String ID_Venta, int Precio_Total_Venta, int Numero_Cuotas, int Intereses) {
        this.ID_Venta = ID_Venta;
        this.Precio_Total_Venta = Precio_Total_Venta;
        this.Numero_Cuotas = Numero_Cuotas;
        this.Intereses = Intereses;
    }
    
    public void GestionVentaApartamento(){
        
    }
}
