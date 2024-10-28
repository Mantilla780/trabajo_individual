/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ConexionBD;
import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author omaci
 */
public class EditarProyecto extends javax.swing.JFrame {
private int idProyecto;  // ID del proyecto a editar
    
    public EditarProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
        initComponents();
        cargarDatosProyecto(); // Carga los datos del proyecto al iniciar la ventana
    }

    private EditarProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
      private void cargarDatosProyecto() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection()) {
            ProyectoDAO proyectoDAO = new ProyectoDAO(conexion);
            Proyecto proyecto = proyectoDAO.obtenerProyectoPorId(idProyecto);
            System.out.println(proyecto.getNombreProyecto());

            if (proyecto != null) {
                jTextField1.setText(proyecto.getNombreProyecto());
                jTextField2.setText(String.valueOf(proyecto.getNumeroTorres()));
                
            } else {
                JOptionPane.showMessageDialog(this, "El proyecto no existe.");
                this.dispose(); // Cierra la ventana si el proyecto no se encuentra
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos del proyecto: " + e.getMessage());
        }
    }

   private void guardarCambios() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection()) {
            ProyectoDAO proyectoDAO = new ProyectoDAO(conexion);
            Proyecto proyecto = new Proyecto();
            proyecto.setIdproyecto(idProyecto); // Usar idProyecto como String
            proyecto.setNombreProyecto(jTextField1.getText());
            proyecto.setNumeroTorres(Integer.parseInt(jTextField2.getText()));

            boolean actualizado = proyectoDAO.actualizarProyecto(idProyecto, proyecto.getNombreProyecto(), proyecto.getNumeroTorres());
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Proyecto actualizado correctamente.");
                dispose(); // Cierra la ventana de edición
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el proyecto.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
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

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 32, -1, -1));

        jTextField2.setText("jTextField2");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 126, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardarCambios();
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
            java.util.logging.Logger.getLogger(EditarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
