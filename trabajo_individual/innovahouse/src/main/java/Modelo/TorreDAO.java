package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TorreDAO {
    private final Connection conexion;

    public TorreDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertarTorre(int numeroTorre, int numeroApartamento, int idProyecto) {
        String sqlInsert = "INSERT INTO TORRE(NUMEROTORRE, IDPROYECTO) VALUES (?, ?)";
        
        try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
            // Insertar la torre con los datos especificados
            psInsert.setInt(1, numeroTorre);
            psInsert.setInt(2, idProyecto);

            return psInsert.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Torre> obtenerTodasLasTorres() {
    List<Torre> torres = new ArrayList<>();
    String sql = "SELECT NUMEROTORRE, IDPROYECTO FROM TORRE";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Torre torre = new Torre();
            torre.setNumerotorre(rs.getInt("NUMEROTORRE"));
            torre.setIdproyecto(rs.getString("IDPROYECTO"));
            torres.add(torre);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return torres;
}

    public List<Torre> obtenerTorresPorProyecto(String idProyecto) {
        List<Torre> torres = new ArrayList<>();
        String sql = "SELECT NUMEROTORRE, IDPROYECTO FROM TORRE";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, idProyecto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Torre torre = new Torre();
                torre.setNumerotorre(rs.getInt("NUMEROTORRE"));
                torre.setIdproyecto(rs.getString("IDPROYECTO"));
                torres.add(torre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return torres;
    }
    
    public boolean eliminarTorresPorProyecto(String idProyecto) {
        String sqlDelete = "DELETE FROM TORRE WHERE IDPROYECTO = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setString(1, idProyecto);
            return psDelete.executeUpdate() > 0; // Devuelve true si elimina una o más torres
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
