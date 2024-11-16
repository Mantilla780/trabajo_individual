package Modelo;

import Controlador.ConexionBD;
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

    // Método para eliminar una venta por ID
    public boolean eliminarVenta(int idventa) {
        String sqlDelete = "DELETE FROM proyecto.venta WHERE idventa = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, idventa);

            // Ejecuta la eliminación y devuelve true si se eliminó al menos un registro
            return psDelete.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar la venta con ID " + idventa + ": " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar una venta
    public boolean actualizarVenta(Venta venta) {
        String sqlUpdate = "UPDATE proyecto.venta SET preciototalventa = ?, numerocuotas = ?, intereses = ?, idusuario = ?, cccliente = ?, matinmueble = ? WHERE idventa = ?";

        try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
            psUpdate.setInt(1, venta.getPRECIOTOTALVENTA());
            psUpdate.setInt(2, venta.getNumerocuotas());
            psUpdate.setString(3, venta.getIntereses());
            psUpdate.setString(4, venta.getIdusuario());
            psUpdate.setInt(5, venta.getCccliente());
            psUpdate.setInt(6, venta.getMatinmueble());
            psUpdate.setInt(7, venta.getIdventa());

            // Ejecuta la actualización y devuelve true si se actualizó correctamente
            return psUpdate.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar la venta: " + e.getMessage());
            return false;
        }
    }
}
