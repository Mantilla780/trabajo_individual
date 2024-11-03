package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controlador.ConexionBD;

public class ProyectoDAO {
    private Connection conexion;

    public ProyectoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo proyecto
    public boolean insertarProyecto(String nombreProyecto, String idUsuario) {
    String sqlSequence = "SELECT proyecto.proyectovivienda_seq.NEXTVAL FROM dual"; // Asegúrate de que la secuencia exista
    String sqlInsert = "INSERT INTO proyecto.proyectovivienda (IDPROYECTO, NOMBREPROYECTO, IDUSUARIO) VALUES (?, ?, ?)";

    try (PreparedStatement psSeq = conexion.prepareStatement(sqlSequence);
         PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {

        // Obtener el próximo valor de la secuencia
        ResultSet rs = psSeq.executeQuery();
        int idProyecto = 0;
        if (rs.next()) {
            idProyecto = rs.getInt(1);
        }

        // Insertar el proyecto con el ID generado
        psInsert.setInt(1, idProyecto);
        psInsert.setString(2, nombreProyecto);
        psInsert.setString(3, idUsuario);

        return psInsert.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error al insertar proyecto: " + e.getMessage());
        return false;
    }
}

    // Método para obtener la lista de proyectos
  public List<Proyecto> obtenerProyectos() {
    List<Proyecto> proyectos = new ArrayList<>();
    String sql = "SELECT p.IDPROYECTO, p.NOMBREPROYECTO, COUNT(t.NUMEROTORRE) AS NUMEROTORRES, p.IDUSUARIO " +
                 "FROM proyecto.PROYECTOVIVIENDA p " +
                 "LEFT JOIN proyecto.TORRE t ON p.IDPROYECTO = t.IDPROYECTO " +
                 "GROUP BY p.IDPROYECTO, p.NOMBREPROYECTO,p.IDUSUARIO"; // Cambiar aquí

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Proyecto proyecto = new Proyecto();
            proyecto.setIdproyecto(rs.getInt("IDPROYECTO"));
            proyecto.setNombreProyecto(rs.getString("NOMBREPROYECTO"));
            proyecto.setNumeroTorres(rs.getInt("NUMEROTORRES"));
            proyecto.setIdUsuario(rs.getString("IDUSUARIO"));
            proyectos.add(proyecto);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener proyectos: " + e.getMessage());
    }
    return proyectos;
}

    
    public List<Proyecto> obtenerProyectosBasicos() {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT IDPROYECTO, NOMBREPROYECTO FROM proyecto.PROYECTOVIVIENDA"; // Cambiar aquí

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setIdproyecto(rs.getInt("IDPROYECTO"));
                proyecto.setNombreProyecto(rs.getString("NOMBREPROYECTO"));
                proyectos.add(proyecto);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener proyectos básicos: " + e.getMessage());
        }
        return proyectos;
    }

    // Método para actualizar un proyecto
    public boolean actualizarProyecto(Proyecto proyecto) {
        String sqlUpdate = "UPDATE proyecto.PROYECTOVIVIENDA SET NOMBREPROYECTO = ?, IDUSUARIO = ? WHERE IDPROYECTO = ?";

        try {
            // Verificar si la conexión está cerrada y crear una nueva si es necesario
            if (conexion == null || conexion.isClosed()) {
                conexion = ConexionBD.getInstancia().getConnection(); // Asegúrate de que este método existe y devuelve una nueva conexión
            }

            try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
                psUpdate.setString(1, proyecto.getNombreProyecto());
                psUpdate.setString(2, proyecto.getIdUsuario());
                psUpdate.setInt(3, proyecto.getIdproyecto());

                return psUpdate.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar proyecto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProyecto(int idProyecto) {
        // Convertimos el idProyecto a String para que coincida con el tipo en la base de datos y Torre
        conexion = ConexionBD.getInstancia().getConnection();
        String idProyectoStr = String.valueOf(idProyecto);
        TorreDAO torreDAO = new TorreDAO(conexion);

        try {
            // Primero eliminamos las torres asociadas al proyecto
            boolean torresEliminadas = torreDAO.eliminarTorresPorProyecto(idProyectoStr);

            if (!torresEliminadas) {
                System.out.println("No se eliminaron torres o no existen torres para este proyecto.");
            }

            // Luego eliminamos el proyecto
            String sqlDelete = "DELETE FROM proyecto.PROYECTOVIVIENDA WHERE IDPROYECTO = ?"; // Cambiar aquí
            try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
                psDelete.setInt(1, idProyecto);
                return psDelete.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar proyecto: " + e.getMessage());
            return false;
        }
    }
}
