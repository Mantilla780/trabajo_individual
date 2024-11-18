/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.ConexionBD;
import Modelo.Pago;
import Modelo.PagoDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PagoService {
    private final PagoDAO pagoDAO;

    public PagoService(Connection conexion) {
        this.pagoDAO = new PagoDAO(conexion);
    }

    /**
     * Generar pagos para una venta específica.
     * @param idVenta ID de la venta.
     * @param ccCliente Cédula del cliente.
     * @param fechaInicial Fecha inicial del pago.
     * @param idUsuario ID del usuario que realiza la operación.
     * @return true si los pagos se generaron exitosamente, false si se alcanzó el límite de cuotas o ocurrió un error.
     */
    public boolean generarPagosPorVenta(int idVenta, int ccCliente, String fechaInicial, String idUsuario) {
        return pagoDAO.generarPagosPorVenta(idVenta, ccCliente, fechaInicial, idUsuario);
    }

    /**
     * Obtener todos los pagos registrados en el sistema.
     * @return Lista de objetos Pago.
     */
    public List<Pago> listarPagos() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
            PagoDAO pagoDAO = new PagoDAO(conexion);
            return pagoDAO.listarPagos();
        } catch (SQLException e) {
            System.err.println("Error al listar pagos: " + e.getMessage());
            return null;
        }
    }

    /**
     * Actualizar el estado de un pago específico.
     * @param idPago ID del pago.
     * @param nuevoEstado Nuevo estado del pago.
     * @return true si el estado se actualizó correctamente, false en caso contrario.
     */
    public boolean actualizarEstadoPago(int idPago, String nuevoEstado) {
        try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
            PagoDAO pagoDAO = new PagoDAO(conexion);
            return pagoDAO.actualizarEstadoPago(idPago, nuevoEstado);
        } catch (SQLException e) {
            System.err.println("Error al actualizar estado de pago: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtener una lista de mensajes sobre pagos próximos a vencer o vencidos.
     * @return Lista de mensajes descriptivos.
     */
    public List<String> obtenerPagosProximos() {
        return pagoDAO.obtenerPagosProximos();
    }
}