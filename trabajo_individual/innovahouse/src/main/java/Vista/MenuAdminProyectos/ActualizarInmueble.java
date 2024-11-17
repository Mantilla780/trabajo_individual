/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.MenuAdminProyectos;

import Modelo.ConexionBD;
import Controlador.ProyectoService;
import Modelo.Inmueble;
import Modelo.InmuebleDAO;
import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import Modelo.Torre;
import Modelo.TorreDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class ActualizarInmueble extends javax.swing.JFrame {
    private int numeroInmueble;
    private int idProyecto;
    private ProyectoService proyectoService;
    private HashMap<String, Integer> proyectoMap = new HashMap<>();
        // Mapa para almacenar el nombre de la torre y su ID
    private HashMap<String, Integer> torreMap = new HashMap<>();

    // Mapa para almacenar el tipo de inmueble
    private HashMap<String, String> tipoMap = new HashMap<>();

    public ActualizarInmueble(int numeroInmueble) {
        initComponents();
        
        // Cargar la imagen como icono de la ventana
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Imagenes/logo3.png"));
        setIconImage(icono);
        
        this.numeroInmueble = numeroInmueble;
        this.idProyecto = idProyecto;
        cargarDatosInmueble();
        
    }

    private void cargarDatosInmueble() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection("Admin")) {
            InmuebleDAO inmuebleDAO = new InmuebleDAO(conexion);
            Inmueble inmueble = inmuebleDAO.obtenerInmueblePorMatricula(this.numeroInmueble);

            if (inmueble != null) {
                jtnumeroinmueble.setText(String.valueOf(inmueble.getNumeroInmueble()));
                jtarea.setText(String.valueOf(inmueble.getArea()));
                jtvalor.setText(String.valueOf(inmueble.getValorInmueble()));

                llenarComboBoxTipo();
                llenarComboBoxTorre();

                jctipo.setSelectedItem(inmueble.getTipoInmueble());
                for (String nombreTorre : torreMap.keySet()) {
                    if (torreMap.get(nombreTorre).equals(inmueble.getIdTorre())) {
                        jctorre.setSelectedItem(nombreTorre);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos del inmueble.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboBoxTipo() {
        jctipo.removeAllItems();
        tipoMap.clear();

        String[] tipos = {"Residencial", "Comercial", "Industrial"};
        for (String tipo : tipos) {
            jctipo.addItem(tipo);
            tipoMap.put(tipo, tipo);
        }
    }
    
        private void llenarComboBoxTorre() {
    try (Connection conexion = ConexionBD.getInstancia().getConnection("Admin")) {
        TorreDAO torreDAO = new TorreDAO(conexion);
        List<Torre> torres = torreDAO.obtenerTorresBasicas();
        jctorre.removeAllItems();
        torreMap.clear();

        for (Torre torre : torres) {
            String numeroTorre = String.valueOf(torre.getNumerotorre());
            jctorre.addItem(numeroTorre); // Mostramos numerotorre en lugar de nombreTorre
            torreMap.put(numeroTorre, torre.getIdtorre());
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar las torres.", "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtvalor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtnumeroinmueble = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtarea = new javax.swing.JTextField();
        jctipo = new javax.swing.JComboBox<>();
        jctorre = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(710, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(710, 440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Nuevo Inmueble");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Torre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Valor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jtvalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtvalorActionPerformed(evt);
            }
        });
        jPanel1.add(jtvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 290, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Numero Inmueble");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, -1));
        jPanel1.add(jtnumeroinmueble, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Area (m2)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));
        jPanel1.add(jtarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 100, 40));

        jctipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Apartemento", "Garaje", "Local" }));
        jctipo.setBorder(null);
        jctipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jctipoActionPerformed(evt);
            }
        });
        jPanel1.add(jctipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 100, 50));

        jctorre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jctorre.setBorder(null);
        jctorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jctorreActionPerformed(evt);
            }
        });
        jPanel1.add(jctorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 100, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Tipo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jButton1.setBackground(new java.awt.Color(1, 60, 136));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/actualizar.png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 379, 200, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jctipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jctipoActionPerformed
      
    }//GEN-LAST:event_jctipoActionPerformed

    private void jctorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jctorreActionPerformed
        
    }//GEN-LAST:event_jctorreActionPerformed

    private void jtvalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtvalorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtvalorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int numeroInmueble = Integer.parseInt(jtnumeroinmueble.getText());
            double area = Double.parseDouble(jtarea.getText());
            double valor = Double.parseDouble(jtvalor.getText());
            String tipo = (String) jctipo.getSelectedItem();
            Integer idTorreSeleccionada = torreMap.get(jctorre.getSelectedItem());

            InmuebleDAO inmuebleDAO = new InmuebleDAO(ConexionBD.getInstancia().getConnection("Admin"));
            Inmueble inmueble = inmuebleDAO.obtenerInmueblePorMatricula(this.numeroInmueble);

            if (inmueble != null) {
                inmueble.setNumeroInmueble(numeroInmueble);
                inmueble.setArea((int) area);
                inmueble.setValorInmueble((long) valor);
                inmueble.setTipoInmueble(tipo);
                inmueble.setIdTorre(idTorreSeleccionada);

                if (inmuebleDAO.actualizarInmueble(inmueble)) {
                    JOptionPane.showMessageDialog(this, "Inmueble actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el inmueble.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el inmueble: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarInmueble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarInmueble(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jctipo;
    private javax.swing.JComboBox<String> jctorre;
    private javax.swing.JTextField jtarea;
    private javax.swing.JTextField jtnumeroinmueble;
    private javax.swing.JTextField jtvalor;
    // End of variables declaration//GEN-END:variables
}
