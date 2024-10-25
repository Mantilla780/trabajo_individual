/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Deuda {
    @Id
    private String ID_Deuda;
    private String Tipo_Deuda;

    public Deuda() {
    }

    public Deuda(String ID_Deuda, String Tipo_Deuda) {
        this.ID_Deuda = ID_Deuda;
        this.Tipo_Deuda = Tipo_Deuda;
    }

    public String getID_Deuda() {
        return ID_Deuda;
    }

    public void setID_Deuda(String ID_Deuda) {
        this.ID_Deuda = ID_Deuda;
    }

    public String getTipo_Deuda() {
        return Tipo_Deuda;
    }

    public void setTipo_Deuda(String Tipo_Deuda) {
        this.Tipo_Deuda = Tipo_Deuda;
    }
    
    
}
