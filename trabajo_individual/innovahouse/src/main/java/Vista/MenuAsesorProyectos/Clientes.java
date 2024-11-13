/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.MenuAsesorProyectos;

import Controlador.ClienteService;
import Controlador.ConexionBD;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



/**
 *
 * @author omaci
 */
public class Clientes extends javax.swing.JPanel {
   

    public Clientes() {
        initComponents();
        cargarClientesEnTabla();
    }
          // Método para mostrar los clientes en la tabla
    private void cargarClientesEnTabla() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
            ClienteDAO clienteDAO = new ClienteDAO(conexion);
            List<Cliente> clientes = clienteDAO.listarClientes();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

            // Establecemos los nombres de las columnas
            model.setColumnIdentifiers(new String[]{"Cédula", "Nombre", "Sisben", "Subsidio Ministerio", "Dirección", "Teléfono", "Correo Electrónico", "Vender"});
            model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

            for (Cliente cliente : clientes) {
                model.addRow(new Object[]{
                    cliente.getCedula(),
                    cliente.getNombre(),
                    cliente.getSisben() != null ? cliente.getSisben() : "No",
                    cliente.getSUBSIDIOMINISTERIO()!= 0 ? cliente.getSUBSIDIOMINISTERIO() : "No",
                    cliente.getDireccion(),
                    cliente.getTelefono(),
                    cliente.getCorreoelectronico(),
                    "Vender" // Texto del botón
                });
            }

            // Añadimos un renderer y un editor para la columna del botón "Vender"
            TableColumn venderColumn = jTable2.getColumn("Vender");
            venderColumn.setCellRenderer(new ButtonRenderer());
            venderColumn.setCellEditor(new ButtonEditor(new JButton("Vender")));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Renderer para el botón
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setText("Vender");
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Editor para el botón
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JButton button) {
            super(new JCheckBox());
            this.button = button;
            this.button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    int selectedRow = jTable2.getSelectedRow();
                    if (selectedRow != -1) {
                        String cedula = (String) jTable2.getValueAt(selectedRow, 0);
                        // Aquí puedes implementar la lógica para la acción de "Vender"
                        JOptionPane.showMessageDialog(null, "Vender al cliente con cédula: " + cedula);
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Vender" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
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
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1190, 720));

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

        jTable2.setBackground(new java.awt.Color(254, 254, 254));
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
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
        jTable2.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1120, 600));

        rButtonProyecto2.setBackground(new java.awt.Color(5, 10, 48));
        rButtonProyecto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/agregar.png"))); // NOI18N
        rButtonProyecto2.setText("Añadir Nuevo Cliente");
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

        jLabel1.setText("Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void rButtonProyecto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto1MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto1MouseClicked

    private void rButtonProyecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto1ActionPerformed
            int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int cedula = (int) jTable2.getValueAt(selectedRow, 0);
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar al cliente con cédula " + cedula + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
                ClienteService clienteService = new ClienteService(conexion);
                if (clienteService.eliminarCliente(cedula)) {
                    JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito.");
                    cargarClientesEnTabla(); // Actualizamos la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el cliente. Inténtalo nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_rButtonProyecto1ActionPerformed

    private void rButtonProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto2MouseClicked
        AnadirCliente p1 = new AnadirCliente();
        p1.setVisible(true);
    }//GEN-LAST:event_rButtonProyecto2MouseClicked

    private void rButtonProyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto2ActionPerformed

    private void rButtonProyecto3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto3MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto3MouseClicked

    private void rButtonProyecto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto3ActionPerformed

    }//GEN-LAST:event_rButtonProyecto3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private Vista.RSButtonMetro rButtonProyecto1;
    private Vista.RSButtonMetro rButtonProyecto2;
    private Vista.RSButtonMetro rButtonProyecto3;
    // End of variables declaration//GEN-END:variables

    
}
