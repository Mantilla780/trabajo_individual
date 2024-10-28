/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ConexionBD;
import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author omaci
 */
public class MenuAdministrador extends javax.swing.JFrame {
     private String idUsuario;
     
     
    /**
     * Creates new form MenuAdministrador
     * @param idUsuario
     */
    public MenuAdministrador(String  idUsuario) {
        initComponents();
        this.idUsuario= idUsuario;
        jTextField1.setText("ID de Usuario: " + idUsuario);
        
        cargarProyectosEnTabla();
        
    }
    
    
    private void cargarProyectosEnTabla() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection()) {
            ProyectoDAO proyectoDAO = new ProyectoDAO(conexion);
            List<Proyecto> proyectos = proyectoDAO.obtenerProyectos();
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID Proyecto", "Nombre", "Número Torres", "ID Usuario", "Editar", "Eliminar"}, 0);
            jTable1.setModel(model);

            for (Proyecto proyecto : proyectos) {
                model.addRow(new Object[]{
                    proyecto.getIdproyecto(),
                    proyecto.getNombreProyecto(),
                    proyecto.getNumeroTorres(),
                    proyecto.getIdUsuario(),
                    "Editar",
                    "Eliminar"
                });
            }

            // Configurar renderizadores y editores personalizados para las columnas de botones
            jTable1.getColumn("Editar").setCellRenderer(new ButtonRenderer());
            jTable1.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
            jTable1.getColumn("Editar").setCellEditor(new ButtonEditor(new JButton("Editar")));
            jTable1.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JButton("Eliminar")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Clase para renderizar el botón
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Clase para editar la celda del botón y manejar eventos
    class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JButton button) {
            this.button = button;
            button.addActionListener((ActionEvent e) -> {
                fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                int idProyecto = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                
                if (label.equals("Editar")) {
                    abrirEditarProyecto(idProyecto);
                } else if (label.equals("Eliminar")) {
                    eliminarProyecto(idProyecto);
                }
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    private void abrirEditarProyecto(int idProyecto) {
        // Abre el JFrame de edición pasando el ID del proyecto
        EditarProyecto editarFrame = new EditarProyecto(idProyecto);
        editarFrame.setVisible(true);
    }

    private void eliminarProyecto(int idProyecto) {
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar el proyecto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conexion = ConexionBD.getInstancia().getConnection()) {
                ProyectoDAO proyectoDAO = new ProyectoDAO(conexion);
                proyectoDAO.eliminarProyecto(idProyecto);
                cargarProyectosEnTabla();  // Actualiza la tabla después de eliminar
                JOptionPane.showMessageDialog(this, "Proyecto eliminado exitosamente.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el proyecto.");
                e.printStackTrace();
            }
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jToggleButton2.setText("jToggleButton2");
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jToggleButton3.setText("jToggleButton3");
        getContentPane().add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
         try {
             CrearProyecto create = new CrearProyecto(idUsuario,MenuAdministrador.this);
             create.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(MenuAdministrador.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador("default").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables
}
