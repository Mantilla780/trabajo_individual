/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

class Proyecto_vivienda{
    public String ID_Proyecto;
    public String Nombre_Proyecto;
    public int Numero_Torres;

    public Proyecto_vivienda(String ID_Proyecto, String Nombre_Proyecto, int Numero_Torres) {
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

class Torre{
    public String Numero_Torre;
    public int Numero_Apartamentos;

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

class Apartamento{
    public String Matricula;
    public int Valor_Apartamento;
    public String Fecha_Escritura;
    public String Area;

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

class Venta{
    private String ID_Venta;
    private int Precio_Total_Venta;
    private int Numero_Cuotas;
    private int Intereses;

    public Venta(String ID_Venta, int Precio_Total_Venta, int Numero_Cuotas, int Intereses) {
        this.ID_Venta = ID_Venta;
        this.Precio_Total_Venta = Precio_Total_Venta;
        this.Numero_Cuotas = Numero_Cuotas;
        this.Intereses = Intereses;
    }
    
    public void GestionVentaApartamento(){
        
    }
}

class Pago{
    private String ID_Pago;
    private String Fecha_Pago;
    private int Valor_Pago;

    public Pago(String ID_Pago, String Fecha_Pago, int Valor_Pago) {
        this.ID_Pago = ID_Pago;
        this.Fecha_Pago = Fecha_Pago;
        this.Valor_Pago = Valor_Pago;
    }
    
    public void RealizarPago(){
        
    }
}

class Cliente{
    private String ID_Cliente;
    private String Cedula;
    private String Nombre;
    private String SISBEN;
    private String Subsidio_Ministerio;
    private String Direccion;
    private String Telefono;
    private String Correo_Electronico;

    public Cliente(String ID_Cliente, String Cedula, String Nombre, String SISBEN, String Subsidio_Ministerio, String Direccion, String Telefono, String Correo_Electronico) {
        this.ID_Cliente = ID_Cliente;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.SISBEN = SISBEN;
        this.Subsidio_Ministerio = Subsidio_Ministerio;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo_Electronico = Correo_Electronico;
    }
    
    public void CrearCliente(){
        
    }
    public void VisualizarCliente(){
        
    }
    public void EditarCliente(){
        
    }
    public void EliminarCliente(){
        
    }
}

public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("Hello Worlss!");
    }
}
