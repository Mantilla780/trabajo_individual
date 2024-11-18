/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.ConexionBD;
import Controlador.ProyectoService;
import Modelo.PagoDAO;
import Vista.MenuAsesorProyectos.Clientes;
import Vista.MenuAsesorProyectos.Pagos;
import Vista.MenuAsesorProyectos.Ventas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omaci
 */
public class MenuAsesor extends javax.swing.JFrame {
    private String idUsuario;
    private String idProyecto;
    private String numerotorre;
    private ProyectoService proyectoService;
    private PagoDAO pagoDAO;
    /**
     * Creates new form MenuAdministrador
     */
    public MenuAsesor(String idUsuario) {
        initComponents(); 
        // Cargar la imagen como icono de la ventana
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Imagenes/logo3.png"));
        setIconImage(icono);

        setLocationRelativeTo(null);
        this.idUsuario = idUsuario;
        
        try {
            Connection conexionAsesor = ConexionBD.getInstancia().getConnection("Asesor");
            if (conexionAsesor != null) {
                pagoDAO = new PagoDAO(conexionAsesor); // Pasa la conexión al constructor de PagoDAO
            } else {
                System.err.println("No se pudo obtener la conexión de asesor.");
            }
        } catch (Exception e) {
            System.err.println("Error al inicializar PagoDAO: " + e.getMessage());
        }
        
        cargarTablaPagos();
    }
    
    private void cargarTablaPagos() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Cuotas");

        List<String> pagos = pagoDAO.obtenerPagosProximos();

        for (String pago : pagos) {
            // Parsear los datos del mensaje (puedes ajustar esto si obtienes la lista directamente como objetos)
            String[] partes = pago.split(","); // Asumiendo que los valores están separados por comas
            modeloTabla.addRow(partes);
        }

        jTable2.setModel(modeloTabla);
        
