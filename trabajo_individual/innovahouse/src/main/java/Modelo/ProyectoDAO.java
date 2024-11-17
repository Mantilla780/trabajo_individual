package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
    

public String eliminarProyecto(int idProyecto) {
    conexion = ConexionBD.getInstancia().getConnection("Admin");
    TorreDAO torreDAO = new TorreDAO(conexion);
    InmuebleDAO inmuebleDAO = new InmuebleDAO(conexion);

    try {
        conexion.setAutoCommit(false);

        // Obtiene las torres relacionadas al proyecto
        List<Integer> idsTorres = torreDAO.obtenerIdsTorresPorProyecto(idProyecto);

        // Verifica si hay inmuebles vendidos asociados a las torres del proyecto
        for (int idTorre : idsTorres) {
            if (inmuebleDAO.existenVentasPorTorre(idTorre)) {
                conexion.rollback(); // Deshacer cualquier cambio realizado hasta ahora
                return "No se puede eliminar el proyecto porque existen inmuebles vendidos en la torre con ID " + idTorre;
            }
        }

        // Elimina los inmuebles asociados a cada torre
        for (int idTorre : idsTorres) {
            if (!inmuebleDAO.eliminarInmueblePorTorre(idTorre)) {
                return "No se encontraron inmuebles para la torre con ID " + idTorre;
            }
        }

        // Elimina las torres asociadas al proyecto
        if (!torreDAO.eliminarTorresPorProyecto(idProyecto)) {
            return "No se eliminaron torres o no existen torres para este proyecto.";
        }

        // Finalmente, elimina el proyecto
        String sqlDelete = "DELETE FROM proyecto.PROYECTOVIVIENDA WHERE IDPROYECTO = ?";
        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, idProyecto);
            boolean proyectoEliminado = psDelete.executeUpdate() > 0;

            if (proyectoEliminado) {
                conexion.commit(); // Confirmar la transacción
                return "Proyecto eliminado con éxito.";
            } else {
                conexion.rollback();
                return "No se pudo eliminar el proyecto, podría no existir.";
            }
        }
    } catch (SQLException e) {
        try {
            if (conexion != null) {
                conexion.rollback(); // Asegurarse de revertir cualquier cambio
            }
        } catch (SQLException rollbackEx) {
            System.err.println("Error al realizar rollback: " + rollbackEx.getMessage());
        }
        System.err.println("Error en la operación de eliminación: " + e.getMessage());
        return "Error en la operación de eliminación: " + e.getMessage();
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
