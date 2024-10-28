package Controlador;

import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import java.util.List;

public class ProyectoService {
    private ProyectoDAO proyectoDAO;

    public ProyectoService(ProyectoDAO proyectoDAO) {
        this.proyectoDAO = proyectoDAO;
    }

    // Método para agregar un nuevo proyecto
    public boolean agregarProyecto(String nombreProyecto, int numeroTorres, String idUsuario) {
        return proyectoDAO.insertarProyecto(nombreProyecto, numeroTorres, idUsuario);
    }

    // Método para listar todos los proyectos
    public List<Proyecto> listarProyectos() {
        return proyectoDAO.obtenerProyectos();
    }

    // Método para actualizar un proyecto
    public boolean actualizarProyecto(Proyecto proyecto) {
        return proyectoDAO.actualizarProyecto(proyecto);
    }

    // Método para eliminar un proyecto por su ID
    public boolean eliminarProyecto(String idProyecto) {
        return proyectoDAO.eliminarProyecto(idProyecto);
    }
}
