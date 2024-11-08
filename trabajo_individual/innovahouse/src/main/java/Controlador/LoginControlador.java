package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;

public class LoginControlador {
    private final UsuarioDAO usuarioDAO;

    public LoginControlador() {
        usuarioDAO = new UsuarioDAO();
    }

    public String autenticar(String nombreUsuario, String contraseña) {
        return usuarioDAO.autenticarUsuario(nombreUsuario, contraseña);  // Ahora retorna el ID
    }
}
