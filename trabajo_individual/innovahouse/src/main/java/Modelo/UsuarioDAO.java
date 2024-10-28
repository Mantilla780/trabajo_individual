package Modelo;

import Controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private final ConexionBD conexionBD;

    public UsuarioDAO() {
        
        conexionBD = new ConexionBD();
    }

   public String autenticarUsuario(String nombreUsuario, String contraseña) {
    String sql = "SELECT idusuario FROM Usuario WHERE nombreUsuario = ? AND contrasena = ?";
    try (Connection con = conexionBD.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql)) {
         
        stmt.setString(1, nombreUsuario);
        stmt.setString(2, contraseña);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("idusuario"); // Retornar el ID del usuario
        }
    } catch (SQLException e) {
        System.out.println("Error al autenticar el usuario: " + e.getMessage());
    }
    return null; // Usuario o contraseña incorrectos
}
}
