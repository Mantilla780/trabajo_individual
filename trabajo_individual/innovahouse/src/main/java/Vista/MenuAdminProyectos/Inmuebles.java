/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.MenuAdminProyectos;

import Controlador.ConexionBD;
import Controlador.InmuebleService;
import Modelo.Inmueble;
import Modelo.InmuebleDAO;
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
public class Inmuebles extends javax.swing.JPanel {
    private String idUsuario;
    private InmuebleService inmuebleService; 
    private Timer timer;
    private Connection conexion; 

    public Inmuebles() {
        initComponents();
        this.idUsuario = idUsuario;
    
        // Inicializa la conexión y el InmuebleDAO
        this.conexion = ConexionBD.getInstancia().getConnection("Admin");
        InmuebleDAO inmuebleDAO = new InmuebleDAO(this.conexion);
        inmuebleService = new InmuebleService(inmuebleDAO);

        // Carga inicial de los datos en la tabla
        cargarInmueblesEnTabla();
    
        // Configuración del temporizador para actualizar la tabla cada 5 segundos
        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarInmueblesEnTabla();
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
                    case 4 -> // Quinta columna
                        cell.setBackground(Color.WHITE);
                    case 5 -> // Sexta columna
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
    
    private void cargarInmueblesEnTabla() {
        try (Connection conexion = ConexionBD.getInstancia().getConnection("Admin")) {
            InmuebleDAO inmuebleDAO = new InmuebleDAO(conexion);
            List<Inmueble> inmuebles = inmuebleDAO.obtenerInmuebles();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

            model.setColumnIdentifiers(new String[]{"Matrícula", "Número Inmueble", "Valor Inmueble", "Tipo", "Área", "Número Torre"});
            model.setRowCount(0);

            for (Inmueble inmueble : inmuebles) {
                model.addRow(new Object[]{
                    inmueble.getMatricula(),
                    inmueble.getNumeroInmueble(),
                    inmueble.getValorInmueble(),
                    inmueble.getTipoInmueble(),
                    inmueble.getArea(),
                    inmueble.getIdTorre()
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1120, 600));

        rButtonProyecto2.setBackground(new java.awt.Color(5, 10, 48));
        rButtonProyecto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/agregar.png"))); // NOI18N
        rButtonProyecto2.setText("Crear Nuevo Inmueble");
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

        jLabel1.setText("Apartamento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

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
        int selectedRow = jTable2.getSelectedRow(); // Selecciona la fila en la JTable
        if (selectedRow != -1) {
            // Obtener la matrícula del inmueble desde la tabla (supongamos que está en la primera columna)
            int matriculaInmueble = (int) jTable2.getValueAt(selectedRow, 0);

            // Confirmar eliminación
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este inmueble?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Llamar al servicio para eliminar el inmueble
                boolean resultado = inmuebleService.eliminarInmueble(matriculaInmueble);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Inmueble eliminado con éxito.");
                    cargarInmueblesEnTabla(); // Refrescar la tabla para mostrar el cambio
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el inmueble.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un inmueble para eliminar.");
        }
    }//GEN-LAST:event_rButtonProyecto1ActionPerformed

    private void rButtonProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto2MouseClicked
        CrearInmueble crearinmuble = new CrearInmueble();
        crearinmuble.setVisible(true);
        
    }//GEN-LAST:event_rButtonProyecto2MouseClicked

    private void rButtonProyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto2ActionPerformed

    private void rButtonProyecto3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto3MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto3MouseClicked

    private void rButtonProyecto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto3ActionPerformed
         int selectedRow = jTable2.getSelectedRow();
            if (selectedRow != -1) {
                // Obtener el valor correcto, que debería ser la matrícula, no el número de inmueble
                int matriculaInmueble = (int) jTable2.getValueAt(selectedRow, 0); // Primera columna
                System.out.println("Matrícula seleccionada: " + matriculaInmueble);

                try {
                    // Obtener el inmueble usando el servicio
                    Inmueble inmueble = inmuebleService.obtenerInmueblePorMatricula(matriculaInmueble);
                    System.out.println(inmueble);
                    if (inmueble != null) {
                        // Mostrar la ventana de edición de inmueble con la matrícula
                        ActualizarInmueble editarInmueble = new ActualizarInmueble(matriculaInmueble);
                        editarInmueble.setVisible(true);
                    } else {
                        // Si no se encuentra el inmueble
                        JOptionPane.showMessageDialog(this, "No se encontró el inmueble seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception e) {
                    // Mostrar error en la consola y en el mensaje al usuario
                    e.printStackTrace(); 
                    JOptionPane.showMessageDialog(this, "Error al cargar los detalles del inmueble.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Si no se seleccionó ninguna fila
                JOptionPane.showMessageDialog(this, "Por favor selecciona un inmueble para editar.");
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
}
