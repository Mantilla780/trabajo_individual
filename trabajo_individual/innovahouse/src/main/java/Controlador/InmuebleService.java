package Controlador;

import Modelo.Inmueble;
import Modelo.InmuebleDAO;
import java.sql.Date;
import java.util.List;

public class InmuebleService {
    private InmuebleDAO inmuebleDAO;

    public InmuebleService(InmuebleDAO inmuebleDAO) {
        this.inmuebleDAO = inmuebleDAO;
    }

    public boolean agregarInmueble(int matricula, String numeroInmueble, int valorInmueble, Date fechaEscritura, int area, int idTorre, String tipoUnidad) {
        // Llama al método insertarInmueble con idTorre en lugar de numeroTorre
        return inmuebleDAO.insertarInmueble(matricula, numeroInmueble, valorInmueble, fechaEscritura, area, idTorre, tipoUnidad);
    }

    public List<Inmueble> listarInmueblePorTorre(int idTorre) {
        // Llama al método obtenerInmueblesPorTorre con idTorre en lugar de numeroTorre
        return inmuebleDAO.obtenerInmueblesPorTorre(idTorre);
    }

    public boolean actualizarInmueble(Inmueble inmueble) {
        return inmuebleDAO.actualizarInmueble(inmueble);
    }

    public boolean eliminarInmueble(int matricula) {
        return inmuebleDAO.eliminarInmueble(matricula);
    }
}
