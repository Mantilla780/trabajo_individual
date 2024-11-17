package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class PagoDAO {
    private Connection conexion;

    public PagoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean generarPagosPorVenta(int idVenta, int ccCliente, String fechaInicial, String idUsuario) {
        String sql = "{ CALL proyecto.insertar_pagos_por_venta(?, ?, ?, ?) }";  // Agregar el parámetro idUsuario
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Convertir la fecha de String a Date
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaUtil = formato.parse(fechaInicial); // Convierte el String a java.util.Date
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime()); // Convierte a java.sql.Date

            // Establecer los parámetros en el PreparedStatement
            stmt.setInt(1, idVenta);
            stmt.setInt(2, ccCliente);
            stmt.setDate(3, fechaSql); // Usar java.sql.Date
            stmt.setString(4, idUsuario); // Agregar el idUsuario como parámetro

            // Ejecutar la sentencia
            stmt.execute();
            return true;
        } catch (SQLException | java.text.ParseException e) {
            System.err.println("Error al generar los pagos: " + e.getMessage());
            return false;
        }
    }

}
