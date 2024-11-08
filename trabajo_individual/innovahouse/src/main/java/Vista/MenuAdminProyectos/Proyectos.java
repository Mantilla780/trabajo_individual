/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.MenuAdminProyectos;

import Controlador.ConexionBD;
import Controlador.ProyectoService;
import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author omaci
 */
public class Proyectos extends javax.swing.JPanel {
    private String idUsuario;
    private String idProyecto;
    private String numerotorre;
    private ProyectoService proyectoService; 
    private Timer timer;
    private Connection conexion; // Conexión mantenida durante la vida útil de la clase

    public Proyectos(String idUsuario) {
        initComponents();
        this.idUsuario = idUsuario;
    
        // Inicializa la conexión y el ProyectoDAO
        this.conexion = ConexionBD.getInstancia().getConnection();
        ProyectoDAO proyectoDAO = new ProyectoDAO(this.conexion);
        proyectoService = new ProyectoService(proyectoDAO);

        // Carga inicial de los datos en la tabla
        cargarProyectosEnTabla();
    
        // Configuración del temporizador para actualizar la tabla cada 5 segundos
        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProyectosEnTabla();
            }
        });
    
        // Iniciar el temporizador
        timer.start();
        
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
    
    private void cargarProyectosEnTabla() {
    try (Connection conexion = ConexionBD.getInstancia().getConnection()) {
        ProyectoDAO proyectoDAO = new ProyectoDAO(conexion);
        List<Proyecto> proyectos = proyectoDAO.obtenerProyectos();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.setColumnIdentifiers(new String[]{"ID Proyecto", "Nombre", "Número Torres", "ID Usuario"});
        model.setRowCount(0);

        for (Proyecto proyecto : proyectos) {
            model.addRow(new Object[]{
                proyecto.getIdproyecto(),
                proyecto.getNombreProyecto(),
                proyecto.getNumeroTorres(), // Asegúrate de que este campo es el correcto
                proyecto.getIdUsuario() // Asegúrate de que también tienes este campo en el modelo
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
        rButtonProyecto2.setText("Crear Nuevo Proyecto");
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

        jLabel1.setText("Proyectos");
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
    
    private void formWindowOpened(java.awt.event.WindowEvent evt){
        
        cargarTabla();
        
    }
    
    private void rButtonProyecto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto1MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto1MouseClicked

    private void rButtonProyecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto1ActionPerformed
            int selectedRow = jTable2.getSelectedRow(); // Supongamos que estás usando una JTable para mostrar proyectos
    if (selectedRow != -1) {
        // Obtener el ID del proyecto desde la tabla (supongamos que está en la primera columna)
        int idProyecto = (int) jTable2.getValueAt(selectedRow, 0);
        
        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este proyecto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Llamar al servicio para eliminar el proyecto
            boolean resultado = proyectoService.eliminarProyecto(idProyecto);
            
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Proyecto eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el proyecto.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un proyecto para eliminar.");
    }
    }//GEN-LAST:event_rButtonProyecto1ActionPerformed

    private void rButtonProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto2MouseClicked
        CrearProyecto cp = new CrearProyecto(idUsuario);
        cp.setVisible(true);
    }//GEN-LAST:event_rButtonProyecto2MouseClicked

    private void rButtonProyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto2ActionPerformed

    private void rButtonProyecto3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto3MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto3MouseClicked

    private void rButtonProyecto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto3ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
    if (selectedRow != -1) {
        // Obtén los datos del proyecto seleccionado
        int idProyecto = (int) jTable2.getValueAt(selectedRow, 0);
        String nombreProyecto = (String) jTable2.getValueAt(selectedRow, 1);
        int numeroTorres = (int) jTable2.getValueAt(selectedRow, 2);
        String idUsuario = (String) jTable2.getValueAt(selectedRow, 3);
        
        // Abre el formulario de actualización
        ActualizarProyecto ap = new ActualizarProyecto(idProyecto, nombreProyecto, idUsuario, proyectoService);
        ap.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona un proyecto para editar.");
    }
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

    private void cargarTabla() {
        DefaultTableModel tabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
    
    //establecer nombres de las columnas
    String titulos[]={"Id","Nombre","Numero_Torres"};
    tabla.setColumnIdentifiers(titulos);
    
    //carga de los datos desde la BD
    
    }
}
