package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Proyecto;

import Controlador.ConexionBD;

public class ProyectoDAO {
    private Connection conexion;

    public ProyectoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo proyecto
    public boolean insertarProyecto(String nombreProyecto, int numeroTorres, String idUsuario) {
        String sqlSequence = "SELECT proyectovivienda_seq.NEXTVAL FROM dual";
        String sqlInsert = "INSERT INTO PROYECTOVIVIENDA (IDPROYECTO, NOMBREPROYECTO, NUMEROTORRES, IDUSUARIO) VALUES (?, ?, ?, ?)";
        
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
            psInsert.setInt(3, numeroTorres);
            psInsert.setString(4, idUsuario);

            return psInsert.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener la lista de proyectos
    public List<Proyecto> obtenerProyectos() {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT IDPROYECTO, NOMBREPROYECTO, NUMEROTORRES, IDUSUARIO FROM PROYECTOVIVIENDA";

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
            e.printStackTrace();
        }
        return proyectos;
    }

    // Método para actualizar un proyecto
   public boolean actualizarProyecto(Proyecto proyecto) {
    String sqlUpdate = "UPDATE PROYECTOVIVIENDA SET NOMBREPROYECTO = ?, NUMEROTORRES = ?, IDUSUARIO = ? WHERE IDPROYECTO = ?";

    try {
        // Verificar si la conexión está cerrada y crear una nueva si es necesario
        if (conexion == null || conexion.isClosed()) {
            conexion = ConexionBD.getInstancia().getConnection(); // Asegúrate de que este método existe y devuelve una nueva conexión
        }

        try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, proyecto.getNombreProyecto());
            psUpdate.setInt(2, proyecto.getNumeroTorres());
            psUpdate.setString(3, proyecto.getIdUsuario());
            psUpdate.setInt(4, proyecto.getIdproyecto());

            return psUpdate.executeUpdate() > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


    // Método para eliminar un proyecto por ID
    public boolean eliminarProyecto(int idProyecto) {
        String sqlDelete = "DELETE FROM PROYECTOVIVIENDA WHERE IDPROYECTO = ?";
ConexionBD con = new ConexionBD();


        try (PreparedStatement psDelete = con.getConnection().prepareStatement(sqlDelete)) {
            psDelete.setInt(1, idProyecto);
            return psDelete.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
