/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.MenuAsesorProyectos;

import Controlador.VentaService;
import Modelo.ConexionBD;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omaci
 */
public class Ventas extends javax.swing.JPanel {
    private String idUsuario;

    public Ventas(String idUsuario) {
        initComponents();
        this.idUsuario = idUsuario;
        cargarVentasEnTabla();
    }
    
    private void cargarVentasEnTabla() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
            // Usar VentaService
            VentaService ventaService = new VentaService(conexion);
            List<Venta> ventas = ventaService.obtenerVentas();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

            // Establecer las columnas
            model.setColumnIdentifiers(new String[]{
                "ID Venta", "Precio Total", "Número de Cuotas", "Intereses", "Nombre usuario", "Nombre cliente", "Matrícula Inmueble"
            });
            model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

            // Añadir filas con las ventas
            for (Venta venta : ventas) {
                model.addRow(new Object[]{
                    venta.getIdventa(),
                    venta.getPRECIOTOTALVENTA(),
                    venta.getNumerocuotas(),
                    venta.getIntereses(),
                    venta.getNombreUsuario(),
                    venta.getNombreCliente(),
                    venta.getMatinmueble()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
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
                    case 3 -> // Cuarta columna
                        cell.setBackground(Color.WHITE);
                    case 4 -> // Quinta columna
                        cell.setBackground(Color.WHITE);
                    case 5 -> // Sexta columna
                        cell.setBackground(Color.WHITE);
                    case 6 -> // Septima colimna
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1120, 530));

        rButtonProyecto2.setBackground(new java.awt.Color(5, 10, 48));
        rButtonProyecto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/agregar.png"))); // NOI18N
        rButtonProyecto2.setText("Añadir Nueva Venta");
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

        jLabel1.setText("Ventas");
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
            // Verificar que se haya seleccionado una fila
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una venta para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el ID de la venta seleccionada
        int idVenta = (int) jTable2.getValueAt(selectedRow, 0);

        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de que deseas eliminar la venta con ID " + idVenta + "?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try (Connection conexion = ConexionBD.getInstancia().getConnection("Asesor")) {
                // Crear el servicio de ventas
                VentaService ventaService = new VentaService(conexion);

                // Intentar eliminar la venta
                boolean eliminada = ventaService.eliminarVenta(idVenta);

                if (eliminada) {
                    JOptionPane.showMessageDialog(this, "Venta eliminada con éxito.");
                    cargarVentasEnTabla(); // Actualizar la tabla después de la eliminación
                } else {
                    JOptionPane.showMessageDialog(this, "No se puede eliminar la venta. Existe al menos un pago ya realizado.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }      
    }//GEN-LAST:event_rButtonProyecto1ActionPerformed

    private void rButtonProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto2MouseClicked
        AnadirVenta v1 = new AnadirVenta(idUsuario);
        v1.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarVentasEnTabla(); // Refresca los datos en la tabla o realiza la acción necesaria
            }
        });

        v1.setVisible(true);
    }//GEN-LAST:event_rButtonProyecto2MouseClicked

    private void rButtonProyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private Vista.RSButtonMetro rButtonProyecto1;
    private Vista.RSButtonMetro rButtonProyecto2;
    // End of variables declaration//GEN-END:variables

    
}
