package Controlador;

import Modelo.Venta;
import Modelo.VentaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Servicio para manejar la lógica de negocio de las ventas.
 */
public class VentaService {

    private VentaDAO ventaDAO;

    public VentaService(Connection conexion) {
        this.ventaDAO = new VentaDAO(conexion);
    }

    /**
     * Agrega una nueva venta en la base de datos.
     * 
     * @param venta La venta a guardar.
     * @return true si la venta se guardó correctamente, false en caso contrario.
     */
    public boolean agregarVenta(Venta venta) {
        return ventaDAO.guardar(venta);
    }

    /**
     * Obtiene la lista de todas las ventas registradas.
     * 
     * @return Lista de ventas.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public List<Venta> obtenerVentas() throws SQLException {
        return ventaDAO.listarVentas();
    }

    /**
     * Elimina una venta por su ID.
     * 
     * @param idVenta El ID de la venta a eliminar.
     * @return true si la venta se eliminó correctamente, false en caso contrario.
     */
    public boolean eliminarVenta(int idVenta) {
        return ventaDAO.eliminarVenta(idVenta);
    }

    /**
     * Actualiza los datos de una venta existente.
     * 
     * @param venta La venta con los datos actualizados.
     * @return true si la venta se actualizó correctamente, false en caso contrario.
     */
    public boolean actualizarVenta(Venta venta) {
        return ventaDAO.actualizarVenta(venta);
    }
}
