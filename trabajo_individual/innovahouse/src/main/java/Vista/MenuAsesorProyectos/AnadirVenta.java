/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.MenuAsesorProyectos;

import Controlador.ClienteService;
import Controlador.ConexionBD;
import Controlador.InmuebleService;
import Controlador.VentaService;
import Modelo.Cliente;
import Modelo.Inmueble;
import Modelo.InmuebleDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author omaci
 */
public class AnadirVenta extends javax.swing.JFrame {
 
    private HashMap<String, Integer> clienteMap = new HashMap<>();
    private HashMap<String, Integer> inmuebleMap = new HashMap<>();

    private ClienteService clienteService;
    private VentaService ventaService; // Agregamos VentaService para manejar ventas
    private String idUsuario; // Atributo para almacenar el idUsuario

    /**
     * Constructor que recibe el idUsuario.
     *
     * @param idUsuario
     */
    public AnadirVenta(String idUsuario) {
        initComponents();
        setLocationRelativeTo(null);
        this.idUsuario = idUsuario; // Asignación del idUsuario
        System.out.println(idUsuario);

        ConexionBD conexionBD = new ConexionBD();

        // Inicialización de servicios
        Connection connectionAsesor = conexionBD.getConnection("Asesor");

        this.clienteService = new ClienteService(connectionAsesor);
        this.ventaService = new VentaService(connectionAsesor); // Inicialización del servicio de ventas usando conexión directamente

        llenarComboBoxClientes();
        llenarComboBoxInmueble(); // Llamada para llenar el ComboBox
    }
    
    
    // Método llenarComboBoxClientes en AnadirVenta
    private void llenarComboBoxClientes() {
            try {
                List<Cliente> clientes = clienteService.obtenerclientes(); // Obtiene la lista de clientes correctamente
                jComboBox2.removeAllItems(); // Limpiar el ComboBox antes de llenarlo

                for (Cliente cliente : clientes) {
                    jComboBox2.addItem(cliente.getNombre()); // Agrega el nombre al ComboBox
                    clienteMap.put(cliente.getNombre(), cliente.getCedula()); // Relaciona nombre con cédula
                }
            } catch (SQLException e) {
                e.printStackTrace(); // O maneja la excepción de otra forma
            }
        }

        // Método llenarComboBoxInmueble
         private void llenarComboBoxInmueble() {
        try {
            // Obtener la conexión desde ConexionBD
            Connection conexion = ConexionBD.getInstancia().getConnection("Admin"); // Ajusta el rol según corresponda
            InmuebleDAO inmuebleDAO = new InmuebleDAO(conexion);
            InmuebleService inmuebleService = new InmuebleService(inmuebleDAO);

            List<Inmueble> inmuebles = inmuebleService.obtenerInmuebles(); // Método que obtiene todos los inmuebles
            jComboBox3.removeAllItems(); // Limpiar el ComboBox antes de llenarlo

            for (Inmueble inmueble : inmuebles) {
                String matriculaStr = String.valueOf(inmueble.getMatricula()); // Convertir la matrícula a String
                jComboBox3.addItem(matriculaStr); // Agregar la matrícula al ComboBox
                inmuebleMap.put(matriculaStr, inmueble.getMatricula()); // Guardar en el mapa para referencia rápida
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de la excepción
        }
    }






    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSButtonMetro1 = new Vista.RSButtonMetro();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreproyecto3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nombreproyecto5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(710, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(710, 440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Nueva Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        rSButtonMetro1.setBackground(new java.awt.Color(0, 191, 99));
        rSButtonMetro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/save.png"))); // NOI18N
        rSButtonMetro1.setText("Guardar");
        rSButtonMetro1.setColorHover(new java.awt.Color(8, 136, 74));
        rSButtonMetro1.setColorNormal(new java.awt.Color(0, 191, 99));
        rSButtonMetro1.setColorPressed(new java.awt.Color(8, 136, 74));
        rSButtonMetro1.setContentAreaFilled(true);
        rSButtonMetro1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 200, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Matricula inmueble");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Numero Cuotas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        jPanel1.add(nombreproyecto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 380, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("Nombre Cliente");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setText("Interes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));
        jPanel1.add(nombreproyecto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 380, 50));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 380, 50));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 380, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 900, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        String nombreCliente = (String) jComboBox2.getSelectedItem();
        String matriculaInmuebleStr = (String) jComboBox3.getSelectedItem();
        String numeroCuotasStr = nombreproyecto3.getText();
        String interes = nombreproyecto5.getText();

        if (nombreCliente == null || matriculaInmuebleStr == null || numeroCuotasStr.isEmpty() || interes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int numeroCuotas = Integer.parseInt(numeroCuotasStr);
            int matriculaInmueble = inmuebleMap.get(matriculaInmuebleStr);
            int cedulaCliente = clienteMap.get(nombreCliente);

            Venta nuevaVenta = new Venta();
            nuevaVenta.setNumerocuotas(numeroCuotas);
            nuevaVenta.setIntereses(interes);
            nuevaVenta.setCccliente(cedulaCliente);
            nuevaVenta.setMatinmueble(matriculaInmueble);
            nuevaVenta.setIdusuario(idUsuario); // Se utiliza idUsuario

            if (guardarVenta(nuevaVenta)) {
                JOptionPane.showMessageDialog(this, "Venta guardada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número de cuotas debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    // Método para guardar la venta en la base de datos
    private boolean guardarVenta(Venta venta) {
        try {
            return ventaService.agregarVenta(venta);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }  
    }
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String clienteSeleccionado = (String) jComboBox2.getSelectedItem();
        if (clienteSeleccionado != null && clienteMap.containsKey(clienteSeleccionado)) {
            int cedulaCliente = clienteMap.get(clienteSeleccionado);
            // Aquí puedes usar la cédula para otros procesos (como guardar en la base de datos)
            System.out.println("Cédula del cliente seleccionado: " + cedulaCliente);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String inmuebleSeleccionado = (String) jComboBox3.getSelectedItem();
        if (inmuebleSeleccionado != null && inmuebleMap.containsKey(inmuebleSeleccionado)) {
            Integer matriculaInmueble = inmuebleMap.get(inmuebleSeleccionado);
            // Ahora tienes la matrícula del inmueble, la cual puedes usar para guardarla
            System.out.println("Matrícula del inmueble seleccionado: " + matriculaInmueble);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnadirVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AnadirCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreproyecto3;
    private javax.swing.JTextField nombreproyecto5;
    private Vista.RSButtonMetro rSButtonMetro1;
    // End of variables declaration//GEN-END:variables
}
