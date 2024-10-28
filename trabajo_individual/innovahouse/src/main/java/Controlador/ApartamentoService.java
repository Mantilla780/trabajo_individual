package Controlador;

import Modelo.Apartamento;
import Modelo.ApartamentoDAO;
import java.sql.Date;
import java.util.List;

public class ApartamentoService {
    private ApartamentoDAO apartamentoDAO;

    public ApartamentoService(ApartamentoDAO apartamentoDAO) {
        this.apartamentoDAO = apartamentoDAO;
    }

    public boolean agregarApartamento(int matricula, String numeroApartamento, int valorApartamento, Date fechaEscritura, int area, String numeroTorre, String tipoUnidad) {
        return apartamentoDAO.insertarApartamento(matricula, numeroApartamento, valorApartamento, fechaEscritura, area, numeroTorre, tipoUnidad);
    }

    public List<Apartamento> listarApartamentosPorTorre(String numeroTorre) {
        return apartamentoDAO.obtenerApartamentosPorTorre(numeroTorre);
    }

    public boolean actualizarApartamento(Apartamento apartamento) {
        return apartamentoDAO.actualizarApartamento(apartamento);
    }

    public boolean eliminarApartamento(int matricula) {
        return apartamentoDAO.eliminarApartamento(matricula);
    }
}
