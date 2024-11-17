/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.MenuAsesorProyectos;
import Controlador.ConexionBD;
import Modelo.Pago;
import Modelo.PagoDAO;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.table.DefaultTableModel;

    public class Pagos extends javax.swing.JPanel {
       private String idUsuario;

        public Pagos(String idusuario) {
            initComponents();
            this.idUsuario=idusuario;
            cargarPagosEnTabla();
        }
    private void cargarPagosEnTabla() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
            PagoDAO pagoDAO = new PagoDAO(conexion);
            List<Pago> pagos = pagoDAO.listarPagos();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

            // Establecer nombres de columnas, incluyendo la nueva columna de botones
            model.setColumnIdentifiers(new String[]{
                "ID Pago", "Fecha de Pago", "Valor del Pago", "Estado", "ID Venta", "Cédula Cliente", "Pagar"
            });

            model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

            for (Pago pago : pagos) {
                model.addRow(new Object[]{
                    pago.getIdPago(),
                    pago.getFechaPago(),
                    pago.getValorPago(),
                    pago.getEstadoPago(),
                    pago.getIdVenta(),
                    pago.getCcCliente(),
                    "Pagar" // Placeholder para el botón 
                });
            }

            // Asignar el renderizador y editor a la columna de botones
            jTable2.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
            jTable2.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(jTable2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setText("Pagar"); // Texto del botón
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private int selectedRow;

        public ButtonEditor(JTable table) {
            button = new JButton("Acción");
            button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.selectedRow = row; // Guarda la fila seleccionada
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
            null,
            "¿Quieres completar el pago?",
            "Confirmación de Pago",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            // Obtén el ID del Pago desde la fila seleccionada
            int idPago = (int) jTable2.getValueAt(selectedRow, 0); // Columna 0: ID Pago

            try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
                PagoDAO pagoDAO = new PagoDAO(conexion);
                boolean actualizado = pagoDAO.actualizarEstadoPago(idPago, "PAG");

                if (actualizado) {
                    // Actualizar la tabla visualmente con la nueva fecha y estado
                    String fechaSistema = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
                    jTable2.setValueAt("PAG", selectedRow, 3); // Columna 3: Estado
                    jTable2.setValueAt(fechaSistema, selectedRow, 1); // Columna 1: Fecha de Pago

                    javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "El estado del pago ha sido actualizado a 'PAG' y la fecha de pago se actualizó a " + fechaSistema + ".",
                        "Pago Completado",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "No se pudo completar el pago. Intenta nuevamente.",
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error al completar el pago.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }

        fireEditingStopped(); // Finaliza la edición del botón
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        rButtonProyecto2 = new Vista.RSButtonMetro();

        setPreferredSize(new java.awt.Dimension(1190, 720));

        jPanel1.setBackground(new java.awt.Color(202, 232, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        rButtonProyecto2.setText("Generar Cuotas");
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
    
    private void rButtonProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto2MouseClicked
        AnadirPago ap = new AnadirPago(idUsuario);
        ap.setVisible(true);
    }//GEN-LAST:event_rButtonProyecto2MouseClicked

    private void rButtonProyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private Vista.RSButtonMetro rButtonProyecto2;
    // End of variables declaration//GEN-END:variables

    
}
