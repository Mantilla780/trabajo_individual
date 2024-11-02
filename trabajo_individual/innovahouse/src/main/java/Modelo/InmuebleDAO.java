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

    // Método para insertar un nuevo apartamento
    public boolean insertarApartamento(int matricula, String numeroApartamento, int valorApartamento, Date fechaEscritura, int area, String numeroTorre, String tipoUnidad) {
        String sqlInsert = "INSERT INTO APARTAMENTO (MATRICULA, NUMEROAPARTAMENTO, VALORAPARTAMENTO, FECHAESCRITURA, AREA, NUMEROTORRE, TIPOUNIDAD) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
            psInsert.setInt(1, matricula);
            psInsert.setString(2, numeroApartamento);
            psInsert.setInt(3, valorApartamento);
            psInsert.setDate(4, fechaEscritura);
            psInsert.setInt(5, area);
            psInsert.setString(6, numeroTorre);
            psInsert.setString(7, tipoUnidad);

            return psInsert.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener una lista de apartamentos según el número de torre
    public List<Inmueble> obtenerApartamentosPorTorre(String numeroTorre) {
        List<Inmueble> apartamentos = new ArrayList<>();
        String sqlSelect = "SELECT MATRICULA, NUMEROAPARTAMENTO, VALORAPARTAMENTO, FECHAESCRITURA, AREA, NUMEROTORRE, TIPOUNIDAD FROM APARTAMENTO WHERE NUMEROTORRE = ?";

        try (PreparedStatement psSelect = conexion.prepareStatement(sqlSelect)) {
            psSelect.setString(1, numeroTorre);
            ResultSet rs = psSelect.executeQuery();

            while (rs.next()) {
                Inmueble apartamento = new Inmueble();
                apartamento.setMatricula(rs.getInt("MATRICULA"));
                apartamento.setNumeroapartamento(rs.getString("NUMEROAPARTAMENTO"));
                apartamento.setValorapartamento(rs.getInt("VALORAPARTAMENTO"));
                apartamento.setFechaescritura(rs.getDate("FECHAESCRITURA"));
                apartamento.setArea(rs.getInt("AREA"));
                apartamento.setNumerotorre(rs.getString("NUMEROTORRE"));
                apartamento.setTipounidad(rs.getString("TIPOUNIDAD"));
                apartamentos.add(apartamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apartamentos;
    }

    // Método para actualizar un apartamento
    public boolean actualizarApartamento(Inmueble apartamento) {
        String sqlUpdate = "UPDATE APARTAMENTO SET NUMEROAPARTAMENTO = ?, VALORAPARTAMENTO = ?, FECHAESCRITURA = ?, AREA = ?, NUMEROTORRE = ?, TIPOUNIDAD = ? WHERE MATRICULA = ?";

        try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, apartamento.getNumeroapartamento());
            psUpdate.setInt(2, apartamento.getValorapartamento());
            psUpdate.setDate(3, apartamento.getFechaescritura());
            psUpdate.setInt(4, apartamento.getArea());
            psUpdate.setString(5, apartamento.getNumerotorre());
            psUpdate.setString(6, apartamento.getTipounidad());
            psUpdate.setInt(7, apartamento.getMatricula());

            return psUpdate.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un apartamento por matrícula
    public boolean eliminarApartamento(int matricula) {
        String sqlDelete = "DELETE FROM APARTAMENTO WHERE MATRICULA = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, matricula);
            return psDelete.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
