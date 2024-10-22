/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectointegrador.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID_Pago;
    private String Fecha_Pago;
    private int Valor_Pago;
    
    public Pago(){
        
    }

    public Pago(int ID_Pago, String Fecha_Pago, int Valor_Pago) {
        this.ID_Pago = ID_Pago;
        this.Fecha_Pago = Fecha_Pago;
        this.Valor_Pago = Valor_Pago;
    }
    
    public void RealizarPago(){
        
    }
}
