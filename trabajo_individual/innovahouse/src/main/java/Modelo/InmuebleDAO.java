package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InmuebleDAO {
    private final Connection conexion;

    public InmuebleDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo inmueble
    public boolean insertarInmueble(int matricula, String numeroInmueble, int valorInmueble, Date fechaEscritura, int area, int idTorre, String tipoUnidad) {
        String sqlInsert = "INSERT INTO INMUEBLE (MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, AREA, IDTORRE, TIPOUNIDAD) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
            psInsert.setInt(1, matricula);
            psInsert.setString(2, numeroInmueble);
            psInsert.setInt(3, valorInmueble);
            psInsert.setDate(4, fechaEscritura);
            psInsert.setInt(5, area);
            psInsert.setInt(6, idTorre); // Cambiado a idTorre
            psInsert.setString(7, tipoUnidad);

            return psInsert.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener una lista de inmuebles según el ID de la torre
    public List<Inmueble> obtenerInmueblesPorTorre(int idTorre) {
        List<Inmueble> inmuebles = new ArrayList<>();
        String sqlSelect = "SELECT MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, AREA, IDTORRE, TIPOUNIDAD FROM INMUEBLE WHERE IDTORRE = ?";

        try (PreparedStatement psSelect = conexion.prepareStatement(sqlSelect)) {
            psSelect.setInt(1, idTorre);
            ResultSet rs = psSelect.executeQuery();

            while (rs.next()) {
                Inmueble inmueble = new Inmueble();
                inmueble.setMatricula(rs.getInt("MATRICULA"));
                inmueble.setNumeroinmueble(rs.getString("NUMEROINMUEBLE"));
                inmueble.setValorinmueble(rs.getInt("VALORINMUEBLE"));
                inmueble.setFechaescritura(rs.getDate("FECHAESCRITURA"));
                inmueble.setArea(rs.getInt("AREA"));
                inmueble.setIdtorre(rs.getInt("IDTORRE")); // Cambiado a idTorre
                inmueble.setTipounidad(rs.getString("TIPOUNIDAD"));
                inmuebles.add(inmueble);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inmuebles;
    }

    // Método para actualizar un inmueble
    public boolean actualizarInmueble(Inmueble inmueble) {
        String sqlUpdate = "UPDATE INMUEBLE SET NUMEROINMUEBLE = ?, VALORINMUEBLE = ?, FECHAESCRITURA = ?, AREA = ?, IDTORRE = ?, TIPOUNIDAD = ? WHERE MATRICULA = ?";

        try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, inmueble.getNumeroinmueble());
            psUpdate.setInt(2, inmueble.getValorinmueble());
            psUpdate.setDate(3, inmueble.getFechaescritura());
            psUpdate.setInt(4, inmueble.getArea());
            psUpdate.setInt(5, inmueble.getIdtorre()); // Cambiado a idTorre
            psUpdate.setString(6, inmueble.getTipounidad());
            psUpdate.setInt(7, inmueble.getMatricula());

            return psUpdate.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un inmueble por matrícula
    public boolean eliminarInmueble(int matricula) {
        String sqlDelete = "DELETE FROM INMUEBLE WHERE MATRICULA = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, matricula);
            return psDelete.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
