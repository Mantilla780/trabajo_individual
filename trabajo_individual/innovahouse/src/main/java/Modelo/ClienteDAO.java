package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertarCliente(Cliente cliente) {
    // Primero, verifica si el cliente ya existe
    if (clienteExiste(cliente.getCedula())) {
        System.out.println("Ya existe un cliente con la cédula: " + cliente.getCedula());
        return false; // No inserta si ya existe
    }

    String sqlInsert = "INSERT INTO proyecto.cliente (cedula, nombre, sisben, SUBSIDIOMINISTERIO, direccion, telefono, correoelectronico) VALUES (?, ?, ?, ?, ?, ?, ?)";
    //String sqlInsert = "INSERT INTO IntegradorInnovahouse.cliente (cedula, nombre, sisben, SUBSIDIOMINISTERIO, direccion, telefono, correoelectronico) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
        // Setea los valores en el PreparedStatement
        psInsert.setInt(1, cliente.getCedula());
        psInsert.setString(2, cliente.getNombre());

        // Si sisben es vacío, lo dejamos como NULL
        if (cliente.getSisben().isEmpty()) {
            psInsert.setNull(3, java.sql.Types.VARCHAR); // 'sisben' es de tipo String
        } else {
            psInsert.setString(3, cliente.getSisben());
        }

        // Si subsidio (sussidioministerio) es 0 o no se ha proporcionado, lo dejamos como NULL
        if (cliente.getSUBSIDIOMINISTERIO()== 0) {
            psInsert.setNull(4, java.sql.Types.INTEGER); // 'sussidioministerio' es de tipo INT
        } else {
            psInsert.setInt(4, cliente.getSUBSIDIOMINISTERIO());
        }

        psInsert.setString(5, cliente.getDireccion());
        psInsert.setInt(6, cliente.getTelefono());
        psInsert.setString(7, cliente.getCorreoelectronico());

        // Ejecuta la inserción
        return psInsert.executeUpdate() > 0;

    } catch (SQLException e) {
        System.err.println("Error al insertar cliente: " + e.getMessage());
        return false;
    }
}

private boolean clienteExiste(int cedula) {
    String sqlSelect = "SELECT COUNT(*) FROM proyecto.cliente WHERE cedula = ?";
    //String sqlSelect = "SELECT COUNT(*) FROM IntegradorInnovahouse.cliente WHERE cedula = ?";
    try (PreparedStatement psSelect = conexion.prepareStatement(sqlSelect)) {
        psSelect.setInt(1, cedula);
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Si hay al menos un cliente con esa cédula, devuelve true
        }
    } catch (SQLException e) {
        System.err.println("Error al verificar si el cliente existe: " + e.getMessage());
    }
    return false;
}

 public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        
         String sql = "SELECT cedula, nombre, sisben, subsidioMinisterio, direccion, telefono, correoelectronico FROM proyecto.cliente";
         //String sql = "SELECT cedula, nombre, sisben, subsidioMinisterio, direccion, telefono, correoelectronico FROM IntegradorInnovahouse.cliente";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getString("sisben"),
                        rs.getInt("subsidioMinisterio"),
                        rs.getString("direccion"),
                        rs.getInt("telefono"),
                        rs.getString("correoelectronico")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }
    public boolean actualizarCliente(Cliente cliente) {
        String sqlUpdate = "UPDATE proyecto.CLIENTE SET NOMBRE = ?, SISBEN = ?, SUBSIDIOMINISTERIO = ?, DIRECCION = ?, TELEFONO = ?, CORREOELECTRONICO = ? WHERE CEDULA = ?";

        try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {
            // Asignar los valores al PreparedStatement
            psUpdate.setString(1, cliente.getNombre());
            psUpdate.setString(2, cliente.getSisben());

            // Manejar el caso de SUBSIDIOMINISTERIO
            if (cliente.getSUBSIDIOMINISTERIO() == 0 ) {
                psUpdate.setNull(3, java.sql.Types.INTEGER); // Si es 0, guardamos como NULL
            } else {
                psUpdate.setInt(3, cliente.getSUBSIDIOMINISTERIO());
            }

            psUpdate.setString(4, cliente.getDireccion());
            psUpdate.setInt(5, cliente.getTelefono());
            psUpdate.setString(6, cliente.getCorreoelectronico());
            psUpdate.setInt(7, cliente.getCedula());

            // Ejecutar la consulta y verificar si se actualizó alguna fila
            return psUpdate.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public String eliminarCliente(int cedula) {
        if (clienteTieneVentas(cedula)) {
            return "No se puede eliminar el cliente con cédula " + cedula + " porque tiene ventas registradas.";
        }

        String sqlDelete = "DELETE FROM proyecto.cliente WHERE cedula = ?";

        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, cedula);

            if (psDelete.executeUpdate() > 0) {
                return "Cliente eliminado con éxito.";
            } else {
                return "No se encontró el cliente con cédula " + cedula + ".";
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente con cédula " + cedula + ": " + e.getMessage());
            return "Error al eliminar el cliente. Inténtalo nuevamente.";
        }
    }

    // Método para verificar si un cliente tiene ventas registradas
    private boolean clienteTieneVentas(int cedula) {
        String sqlCheckVentas = "SELECT COUNT(*) FROM proyecto.venta WHERE cccliente = ?";
        // String sqlCheckVentas = "SELECT COUNT(*) FROM IntegradorInnovahouse.venta WHERE cccliente = ?";

        try (PreparedStatement psCheckVentas = conexion.prepareStatement(sqlCheckVentas)) {
            psCheckVentas.setInt(1, cedula);
            ResultSet rs = psCheckVentas.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Si hay al menos una venta, devuelve true
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar ventas del cliente con cédula " + cedula + ": " + e.getMessage());
        }
        return false;
    }

}