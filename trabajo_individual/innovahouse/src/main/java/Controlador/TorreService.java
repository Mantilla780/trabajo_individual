package Controlador;

import Modelo.Torre;
import Modelo.TorreDAO;
import java.util.List;

public class TorreService {
    private TorreDAO torreDAO;

    public TorreService(TorreDAO torreDAO) {
        this.torreDAO = torreDAO;
    }

    public boolean agregarTorre(int numeroTorre, int numeroApartamento, int idProyecto) {
        return torreDAO.insertarTorre(numeroTorre, numeroApartamento, idProyecto);
    }

    public List<Torre> listarTorresPorProyecto(String idProyecto) {
        return torreDAO.obtenerTorresPorProyecto(idProyecto);
    }
}
