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

    // Método para agregar un nuevo inmueble
    public boolean agregarInmueble(int matricula, int numeroInmueble, long valorInmueble, Date fechaEscritura, int area, int idTorre, String tipoInmueble) {
        return inmuebleDAO.insertarInmueble(matricula, numeroInmueble, valorInmueble, fechaEscritura, area, idTorre, tipoInmueble);
    }

  
    // Método para actualizar un inmueble
    public boolean actualizarInmueble(Inmueble inmueble) {
        return inmuebleDAO.actualizarInmueble(inmueble);
    }

    // Método para eliminar un inmueble por matrícula
    public boolean eliminarInmueble(int matricula) {
        return inmuebleDAO.eliminarInmueble(matricula);
    }
    
   public Inmueble obtenerInmueblePorMatricula(int matricula) {
       
    return inmuebleDAO.obtenerInmueblePorMatricula(matricula);
}

}
