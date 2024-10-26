/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.ProyectoVivienda;

/**
 *
 * @author Admin
 */
public class Controlador_Persistencia {
    ApartamentoJpaController apartamentoJpa = new ApartamentoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    DeudaJpaController deudaJpa = new DeudaJpaController();
    PagoJpaController pagoJpa = new PagoJpaController();
    ProyectoViviendaJpaController proyectoviviendaJpa = new ProyectoViviendaJpaController();
    TorreJpaController torreJpa = new TorreJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();

    public void guardarProyectoVivienda(ProyectoVivienda proyecto) throws Exception {
    try {
        proyectoviviendaJpa.create(proyecto);
    } catch (Exception e) {
        e.printStackTrace(); // Esto es solo para propósitos de depuración
        throw e; // Vuelve a lanzar la excepción
        }
    }
}
