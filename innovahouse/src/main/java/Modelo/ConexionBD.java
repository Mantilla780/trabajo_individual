package Modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection adminConnection = null;
    private Connection asesorConnection = null;

    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    // private final String url = "jdbc:oracle:thin:@192.168.254.215:1521:orcl";

    private final String adminUser = "adminproyecto";
    private final String adminPassword = "adminproyecto";
    private final String asesorUser = "asesorproyecto";
    private final String asesorPassword = "asesorproyecto";

    public ConexionBD() {
        conectarAdmin();
        conectarAsesor();
    }

    // Conexión para administradores
    private void conectarAdmin() {
        try {
            adminConnection = DriverManager.getConnection(url, adminUser, adminPassword);
            if (adminConnection != null) {
                DatabaseMetaData meta = adminConnection.getMetaData();
                System.out.println("Conexión de administrador establecida: " + meta.getDriverName());
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión para administrador: " + ex.getMessage());
        }
    }

    // Conexión para asesores
    private void conectarAsesor() {
        try {
            asesorConnection = DriverManager.getConnection(url, asesorUser, asesorPassword);
            if (asesorConnection != null) {
                DatabaseMetaData meta = asesorConnection.getMetaData();
                System.out.println("Conexión de asesor establecida: " + meta.getDriverName());
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión para asesor: " + ex.getMessage());
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

   
    public Connection getConnection(String role) {
    try {
        if ("Admin".equalsIgnoreCase(role)) {
            if (adminConnection == null || adminConnection.isClosed()) {
                System.out.println("Conexión de administrador cerrada o no establecida. Intentando reconectar...");
                conectarAdmin();
            }
            if (adminConnection != null) {
                System.out.println("Conexión de administrador válida.");
                return adminConnection;
            }
        } else if ("Asesor".equalsIgnoreCase(role)) {
            if (asesorConnection == null || asesorConnection.isClosed()) {
                System.out.println("Conexión de asesor cerrada o no establecida. Intentando reconectar...");
                conectarAsesor();
            }
            if (asesorConnection != null) {
                System.out.println("Conexión de asesor válida.");
                return asesorConnection;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;  // Si no se pudo obtener la conexión
}



    // Cerrar ambas conexiones
    public void closeConnections() {
        try {
            if (adminConnection != null && !adminConnection.isClosed()) {
                adminConnection.close();
                System.out.println("Conexión de administrador cerrada.");
            }
            if (asesorConnection != null && !asesorConnection.isClosed()) {
                asesorConnection.close();
                System.out.println("Conexión de asesor cerrada.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
