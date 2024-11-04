package Modelo;

import Controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TorreDAO {
    private Connection conexion;

    public TorreDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertarTorre(int numeroTorre, int idProyecto) {
    String sqlSequence = "SELECT proyecto.seq_idtorre.NEXTVAL FROM dual"; // Asegúrate de que la secuencia exista
    String sqlInsert = "INSERT INTO proyecto.TORRE(IDTORRE, NUMEROTORRE, IDPROYECTO) VALUES (?, ?, ?)";

    try (PreparedStatement psSeq = conexion.prepareStatement(sqlSequence);
         PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {

        // Obtener el próximo valor de la secuencia
        ResultSet rs = psSeq.executeQuery();
        int idTorre = 0;
        if (rs.next()) {
            idTorre = rs.getInt(1);
        }

        // Insertar la torre con el ID generado
        psInsert.setInt(1, idTorre);
        psInsert.setInt(2, numeroTorre);
        psInsert.setInt(3, idProyecto);

        return psInsert.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error al insertar torre: " + e.getMessage());
        return false;
    }
}


    public List<Torre> obtenerTorresConCantidadInmuebles() {
        List<Torre> torres = new ArrayList<>();
        String sql = "SELECT t.IDTORRE, t.NUMEROTORRE, t.IDPROYECTO, COUNT(i.MATRICULA) AS cantidad_inmuebles " +
                     "FROM proyecto.TORRE t LEFT JOIN proyecto.INMUEBLE i ON t.IDTORRE = i.IDTORRE " +
                     "GROUP BY t.IDTORRE, t.NUMEROTORRE, t.IDPROYECTO ORDER BY t.NUMEROTORRE";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idTorre = rs.getInt("IDTORRE");
                int numeroTorre = rs.getInt("NUMEROTORRE");
                int idProyecto = rs.getInt("IDPROYECTO");
                int cantidadInmuebles = rs.getInt("cantidad_inmuebles");

                Torre torre = new Torre(idTorre, numeroTorre, idProyecto, cantidadInmuebles);
                torres.add(torre);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener torres: " + e.getMessage());
        }
        return torres;
    }

    public Torre obtenerTorrePorNumero(int numeroTorre) throws SQLException {
        String query = "SELECT idtorre, numerotorre, idproyecto FROM proyecto.TORRE WHERE numerotorre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, numeroTorre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Torre(
                    rs.getInt("idtorre"),
                    rs.getInt("numerotorre"),
                    rs.getInt("idproyecto")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener torre por número: " + e.getMessage());
        }
        return null;
    }

    public boolean eliminarTorresPorProyecto(int idProyecto) {
        String sqlDelete = "DELETE FROM proyecto.TORRE WHERE IDPROYECTO = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, idProyecto);
            return psDelete.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar torres por proyecto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarTorre(Torre torre) {
        String sqlUpdate = "UPDATE proyecto.TORRE SET NUMEROTORRE = ?, IDPROYECTO = ? WHERE IDTORRE = ?";

        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = ConexionBD.getInstancia().getConnection();
            }

            try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
                psUpdate.setInt(1, torre.getNumerotorre());
                psUpdate.setInt(2, torre.getIdproyecto());
                psUpdate.setInt(3, torre.getIdtorre()); // Asegúrate de setear IDTORRE
                return psUpdate.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar torre: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarTorre(int numeroTorre) {
        String sql = "DELETE FROM proyecto.TORRE WHERE NUMEROTORRE = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, numeroTorre);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar torre: " + e.getMessage());
            return false;
        }
    }
}
