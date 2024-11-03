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

    public boolean insertarTorre(int numeroTorre,int idProyecto) {
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
    

     public List<Torre> obtenerTorresConCantidadInmuebles() {
        List<Torre> torres = new ArrayList<>();
        String sql = "SELECT t.NUMEROTORRE, t.IDPROYECTO, COUNT(i.MATRICULA) AS cantidad_inmuebles " +
                     "FROM TORRE t LEFT JOIN INMUEBLE i ON t.NUMEROTORRE = i.NUMEROTORRE " +
                     "GROUP BY t.NUMEROTORRE, t.IDPROYECTO ORDER BY t.NUMEROTORRE";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int numeroTorre = rs.getInt("NUMEROTORRE");
                String idProyecto = rs.getString("IDPROYECTO");
                int cantidadInmuebles = rs.getInt("cantidad_inmuebles");

                Torre torre = new Torre(numeroTorre, idProyecto, cantidadInmuebles);
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
