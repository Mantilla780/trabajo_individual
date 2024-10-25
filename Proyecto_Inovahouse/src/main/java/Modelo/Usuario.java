/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    private String ID_Usuario;
    private String Nombre_Usuario;
    private int Telefono_Usuario;
    private String Correo_Usuario;
    private String Tipo_Usuario;

    public Usuario() {
    }

    public Usuario(String ID_Usuario, String Nombre_Usuario, int Telefono_Usuario, String Correo_Usuario, String Tipo_Usuario) {
        this.ID_Usuario = ID_Usuario;
        this.Nombre_Usuario = Nombre_Usuario;
        this.Telefono_Usuario = Telefono_Usuario;
        this.Correo_Usuario = Correo_Usuario;
        this.Tipo_Usuario = Tipo_Usuario;
    }

    public String getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(String ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public int getTelefono_Usuario() {
        return Telefono_Usuario;
    }

    public void setTelefono_Usuario(int Telefono_Usuario) {
        this.Telefono_Usuario = Telefono_Usuario;
    }

    public String getCorreo_Usuario() {
        return Correo_Usuario;
    }

    public void setCorreo_Usuario(String Correo_Usuario) {
        this.Correo_Usuario = Correo_Usuario;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }
    
    
}
