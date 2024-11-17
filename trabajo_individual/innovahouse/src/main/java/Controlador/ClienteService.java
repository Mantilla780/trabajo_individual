/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
    
import Modelo.Cliente;
import Modelo.ClienteDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author omaci
 */
public class ClienteService {

    private ClienteDAO clienteDAO;

    public ClienteService(Connection conexion) {
        this.clienteDAO = new ClienteDAO(conexion);
    }

    public boolean agregarCliente(Cliente cliente) {
        return clienteDAO.insertarCliente(cliente);
    }
    
    public List<Cliente> obtenerclientes() throws SQLException {
        return clienteDAO.listarClientes();
    }
    
    public boolean actualizarCliente(Cliente cliente) {
    // Llamamos al método del ClienteDAO para actualizar los datos del cliente en la base de datos
    return clienteDAO.actualizarCliente(cliente);
}

    public String eliminarCliente(int cedula) {
        return clienteDAO.eliminarCliente(cedula);
    }
}

