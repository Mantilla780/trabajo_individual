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

    public boolean generarPagosPorVenta(int idVenta, int ccCliente, String fechaInicial, String idUsuario) {
        try {
            // Verificar el número de pagos existentes para la venta
            String sqlCountPagos = "SELECT COUNT(*) AS totalPagos FROM proyecto.pago WHERE idVenta = ?";
            try (PreparedStatement stmtCount = conexion.prepareStatement(sqlCountPagos)) {
                stmtCount.setInt(1, idVenta);
                try (ResultSet rs = stmtCount.executeQuery()) {
                    if (rs.next()) {
                        int totalPagos = rs.getInt("totalPagos");

                        // Obtener el número de cuotas permitidas de la venta
                        String sqlCuotas = "SELECT numerocuotas FROM proyecto.venta WHERE idventa = ?";
                        try (PreparedStatement stmtCuotas = conexion.prepareStatement(sqlCuotas)) {
                            stmtCuotas.setInt(1, idVenta);
                            try (ResultSet rsCuotas = stmtCuotas.executeQuery()) {
                                if (rsCuotas.next()) {
                                    int numeroCuotas = rsCuotas.getInt("numerocuotas");

                                    // Verificar si ya se alcanzó el límite de cuotas
                                    if (totalPagos >= numeroCuotas) {
                                        System.err.println("No se pueden generar más pagos. Se alcanzó el número máximo de cuotas permitidas.");
                                        return false;
                                    }
                                } else {
                                    System.err.println("No se encontró la venta con ID: " + idVenta);
                                    return false;
                                }
                            }
                        }
                    }
                }
            }

            // Lógica para insertar los nuevos pagos
            String sql = "{ CALL proyecto.insertar_pagos_por_venta(?, ?, ?, ?) }"; // Agregar el parámetro idUsuario
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
            }
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
    
    public boolean actualizarEstadoPago(int idPago, String nuevoEstado) {
        String sql = "UPDATE proyecto.Pago SET EstadoPago = ?, FechaPago = CURRENT_DATE WHERE idPago = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPago);
            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
