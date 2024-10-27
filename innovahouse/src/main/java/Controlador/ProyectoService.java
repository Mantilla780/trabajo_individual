package Controlador;

import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import java.util.List;

public class ProyectoService {
    private ProyectoDAO proyectoDAO;

    public ProyectoService(ProyectoDAO proyectoDAO) {
        this.proyectoDAO = proyectoDAO;
    }

    public boolean agregarProyecto(String nombreProyecto, int numeroTorres, String idUsuario) {
        return proyectoDAO.insertarProyecto(nombreProyecto, numeroTorres, idUsuario);
    }
    
    public List<Proyecto> listarProyectos() {
        return proyectoDAO.obtenerProyectos();
}
}
