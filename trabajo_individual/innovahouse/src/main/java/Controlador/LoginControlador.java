package Controlador;

import Modelo.ConexionBD;
import Modelo.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginControlador {
    
    private final UsuarioDAO usuarioDAO;
    
    public LoginControlador() {
        usuarioDAO = new UsuarioDAO();
    }
    
     public String[] autenticar(String nombreUsuario, String contraseña) {
        String[] resultado = usuarioDAO.autenticarUsuario(nombreUsuario, contraseña);
        if (resultado != null) {
            String idUsuario = resultado[0];
            String rol = resultado[1];

            ConexionBD conexion = ConexionBD.getInstancia();
            Connection con = conexion.getConnection(rol); // Se usa el rol del usuario para obtener la conexión

            if (con != null) {
                System.out.println("Conexión establecida con éxito para el rol: " + rol);
                return new String[] { idUsuario, rol };  // Retornar idUsuario y rol
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener una conexión válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
        }

        return null; // Login fallido
    }

}
