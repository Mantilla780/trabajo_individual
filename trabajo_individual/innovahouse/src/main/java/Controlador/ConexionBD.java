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
    private String user = "adminproyecto";
    private String password = "adminproyecto";

    public ConexionBD() {
        conectar();
    }

    private void conectar() {
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

    // Verifica si la conexión está activa o intenta restablecerla si está cerrada
    public Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                System.out.println("La conexión estaba cerrada. Intentando reconectar...");
                conectar();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
