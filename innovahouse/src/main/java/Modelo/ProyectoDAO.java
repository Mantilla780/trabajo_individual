package Modelo;

import Controlador.ConexionBD;
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
    
    
   public List<Proyecto> obtenerProyectos() {
    List<Proyecto> proyectos = new ArrayList<>();
    String sql = "SELECT IDPROYECTO, NOMBREPROYECTO, NUMEROTORRES, IDUSUARIO FROM PROYECTOVIVIENDA";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Proyecto proyecto = new Proyecto();
            proyecto.setIdproyecto(rs.getInt("IDPROYECTO"));
            proyecto.setNombreProyecto(rs.getString("NOMBREPROYECTO")); // Corrección aquí
            proyecto.setNumeroTorres(rs.getInt("NUMEROTORRES"));
            proyecto.setIdUsuario(rs.getString("IDUSUARIO"));
            proyectos.add(proyecto);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return proyectos;
}
    
  public Proyecto obtenerProyectoPorId(int idProyecto) {
    String sql = "SELECT idProyecto, nombreProyecto, numeroTorres, idUsuario FROM ProyectoVivienda WHERE idProyecto = ?";
    Proyecto proyecto = null;

    try (Connection conn = ConexionBD.getInstancia().getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, idProyecto);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                proyecto = new Proyecto();
                proyecto.setIdproyecto(rs.getInt("idProyecto"));
                proyecto.setNombreProyecto(rs.getString("nombreProyecto"));
                proyecto.setNumeroTorres(rs.getInt("numeroTorres"));
                proyecto.setIdUsuario(rs.getString("idUsuario"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return proyecto;
}




 public boolean actualizarProyecto(int idProyecto, String nombreProyecto, int numeroTorres) {
    String sqlUpdate = "UPDATE PROYECTOVIVIENDA SET NOMBREPROYECTO = ?, NUMEROTORRES = ? WHERE IDPROYECTO = ?";

    try (PreparedStatement ps = conexion.prepareStatement(sqlUpdate)) {
        ps.setString(1, nombreProyecto);
        ps.setInt(2, numeroTorres);
        ps.setInt(3, idProyecto);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean eliminarProyecto(int idProyecto) {
    String sqlDelete = "DELETE FROM PROYECTOVIVIENDA WHERE IDPROYECTO = ?";

    try (PreparedStatement ps = conexion.prepareStatement(sqlDelete)) {
        ps.setInt(1, idProyecto);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}   

    
    
    
    
}


