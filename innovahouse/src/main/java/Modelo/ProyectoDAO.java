package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {
    private final Connection conexion;

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
            proyecto.setIdproyecto(rs.getString("IDPROYECTO"));
            proyecto.setNombreproyecto(rs.getString("NOMBREPROYECTO"));
            proyecto.setNumerotorres(rs.getInt("NUMEROTORRES"));
            proyecto.setIdusuario(rs.getString("IDUSUARIO"));
            proyectos.add(proyecto);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return proyectos;
}
    
}


