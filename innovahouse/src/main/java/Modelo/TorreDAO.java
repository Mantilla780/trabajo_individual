package Modelo;

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
    //String sqlSequence = "SELECT IntegradorInnovaHouse.seq_idtorre.NEXTVAL FROM dual"; // Asegúrate de que la secuencia exista
    //String sqlInsert = "INSERT INTO IntegradorInnovaHouse.TORRE(IDTORRE, NUMEROTORRE, IDPROYECTO) VALUES (?, ?, ?)";

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
                     //"FROM IntegradorInnovahouse.TORRE t LEFT JOIN proyecto.INMUEBLE i ON t.IDTORRE = i.IDTORRE " +
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
    
    public List<Torre> obtenerTorresBasicas() {
    List<Torre> torres = new ArrayList<>();
    String sql = "SELECT IDTORRE, NUMEROTORRE FROM proyecto.TORRE"; // Cambiar según esquema y tabla
    //String sql = "SELECT IDTORRE, NUMEROTORRE FROM IntegradorInnovahouse.TORRE"; // Cambiar según esquema y tabla

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Torre torre = new Torre();
            torre.setIdtorre(rs.getInt("IDTORRE"));
            torre.setNumerotorre(rs.getInt("NUMEROTORRE"));
            torres.add(torre);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener torres básicas: " + e.getMessage());
    }
    return torres;
}


    public Torre obtenerTorrePorNumero(int numeroTorre) throws SQLException {
        String query = "SELECT idtorre, numerotorre, idproyecto FROM proyecto.TORRE WHERE numerotorre = ?";
        //String query = "SELECT idtorre, numerotorre, idproyecto FROM IntegradorInnovahouse.TORRE WHERE numerotorre = ?";
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
        //String sqlDelete = "DELETE FROM IntegradorInnovahouse.TORRE WHERE IDPROYECTO = ?";

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
        //String sqlUpdate = "UPDATE IntegradorInnovahouse.TORRE SET NUMEROTORRE = ?, IDPROYECTO = ? WHERE IDTORRE = ?";

        try {
            // Verificar si la conexión está cerrada y abrirla si es necesario
            if (conexion == null || conexion.isClosed()) {
                conexion = ConexionBD.getInstancia().getConnection("Admin");
            }

            try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
                psUpdate.setInt(1, torre.getNumerotorre());
                psUpdate.setInt(2, torre.getIdproyecto());
                psUpdate.setInt(3, torre.getIdtorre()); // Asegúrate de setear IDTORRE

                int rowsUpdated = psUpdate.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Torre actualizada con éxito.");
                    return true; // Retornar verdadero si se actualizó correctamente
                } else {
                    System.out.println("No se encontró ninguna torre para actualizar.");
                    return false; // Retornar falso si no se actualizó ninguna fila
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir la traza completa para más detalles
            System.err.println("Error al actualizar torre: " + e.getMessage());
            return false; // Retornar falso en caso de error
        }
    }
    public List<Integer> obtenerIdsTorresPorProyecto(int idProyecto) {
    List<Integer> idsTorres = new ArrayList<>();
    String sql = "SELECT IDTORRE FROM proyecto.TORRE WHERE IDPROYECTO = ?";
    //String sql = "SELECT IDTORRE FROM IntegradorInnovahouse.TORRE WHERE IDPROYECTO = ?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, idProyecto);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            idsTorres.add(rs.getInt("IDTORRE"));
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener IDs de torres por proyecto: " + e.getMessage());
    }

    return idsTorres;
}

public boolean eliminarTorre(int numeroTorre) {
    // Obtén la conexión desde la instancia de ConexionBD
    conexion = ConexionBD.getInstancia().getConnection("Admin");

    try {
        // Inicia una transacción
        conexion.setAutoCommit(false);

        // Obtener el ID de la torre a eliminar
        Torre torre = obtenerTorrePorNumero(numeroTorre);
        if (torre == null) {
            System.out.println("La torre con el número especificado no existe.");
            return false;
        }

        // Verificar si existen ventas asociadas a los inmuebles de la torre
        InmuebleDAO inmuebleDAO = new InmuebleDAO(conexion);
        boolean tieneVentas = inmuebleDAO.existeVentaPorTorre(torre.getIdtorre());

        if (tieneVentas) {
            System.out.println("La torre tiene ventas asociadas y no se puede eliminar.");
            return false;
        }

        // Eliminar inmuebles asociados a la torre
        boolean inmueblesEliminados = inmuebleDAO.eliminarInmueblePorTorre(torre.getIdtorre());

        if (!inmueblesEliminados) {
            System.out.println("No se eliminaron inmuebles o no existen inmuebles para esta torre.");
        }

        // Eliminar la torre
        String sqlDeleteTorre = "DELETE FROM proyecto.TORRE WHERE NUMEROTORRE = ?";
        try (PreparedStatement psDeleteTorre = conexion.prepareStatement(sqlDeleteTorre)) {
            psDeleteTorre.setInt(1, numeroTorre);
            boolean torreEliminada = psDeleteTorre.executeUpdate() > 0;

            // Confirma la transacción si todo va bien
            conexion.commit();
            return torreEliminada;
        } catch (SQLException e) {
            // Si hay un error, realiza un rollback de la transacción
            conexion.rollback();
            System.err.println("Error al eliminar la torre: " + e.getMessage());
            return false;
        }
    } catch (SQLException e) {
        System.err.println("Error en la operación de eliminación: " + e.getMessage());
        return false;
    } finally {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

  
}
