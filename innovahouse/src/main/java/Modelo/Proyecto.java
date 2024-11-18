package Modelo;

public class Proyecto {
    private int idproyecto;
    private String nombreProyecto;
    private int numeroTorres;
    private String idUsuario;

    public Proyecto() {
    }

    public Proyecto(int idproyecto, String nombreProyecto, String idUsuario) {
        this.idproyecto = idproyecto;
        this.nombreProyecto = nombreProyecto;
        this.idUsuario = idUsuario;
        this.numeroTorres = 0; // Inicializar correctamente
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }   
    
    public int getNumeroTorres() {
        return numeroTorres;
    }

    public void setNumeroTorres(int numeroTorres) {
        this.numeroTorres = numeroTorres;
    }
}
