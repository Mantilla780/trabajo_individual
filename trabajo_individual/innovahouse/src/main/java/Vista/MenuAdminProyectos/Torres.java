/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.MenuAdminProyectos;

import Modelo.ConexionBD;
import Controlador.TorreService;
import Modelo.Torre;
import Modelo.TorreDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omaci
 */
public class Torres extends javax.swing.JPanel {
    private TorreService torreService;

    /**
     * Creates new form Proyectos
     */
    public Torres() {
        initComponents();
        this.torreService = torreService;
        cargarTorresEnTabla();
        
    
        
        
        // Configurar renderer para colorear cada columna de la tabla
        jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Aplica un color de fondo específico para cada columna
                switch (column) {
                    case 0 -> // Primera columna
                        cell.setBackground(Color.WHITE);
                    case 1 -> // Segunda columna
                        cell.setBackground(Color.WHITE);
                    case 2 -> // Tercera columna
                        cell.setBackground(Color.WHITE);
                    default -> {
                    }
                }
                
                // Cambia el color de fondo y del texto cuando la celda está seleccionada
                if (isSelected) {
                    cell.setBackground(table.getSelectionBackground());  // Color de fondo de selección
                    cell.setForeground(Color.WHITE);                     // Color de texto de selección
                } else {
                    cell.setForeground(Color.BLACK);                    // Color de texto por defecto
                }

                return cell;

            }
    });
    }
    
    private void cargarTorresEnTabla() {
    try (Connection conexion = ConexionBD.getInstancia().getConnection("Admin")) {
        TorreDAO torreDAO = new TorreDAO(conexion);
        List<Torre> torres = torreDAO.obtenerTorresConCantidadInmuebles();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.setColumnIdentifiers(new String[]{"Número Torre", "ID Proyecto", "Cantidad Inmuebles"});
        model.setRowCount(0);

        for (Torre torre : torres) {
            model.addRow(new Object[]{
                torre.getNumerotorre(),
                torre.getIdproyecto(),
                torre.getCantidadInmuebles()
            });
        }
    } catch (SQLException e) {
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

        jPanel1 = new javax.swing.JPanel();
    rButtonProyecto1 = new Vista.RSButtonMetro();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    rButtonProyecto2 = new Vista.RSButtonMetro();
    rButtonProyecto3 = new Vista.RSButtonMetro();

    setPreferredSize(new java.awt.Dimension(1190, 720));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setBackground(new java.awt.Color(202, 232, 255));
    jPanel1.setPreferredSize(new java.awt.Dimension(1190, 720));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    rButtonProyecto1.setBackground(new java.awt.Color(5, 10, 48));
    rButtonProyecto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/basura.png"))); // NOI18N
    rButtonProyecto1.setText("Eliminar");
    rButtonProyecto1.setColorNormal(new java.awt.Color(5, 10, 48));
    rButtonProyecto1.setColorPressed(new java.awt.Color(39, 33, 105));
    rButtonProyecto1.setFocusPainted(false);
    rButtonProyecto1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    rButtonProyecto1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            rButtonProyecto1MouseClicked(evt);
        }
    });
    rButtonProyecto1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rButtonProyecto1ActionPerformed(evt);
        }
    });
    jPanel1.add(rButtonProyecto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 140, 60));

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {},
            {},
            {},
            {}
        },
        new String [] {

        }
    ));
    jTable2.setSelectionBackground(new java.awt.Color(39, 33, 105));
    // Añadir un JScrollPane alrededor de la tabla
    jScrollPane2.setViewportView(jTable2);

    // Establecer la posición y tamaño para asegurar el desplazamiento
    jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1120, 520));

    rButtonProyecto2.setBackground(new java.awt.Color(5, 10, 48));
    rButtonProyecto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/agregar.png"))); // NOI18N
    rButtonProyecto2.setText("Crear Nueva Torre");
    rButtonProyecto2.setColorNormal(new java.awt.Color(5, 10, 48));
    rButtonProyecto2.setColorPressed(new java.awt.Color(39, 33, 105));
    rButtonProyecto2.setFocusPainted(false);
    rButtonProyecto2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    rButtonProyecto2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            rButtonProyecto2MouseClicked(evt);
        }
    });
    rButtonProyecto2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rButtonProyecto2ActionPerformed(evt);
        }
    });
    jPanel1.add(rButtonProyecto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 60));

    rButtonProyecto3.setBackground(new java.awt.Color(5, 10, 48));
    rButtonProyecto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/edit.png"))); // NOI18N
    rButtonProyecto3.setText("Editar");
    rButtonProyecto3.setColorNormal(new java.awt.Color(5, 10, 48));
    rButtonProyecto3.setColorPressed(new java.awt.Color(39, 33, 105));
    rButtonProyecto3.setFocusPainted(false);
    rButtonProyecto3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    rButtonProyecto3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            rButtonProyecto3MouseClicked(evt);
        }
    });
    rButtonProyecto3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rButtonProyecto3ActionPerformed(evt);
        }
    });
    jPanel1.add(rButtonProyecto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 140, 60));

    add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 712));
    }// </editor-fold>//GEN-END:initComponents

    private void rButtonProyecto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto1MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto1MouseClicked

    private void rButtonProyecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto1ActionPerformed
// Eliminar la torre seleccionada
    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow >= 0) {
        int torreNumero = (Integer) jTable2.getValueAt(selectedRow, 0); // Asumiendo que 'Número Torre' es el primer campo

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar la Torre " + torreNumero + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conexion = ConexionBD.getInstancia().getConnection("Admin")) {
                TorreDAO torreDAO = new TorreDAO(conexion);
                boolean eliminado = torreDAO.eliminarTorre(torreNumero);

                if (eliminado) {
                    cargarTorresEnTabla(); // Recargar la tabla después de eliminar
                    JOptionPane.showMessageDialog(this, "La torre fue eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la torre. Verifica si tiene ventas asociadas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar la torre.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una torre para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_rButtonProyecto1ActionPerformed

    private void rButtonProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto2MouseClicked

    private void rButtonProyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto2ActionPerformed
        CrearTorre cp = new CrearTorre();
        

        // Agregar un WindowListener para detectar cuando se cierra la ventana CrearTorre
        cp.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTorresEnTabla(); // Recargar la tabla de torres
            }
        });
        
        cp.setVisible(true);
        
    }//GEN-LAST:event_rButtonProyecto2ActionPerformed

    private void rButtonProyecto3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto3MouseClicked

    private void rButtonProyecto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto3ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow >= 0) {
            int torreNumero = (Integer) jTable2.getValueAt(selectedRow, 0); // Asumiendo que 'Número Torre' es el primer campo
            int idProyecto = (Integer) jTable2.getValueAt(selectedRow, 1); // Obtener el ID del proyecto

            // Abre la ventana de edición
            ActualizarTorre editarTorre = new ActualizarTorre(torreNumero, idProyecto); // Pasar los datos necesarios
                        // Agregar un WindowListener para detectar cuando se cierra la ventana ActualizarTorre
            editarTorre.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    cargarTorresEnTabla(); // Recargar la tabla de torres
                }
            });
            editarTorre.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una torre para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rButtonProyecto3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private Vista.RSButtonMetro rButtonProyecto1;
    private Vista.RSButtonMetro rButtonProyecto2;
    private Vista.RSButtonMetro rButtonProyecto3;
    // End of variables declaration//GEN-END:variables
}
