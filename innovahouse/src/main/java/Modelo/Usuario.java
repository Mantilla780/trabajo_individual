package Modelo;

public class Usuario {
    private String idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private String telefonoUsuario; // Usar String para números de teléfono
    private String correoUsuario;
    private String tipoUsuario;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los campos
    public Usuario(String idUsuario, String nombreUsuario, String contrasena, String telefonoUsuario, String correoUsuario, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.telefonoUsuario = telefonoUsuario;
        this.correoUsuario = correoUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
