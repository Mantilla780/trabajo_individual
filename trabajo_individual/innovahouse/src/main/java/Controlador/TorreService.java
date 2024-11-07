package Controlador;

import Modelo.Torre;
import Modelo.TorreDAO;
import java.util.List;

public class TorreService {
    private TorreDAO torreDAO;

    public TorreService(TorreDAO torreDAO) {
        this.torreDAO = torreDAO;
    }

    // Método para agregar una torre
    public boolean insertarTorre(int numeroTorre, int idProyecto) {
        return torreDAO.insertarTorre(numeroTorre, idProyecto);
    }


    // Método para listar todas las torres con la cantidad de inmuebles
    public List<Torre> listarTorresConCantidadInmuebles() {
        return torreDAO.obtenerTorresConCantidadInmuebles();
    }
    
    public List<Torre> obtenerTorresBasicas() {
    return torreDAO.obtenerTorresBasicas();
}
}
