package Controlador;

import Modelo.Inmueble;
import Modelo.InmuebleDAO;
import java.sql.Date;
import java.util.List;

public class InmuebleService {
    private InmuebleDAO apartamentoDAO;

    public InmuebleService(InmuebleDAO apartamentoDAO) {
        this.apartamentoDAO = apartamentoDAO;
    }

    public boolean agregarInmueble(int matricula, String numeroApartamento, int valorApartamento, Date fechaEscritura, int area, String numeroTorre, String tipoUnidad) {
        return apartamentoDAO.insertarApartamento(matricula, numeroApartamento, valorApartamento, fechaEscritura, area, numeroTorre, tipoUnidad);
    }

    public List<Inmueble> listarInmueblePorTorre(String numeroTorre) {
        return apartamentoDAO.obtenerApartamentosPorTorre(numeroTorre);
    }

    public boolean actualizarInmueble(Inmueble apartamento) {
        return apartamentoDAO.actualizarApartamento(apartamento);
    }

    public boolean eliminarInmueble(int matricula) {
        return apartamentoDAO.eliminarApartamento(matricula);
    }
}
