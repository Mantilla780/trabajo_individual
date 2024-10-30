package Controlador;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection con = null;
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "proyecto";
    private String password = "proyecto";

    public ConexionBD() {
        conectar();
    }

    // Método para conectar a la base de datos
    public void conectar() {
        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Base de datos conectada: " + meta.getDriverName());
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConnection() {
        try {
            // Si la conexión está cerrada, vuelve a abrirla
            if (con == null || con.isClosed()) {
                conectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
