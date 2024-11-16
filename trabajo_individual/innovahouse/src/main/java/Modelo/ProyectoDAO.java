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
    //String sqlSequence = "SELECT IntegradorInnovahouse.proyectovivienda_seq.NEXTVAL FROM dual"; // Asegúrate de que la secuencia exista
    //String sqlInsert = "INSERT INTO IntegradorInnovahouse.proyectovivienda (IDPROYECTO, NOMBREPROYECTO, IDUSUARIO) VALUES (?, ?, ?)";

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
                 //"FROM IntegradorInnovahouse.PROYECTOVIVIENDA p " +
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
        //String sql = "SELECT IDPROYECTO, NOMBREPROYECTO FROM IntegradorInnovahouse.PROYECTOVIVIENDA"; // Cambiar aquí

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

    // Método para actualizar un proyecto String sqlUpdate = "UPDATE IntegradorInnovahouse.PROYECTOVIVIENDA SET NOMBREPROYECTO = ?, IDUSUARIO = ? WHERE IDPROYECTO = ?";
    public boolean actualizarProyecto(Proyecto proyecto) {
        String sqlUpdate = "UPDATE proyecto.PROYECTOVIVIENDA SET NOMBREPROYECTO = ?, IDUSUARIO = ? WHERE IDPROYECTO = ?";
        

        try {
            // Verificar si la conexión está cerrada y crear una nueva si es necesario
            if (conexion == null || conexion.isClosed()) {
                conexion = ConexionBD.getInstancia().getConnection("Admin"); // Asegúrate de que este método existe y devuelve una nueva conexión
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
    conexion = ConexionBD.getInstancia().getConnection("Admin");
    TorreDAO torreDAO = new TorreDAO(conexion);
    InmuebleDAO inmuebleDAO = new InmuebleDAO(conexion);

    try {
        conexion.setAutoCommit(false);

        // Obtiene las torres relacionadas al proyecto
        List<Integer> idsTorres = torreDAO.obtenerIdsTorresPorProyecto(idProyecto);

        // Primero elimina los inmuebles asociados a cada torre
        for (int idTorre : idsTorres) {
            boolean inmueblesEliminados = inmuebleDAO.eliminarInmueblePorTorre(idTorre);
            if (!inmueblesEliminados) {
                System.out.println("No se encontraron inmuebles para la torre con ID " + idTorre);
            }
        }

        // Luego elimina las torres asociadas al proyecto
        boolean torresEliminadas = torreDAO.eliminarTorresPorProyecto(idProyecto);
        if (!torresEliminadas) {
            System.out.println("No se eliminaron torres o no existen torres para este proyecto.");
        }

        // Finalmente, elimina el proyecto
        String sqlDelete = "DELETE FROM proyecto.PROYECTOVIVIENDA WHERE IDPROYECTO = ?";
        //String sqlDelete = "DELETE FROM IntegradorInnovahouse.PROYECTOVIVIENDA WHERE IDPROYECTO = ?";
        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, idProyecto);
            boolean proyectoEliminado = psDelete.executeUpdate() > 0;

            conexion.commit();
            return proyectoEliminado;
        } catch (SQLException e) {
            conexion.rollback();
            System.err.println("Error al eliminar el proyecto: " + e.getMessage());
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
