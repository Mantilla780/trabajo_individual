/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ProyectoVivienda;
import Modelo.Usuario;
import Persistencia.Controlador_Persistencia;
import java.util.List;

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
    
    
    public Usuario validarUsuario(String usuario, String contrasenia){
        Usuario usr = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        
     for (Usuario usu : listaUsuarios) {  
            if (usu.getNombreUsuario().equals(usuario)) {
                if(usu.getContraseña().equals(contrasenia)) {
                   usr = usu;
                    return usr;
                }
                else {
                   usr = null;
                    return usr;
                }
            }
            else {
                //mensaje = "Usuario no encontrado";
               // return mensaje;
               usr = null;
                    //return usr;
            }
        
        }
        
        return usr;
    }
}
