package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {
    private Connection conexion;

    public PagoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean generarPagosPorVenta(int idVenta, int ccCliente, String fechaInicial) {
    String sql = "{ CALL proyecto.insertar_pagos_por_venta(?, ?, ?) }";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        
        // Convertir la fecha de String a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaUtil = formato.parse(fechaInicial); // Convierte el String a java.util.Date
        java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime()); // Convierte a java.sql.Date
        
        stmt.setInt(1, idVenta);
        stmt.setInt(2, ccCliente);
        stmt.setDate(3, fechaSql); // Usar java.sql.Date
        
        stmt.execute();
        return true;
    } catch (SQLException | java.text.ParseException e) {
        System.err.println("Error al generar los pagos: " + e.getMessage());
        return false;
        }
    }
    
        // Método para listar todos los pagos
    public List<Pago> listarPagos() {
        List<Pago> pagos = new ArrayList<>();
        String sqlSelect = "SELECT idPago, fechaPago, valorPago, estadoPago, idVenta, ccCliente FROM proyecto.pago";

        try (PreparedStatement psSelect = conexion.prepareStatement(sqlSelect);
             ResultSet rs = psSelect.executeQuery()) {

            while (rs.next()) {
                Pago pago = new Pago(
                    rs.getInt("idPago"),
                    rs.getString("fechaPago"),
                    rs.getDouble("valorPago"),
                    rs.getString("estadoPago"),
                    rs.getInt("idVenta"),
                    rs.getInt("ccCliente")
                );
                pagos.add(pago);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pagos: " + e.getMessage());
        }
        return pagos;
    }
    
        // Método para eliminar un pago por su ID
    public boolean eliminarPago(int idPago) {
        String sqlDelete = "DELETE FROM proyecto.pago WHERE idPago = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, idPago);

            return psDelete.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar pago: " + e.getMessage());
            return false;
        }
    }
}