        // Configurar renderer para colorear cada columna de la tabla
        jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Aplica un color de fondo específico para cada columna
                switch (column) {
                    case 0 -> // Primera columna
                        cell.setBackground(Color.RED);
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

        logout = new javax.swing.JButton();
        MenuSliding = new javax.swing.JPanel();
        ButtonProyecto = new Vista.RSButtonMetro();
        ButtonTorres = new Vista.RSButtonMetro();
        ButtonApartamentos = new Vista.RSButtonMetro();
        logout1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        RecargarMenu = new javax.swing.JButton();

        logout.setBackground(new java.awt.Color(0, 0, 0));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/logout.png"))); // NOI18N
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(202, 232, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuSliding.setBackground(new java.awt.Color(76, 69, 153));
        MenuSliding.setForeground(new java.awt.Color(39, 33, 105));
        MenuSliding.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/cliente.png"))); // NOI18N
        ButtonProyecto.setText("Cliente");
        ButtonProyecto.setColorHover(new java.awt.Color(39, 33, 105));
        ButtonProyecto.setColorNormal(new java.awt.Color(76, 69, 153));
        ButtonProyecto.setColorPressed(new java.awt.Color(39, 33, 105));
        ButtonProyecto.setFocusPainted(false);
        ButtonProyecto.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        ButtonProyecto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonProyecto.setIconTextGap(20);
        ButtonProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonProyectoMousePressed(evt);
            }
        });
        ButtonProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProyectoActionPerformed(evt);
            }
        });
        MenuSliding.add(ButtonProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 50));

        ButtonTorres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/venta.png"))); // NOI18N
        ButtonTorres.setText("Ventas");
        ButtonTorres.setColorHover(new java.awt.Color(39, 33, 105));
        ButtonTorres.setColorNormal(new java.awt.Color(76, 69, 153));
        ButtonTorres.setColorPressed(new java.awt.Color(39, 33, 105));
        ButtonTorres.setFocusPainted(false);
        ButtonTorres.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        ButtonTorres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonTorres.setIconTextGap(20);
        ButtonTorres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonTorresMousePressed(evt);
            }
        });
        ButtonTorres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTorresActionPerformed(evt);
            }
        });
        MenuSliding.add(ButtonTorres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, 50));

        ButtonApartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/pagos.png"))); // NOI18N
        ButtonApartamentos.setText("Pagos");
        ButtonApartamentos.setColorHover(new java.awt.Color(39, 33, 105));
        ButtonApartamentos.setColorNormal(new java.awt.Color(76, 69, 153));
        ButtonApartamentos.setColorPressed(new java.awt.Color(39, 33, 105));
        ButtonApartamentos.setFocusPainted(false);
        ButtonApartamentos.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        ButtonApartamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonApartamentos.setIconTextGap(20);
        ButtonApartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonApartamentosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonApartamentosMousePressed(evt);
            }
        });
        ButtonApartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonApartamentosActionPerformed(evt);
            }
        });
        MenuSliding.add(ButtonApartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, 50));

        logout1.setBackground(new java.awt.Color(0, 0, 0));
        logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/logout.png"))); // NOI18N
        logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout1ActionPerformed(evt);
            }
        });
        MenuSliding.add(logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 748, 60, 50));

        getContentPane().add(MenuSliding, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 210, 800));

        jPanel3.setBackground(new java.awt.Color(202, 232, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1190, 720));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/logo3 (1).png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 540, 360));

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
        jScrollPane1.setViewportView(jTable2);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1080, 770));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 1190, 800));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1400, 75));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(36, 33, 98));
        jLabel2.setText("INOVAHOUSE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1315, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/logo2.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1315, 0, -1, -1));

        RecargarMenu.setBackground(new java.awt.Color(39, 33, 105));
        RecargarMenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RecargarMenu.setForeground(new java.awt.Color(202, 232, 255));
        RecargarMenu.setText("INOVAHOUSE");
        RecargarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecargarMenuActionPerformed(evt);
            }
        });
        jPanel2.add(RecargarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonApartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonApartamentosActionPerformed
        if(this.ButtonApartamentos.isSelected()){
            this.ButtonApartamentos.setColorNormal(new Color(39,33,105));
            this.ButtonApartamentos.setColorHover(new Color(39,33,105));
            this.ButtonApartamentos.setColorPressed(new Color(39,33,105));
            
            this.ButtonTorres.setColorNormal(new Color(76,69,153));
            this.ButtonTorres.setColorHover(new Color(39,33,105));
            this.ButtonTorres.setColorPressed(new Color(76,69,153));
            
            this.ButtonProyecto.setColorNormal(new Color(76,69,153));
            this.ButtonProyecto.setColorHover(new Color(39,33,105));
            this.ButtonProyecto.setColorPressed(new Color(76,69,153));
            
            Pagos p3 = new Pagos(idUsuario);
            p3.setSize(1190,620);
            p3.setLocation(20,20);
            jPanel3.removeAll();
            jPanel3.add(p3,BorderLayout.CENTER);
            jPanel3.revalidate();
            jPanel3.revalidate();
        }else{
            this.ButtonApartamentos.setColorNormal(new Color(76,69,153));
            this.ButtonApartamentos.setColorHover(new Color(39,33,105));
            this.ButtonApartamentos.setColorPressed(new Color(76,69,153));
        }
    }//GEN-LAST:event_ButtonApartamentosActionPerformed

    private void ButtonProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProyectoActionPerformed
        if(this.ButtonProyecto.isSelected()){
            this.ButtonProyecto.setColorNormal(new Color(39,33,105));
            this.ButtonProyecto.setColorHover(new Color(39,33,105));
            this.ButtonProyecto.setColorPressed(new Color(39,33,105));
            
            this.ButtonTorres.setColorNormal(new Color(76,69,153));
            this.ButtonTorres.setColorHover(new Color(39,33,105));
            this.ButtonTorres.setColorPressed(new Color(76,69,153));
            
            this.ButtonApartamentos.setColorNormal(new Color(76,69,153));
            this.ButtonApartamentos.setColorHover(new Color(39,33,105));
            this.ButtonApartamentos.setColorPressed(new Color(76,69,153));
            
            Clientes p1 = new Clientes();
            p1.setSize(1190,620);
            p1.setLocation(20,20);
            jPanel3.removeAll();
            jPanel3.add(p1,BorderLayout.CENTER);
            jPanel3.revalidate();
            jPanel3.revalidate();
        }else{
            this.ButtonProyecto.setColorNormal(new Color(76,69,153));
            this.ButtonProyecto.setColorHover(new Color(39,33,105));
            this.ButtonProyecto.setColorPressed(new Color(76,69,153));
        }
    }//GEN-LAST:event_ButtonProyectoActionPerformed

    private void ButtonTorresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTorresActionPerformed
       if(this.ButtonTorres.isSelected()){
            this.ButtonTorres.setColorNormal(new Color(39,33,105));
            this.ButtonTorres.setColorHover(new Color(39,33,105));
            this.ButtonTorres.setColorPressed(new Color(39,33,105));
            
            this.ButtonProyecto.setColorNormal(new Color(76,69,153));
            this.ButtonProyecto.setColorHover(new Color(39,33,105));
            this.ButtonProyecto.setColorPressed(new Color(76,69,153));
            
            this.ButtonApartamentos.setColorNormal(new Color(76,69,153));
            this.ButtonApartamentos.setColorHover(new Color(39,33,105));
            this.ButtonApartamentos.setColorPressed(new Color(76,69,153));
            
            Ventas p2 = new Ventas(idUsuario);
            p2.setSize(1190,620);
            p2.setLocation(20,20);
            jPanel3.removeAll();
            jPanel3.add(p2,BorderLayout.CENTER);
            jPanel3.revalidate();
            jPanel3.revalidate();
        }else{
            this.ButtonTorres.setColorNormal(new Color(76,69,153));
            this.ButtonTorres.setColorHover(new Color(39,33,105));
            this.ButtonTorres.setColorPressed(new Color(76,69,153));
        }
    }//GEN-LAST:event_ButtonTorresActionPerformed

    private void ButtonProyectoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonProyectoMousePressed
        this.ButtonProyecto.setSelected(true);
        this.ButtonTorres.setSelected(false);
        this.ButtonApartamentos.setSelected(false);
    }//GEN-LAST:event_ButtonProyectoMousePressed

    private void ButtonTorresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTorresMousePressed
        this.ButtonTorres.setSelected(true);
        this.ButtonProyecto.setSelected(false);
        this.ButtonApartamentos.setSelected(false);
    }//GEN-LAST:event_ButtonTorresMousePressed

    private void ButtonApartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonApartamentosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonApartamentosMouseClicked

    private void ButtonApartamentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonApartamentosMousePressed
        this.ButtonTorres.setSelected(false);
        this.ButtonProyecto.setSelected(false);
        this.ButtonApartamentos.setSelected(true);
    }//GEN-LAST:event_ButtonApartamentosMousePressed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // Cierra la ventana actual
        this.dispose();

        // Abre la ventana de Login
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        // Cierra la ventana actual
        this.dispose();

        // Abre la ventana de Login
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }//GEN-LAST:event_logout1ActionPerformed

    private void RecargarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecargarMenuActionPerformed
        // Cierra la ventana actual
        this.dispose();

        // Vuelve a crear y mostrar la ventana de MenuAsesor con el idUsuario actual
        MenuAsesor menuAsesorWindow = new MenuAsesor(idUsuario);
        menuAsesorWindow.setVisible(true);
    }//GEN-LAST:event_RecargarMenuActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAsesor("default").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.RSButtonMetro ButtonApartamentos;
    private Vista.RSButtonMetro ButtonProyecto;
    private Vista.RSButtonMetro ButtonTorres;
    private javax.swing.JPanel MenuSliding;
    private javax.swing.JButton RecargarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton logout;
    private javax.swing.JButton logout1;
    // End of variables declaration//GEN-END:variables
}
