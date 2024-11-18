package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private final ConexionBD conexionBD;

    public UsuarioDAO() {
        conexionBD = ConexionBD.getInstancia();
    }

   public String[] autenticarUsuario(String nombreUsuario, String contraseña) {
    String sql = "SELECT idUsuario, tipoUsuario FROM proyecto.Usuario WHERE CORREOUSUARIO = ? AND contrasena = ?";
    //String sql = "SELECT idUsuario, tipoUsuario FROM IntegradorInnovahouse.Usuario WHERE CORREOUSUARIO = ? AND contrasena = ?";
    try (Connection con = conexionBD.getConnection("Admin"); // Establecer conexión de tipo "Admin"
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, nombreUsuario);
        stmt.setString(2, contraseña);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            // Aquí se obtiene el tipo de usuario y se lo pasa a la conexión
            String idUsuario = rs.getString("idUsuario");
            String rol = rs.getString("tipoUsuario"); // Ahora se obtiene el rol directamente

            return new String[] { idUsuario, rol };  // Regresar el idUsuario y rol del tipoUsuario
        }
    } catch (SQLException e) {
        System.out.println("Error al autenticar el usuario: " + e.getMessage());
    }
    return null; // Usuario o contraseña incorrectos
}

}


