package Controlador;

import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import java.util.List;

public class ProyectoService {
    private final ProyectoDAO proyectoDAO;

    public ProyectoService(ProyectoDAO proyectoDAO) {
        this.proyectoDAO = proyectoDAO;
    }

    public boolean agregarProyecto(String nombreProyecto, int numeroTorres, String idUsuario) {
        return proyectoDAO.insertarProyecto(nombreProyecto, numeroTorres, idUsuario);
    }

    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoDAO.obtenerProyectos();
    }

    public boolean actualizarProyecto(int idProyecto, String nombreProyecto, int numeroTorres) {
        return proyectoDAO.actualizarProyecto(idProyecto, nombreProyecto, numeroTorres);
    }

    public boolean eliminarProyecto(int idProyecto) {
        return proyectoDAO.eliminarProyecto(idProyecto);
    }
}
