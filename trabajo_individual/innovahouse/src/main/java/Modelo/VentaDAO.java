package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private Connection conexion;

    public VentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar una nueva venta en la base de datos
    public boolean guardarVenta(Venta venta) {
        String sqlInsert = "INSERT INTO proyecto.venta (IDVENTA, PRECIOTOTALVENTA, NUMEROCUOTAS, INTERESES, IDUSUARIO, CCCLIENTE, MATINMUEBLE) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
            // Obtener el IDVENTA a partir de la secuencia
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT proyecto.SEQ_IDVENTA.NEXTVAL FROM DUAL");
            if (rs.next()) {
                int idVenta = rs.getInt(1);
                venta.setIdventa(idVenta);
            }

            // Setear los valores en el PreparedStatement
            psInsert.setInt(1, venta.getIdventa());
            psInsert.setInt(2, venta.getPRECIOTOTALVENTA());
            psInsert.setInt(3, venta.getNumerocuotas());
            psInsert.setString(4, venta.getIntereses());
            psInsert.setString(5, venta.getIdusuario());
            psInsert.setInt(6, venta.getCccliente());
            psInsert.setInt(7, venta.getMatinmueble());

            // Ejecutar la inserción
            return psInsert.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar la venta: " + e.getMessage());
            return false;
        }
    }

    // Método para listar todas las ventas
    public List<Venta> listarVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT v.idventa, " +
                     "       v.preciototalventa, " +
                     "       v.numerocuotas, " +
                     "       v.intereses, " +
                     "       v.matinmueble, " +
                     "       u.nombreUsuario AS nombreUsuario, " +
                     "       c.nombre AS nombreCliente " +
                     "FROM proyecto.venta v " +
                     "JOIN proyecto.usuario u ON v.idusuario = u.idUsuario " +
                     "JOIN proyecto.cliente c ON v.cccliente = c.cedula " +
                     "GROUP BY v.idventa, v.preciototalventa, v.numerocuotas, " +
                     "         v.intereses, v.matinmueble, u.nombreUsuario, c.nombre";

        try (Connection conn = ConexionBD.getInstancia().getConnection("Asesor");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdventa(rs.getInt("idventa"));
                venta.setPRECIOTOTALVENTA(rs.getInt("preciototalventa"));
                venta.setNumerocuotas(rs.getInt("numerocuotas"));
                venta.setIntereses(rs.getString("intereses"));
                venta.setMatinmueble(rs.getInt("matinmueble"));
                venta.setNombreUsuario(rs.getString("nombreUsuario"));
                venta.setNombreCliente(rs.getString("nombreCliente"));
                lista.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }
        return lista;
    }

    public boolean eliminarVenta(int idventa) {
        // Verificar si existen pagos con estado "PAG" para esta venta
        String sqlCheckPagos = "SELECT COUNT(*) AS pagosPagados " +
                                "FROM proyecto.pago " +
                                "WHERE idventa = ? AND estadoPago = 'PAG'";

        try (PreparedStatement psCheck = conexion.prepareStatement(sqlCheckPagos)) {
            psCheck.setInt(1, idventa);

            try (ResultSet rs = psCheck.executeQuery()) {
                if (rs.next() && rs.getInt("pagosPagados") > 0) {
                    // Si hay pagos con estado "PAG", no se puede eliminar la venta
                    System.out.println("No se puede eliminar la venta. Existen pagos asociados con estado 'PAG'.");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar pagos asociados: " + e.getMessage());
            return false;
        }

        // Eliminar los pagos relacionados con esta venta (si tienen estado 'PEN')
        String sqlDeletePagos = "DELETE FROM proyecto.pago WHERE idventa = ?";

        try (PreparedStatement psDeletePagos = conexion.prepareStatement(sqlDeletePagos)) {
            psDeletePagos.setInt(1, idventa);
            psDeletePagos.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar los pagos de la venta con ID " + idventa + ": " + e.getMessage());
            return false;
        }

        // Eliminar la venta
        String sqlDeleteVenta = "DELETE FROM proyecto.venta WHERE idventa = ?";

        try (PreparedStatement psDeleteVenta = conexion.prepareStatement(sqlDeleteVenta)) {
            psDeleteVenta.setInt(1, idventa);
            return psDeleteVenta.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la venta con ID " + idventa + ": " + e.getMessage());
            return false;
        }
    }
    
    public List<String> obtenerVentasConCliente() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT IDVENTA, CCCLIENTE FROM proyecto.venta";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idVenta = rs.getInt("IDVENTA");
                int ccCliente = rs.getInt("CCCLIENTE");
                // Agregar formato personalizado al ComboBox
                lista.add("Venta: " + idVenta + " - Cliente: " + ccCliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    public boolean verificarInmuebleVendido(int matriculaInmueble) throws SQLException {
        String query = "SELECT COUNT(*) FROM proyecto.venta WHERE matinmueble = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, matriculaInmueble);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si ya hay al menos una venta asociada
            }
        }
        return false;
    }
}
