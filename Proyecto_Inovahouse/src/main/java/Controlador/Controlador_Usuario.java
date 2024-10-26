/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ProyectoVivienda;
import Persistencia.Controlador_Persistencia;

/**
 *
 * @author Admin
 */
public class Controlador_Usuario {
    
    Controlador_Persistencia controlPersis = new Controlador_Persistencia();
    
    public void guardarProyectoVivienda(String nombreproyecto, int numerotorres) throws Exception{
        ProyectoVivienda proyecto = new ProyectoVivienda();
        proyecto.setNombreProyecto(nombreproyecto);
        proyecto.setNumeroTorres(numerotorres);
        
        controlPersis.guardarProyectoVivienda(proyecto);
    }
    
}
