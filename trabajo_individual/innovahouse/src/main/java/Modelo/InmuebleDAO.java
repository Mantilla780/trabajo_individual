package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InmuebleDAO {
    private Connection conexion;

    public InmuebleDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo inmueble
    public boolean insertarInmueble(int matricula, int numeroInmueble, long valorInmueble, Date fechaEscritura, int area, int idTorre, String tipoInmueble) {
        String sqlInsert = "INSERT INTO proyecto.INMUEBLE (MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, AREA, IDTORRE, TIPOINMUEBLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        //String sqlInsert = "INSERT INTO IntegradorInnovahouse.INMUEBLE (MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, AREA, IDTORRE, TIPOINMUEBLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
            psInsert.setInt(1, matricula);
            psInsert.setInt(2, numeroInmueble);
            psInsert.setLong(3, valorInmueble);
            psInsert.setDate(4, fechaEscritura);
            psInsert.setInt(5, area);
            psInsert.setInt(6, idTorre);
            psInsert.setString(7, tipoInmueble);

            return psInsert.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener una lista de inmuebles según el ID de torre
    public Inmueble obtenerInmueblePorNumero(int numeroInmueble) {
    Inmueble inmueble = null;
    String sqlSelect = "SELECT i.MATRICULA, i.NUMEROINMUEBLE, i.VALORINMUEBLE, i.FECHAESCRITURA, i.AREA, i.IDTORRE, t.NUMEROTORRE, i.TIPOINMUEBLE " +
                       "FROM proyecto.INMUEBLE i JOIN proyecto.TORRE t ON i.IDTORRE = t.IDTORRE WHERE i.NUMEROINMUEBLE = ?";
    //"FROM IntegradorInnovahouse.INMUEBLE i JOIN proyecto.TORRE t ON i.IDTORRE = t.IDTORRE WHERE i.NUMEROINMUEBLE = ?";

    try (PreparedStatement psSelect = conexion.prepareStatement(sqlSelect)) {
        psSelect.setInt(1, numeroInmueble);
        ResultSet rs = psSelect.executeQuery();

        if (rs.next()) {
            inmueble = new Inmueble();
            inmueble.setMatricula(rs.getInt("MATRICULA"));
            inmueble.setNumeroInmueble(rs.getInt("NUMEROINMUEBLE"));
            inmueble.setValorInmueble(rs.getLong("VALORINMUEBLE"));
            inmueble.setFechaEscritura(rs.getDate("FECHAESCRITURA"));
            inmueble.setArea(rs.getInt("AREA"));
            inmueble.setIdTorre(rs.getInt("IDTORRE"));
            inmueble.setTipoInmueble(rs.getString("TIPOINMUEBLE"));
            inmueble.setNumeroTorre(rs.getInt("NUMEROTORRE"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return inmueble;
}
    
    public Inmueble obtenerInmueblePorMatricula(int matricula) {
        Inmueble inmueble = null;
        Connection conexion = ConexionBD.getInstancia().getConnection("Admin"); // Obtener o inicializar la conexión
        String sqlSelect = "SELECT MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, TIPOINMUEBLE, AREA, IDTORRE FROM proyecto.INMUEBLE WHERE MATRICULA = ?";
        //String sqlSelect = "SELECT MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, TIPOINMUEBLE, AREA, IDTORRE FROM IntegradorInnovahouse.INMUEBLE WHERE MATRICULA = ?";


        try (PreparedStatement psSelect = conexion.prepareStatement(sqlSelect)) {
            psSelect.setInt(1, matricula);
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                inmueble = new Inmueble();
                inmueble.setMatricula(rs.getInt("MATRICULA"));
                inmueble.setNumeroInmueble(rs.getInt("NUMEROINMUEBLE"));
                inmueble.setValorInmueble(rs.getLong("VALORINMUEBLE"));
                inmueble.setFechaEscritura(rs.getDate("FECHAESCRITURA"));
                inmueble.setArea(rs.getInt("AREA"));
                inmueble.setIdTorre(rs.getInt("IDTORRE"));
                inmueble.setTipoInmueble(rs.getString("TIPOINMUEBLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inmueble;
    }

    // Método para actualizar un inmueble
    public boolean actualizarInmueble(Inmueble inmueble) {
        String sqlUpdate = "UPDATE proyecto.INMUEBLE SET NUMEROINMUEBLE = ?, VALORINMUEBLE = ?, FECHAESCRITURA = ?, AREA = ?, IDTORRE = ?, TIPOINMUEBLE = ? WHERE MATRICULA = ?";
        //String sqlUpdate = "UPDATE IntegradorInnovahouse.INMUEBLE SET NUMEROINMUEBLE = ?, VALORINMUEBLE = ?, FECHAESCRITURA = ?, AREA = ?, IDTORRE = ?, TIPOINMUEBLE = ? WHERE MATRICULA = ?";

        try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
            psUpdate.setInt(1, inmueble.getNumeroInmueble());
            psUpdate.setLong(2, inmueble.getValorInmueble());
            psUpdate.setDate(3, inmueble.getFechaEscritura());
            psUpdate.setInt(4, inmueble.getArea());
            psUpdate.setInt(5, inmueble.getIdTorre());
            psUpdate.setString(6, inmueble.getTipoInmueble());
            psUpdate.setInt(7, inmueble.getMatricula());

            return psUpdate.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un inmueble por matrícula
    public boolean eliminarInmueble(int matricula) {
        String sqlDelete = "DELETE FROM proyecto.INMUEBLE WHERE MATRICULA = ?";
        // String sqlDelete = "DELETE FROM IntegradorInnovahouse.INMUEBLE WHERE MATRICULA = ?";

        try {
            // Verifica si la conexión está cerrada
            if (conexion == null || conexion.isClosed()) {
                System.out.println("Conexión cerrada, abriendo la conexión.");
                conexion = ConexionBD.getInstancia().getConnection("Admin"); // Vuelve a abrir la conexión si está cerrada
            }

            try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
                psDelete.setInt(1, matricula);
                return psDelete.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todos los inmuebles
    public List<Inmueble> obtenerInmuebles() {
        List<Inmueble> inmuebles = new ArrayList<>();
        String sqlSelect = "SELECT MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, AREA, IDTORRE, TIPOINMUEBLE FROM proyecto.INMUEBLE";
        //String sqlSelect = "SELECT MATRICULA, NUMEROINMUEBLE, VALORINMUEBLE, FECHAESCRITURA, AREA, IDTORRE, TIPOINMUEBLE FROM IntegradorInnovahouse.INMUEBLE";

        try (PreparedStatement psSelect = conexion.prepareStatement(sqlSelect)) {
            ResultSet rs = psSelect.executeQuery();

            while (rs.next()) {
                Inmueble inmueble = new Inmueble();
                inmueble.setMatricula(rs.getInt("MATRICULA"));
                inmueble.setNumeroInmueble(rs.getInt("NUMEROINMUEBLE"));
                inmueble.setValorInmueble(rs.getLong("VALORINMUEBLE"));
                inmueble.setFechaEscritura(rs.getDate("FECHAESCRITURA"));
                inmueble.setArea(rs.getInt("AREA"));
                inmueble.setIdTorre(rs.getInt("IDTORRE"));
                inmueble.setTipoInmueble(rs.getString("TIPOINMUEBLE"));
                inmuebles.add(inmueble);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inmuebles;
    }
    
    public boolean eliminarInmueblePorTorre(int idTorre) {
        String sqlDelete = "DELETE FROM proyecto.INMUEBLE WHERE IDTORRE = ?";
        //String sqlDelete = "DELETE FROM IntegradorInnovahouse.INMUEBLE WHERE IDTORRE = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, idTorre);
            return psDelete.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar inmuebles por torre: " + e.getMessage());
            return false;
        }
    }
    
   public boolean existenVentasPorTorre(int idTorre) {
    String sql = "SELECT COUNT(*) AS TOTAL_VENTAS " +
                 "FROM proyecto.venta v " +
                 "JOIN proyecto.inmueble i ON v.MATINMUEBLE = i.MATRICULA " +
                 "WHERE i.IDTORRE = ?";
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, idTorre); // Reemplaza el marcador de posición con el ID de la torre
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("TOTAL_VENTAS") > 0; // Devuelve true si hay ventas asociadas
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al verificar ventas por torre: " + e.getMessage());
    }
    return false; // Por defecto, devuelve false si ocurre un error
}
   
   public boolean existeVentaPorTorre(int idTorre) throws SQLException {
    // SQL para contar ventas relacionadas con los inmuebles de la torre
    String sql = "SELECT COUNT(*) FROM proyecto.venta WHERE MATINMUEBLE IN (SELECT MATRICULA FROM proyecto.inmueble WHERE IDTORRE = ?)";
    
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, idTorre);  // Establecemos el idTorre como parámetro
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // Si el conteo es mayor que 0, hay ventas asociadas
            }
        }
    }
    return false; // Si no hay ventas asociadas, retorna false
}
    public boolean estaVendido(int matricula) {
        String sql = "SELECT 1 FROM proyecto.VENTA WHERE MATINMUEBLE = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Si existe un registro, el inmueble está vendido
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Asumir no vendido en caso de error
        }
    }
}
