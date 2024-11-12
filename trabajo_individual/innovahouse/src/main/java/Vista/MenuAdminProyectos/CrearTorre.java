/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.MenuAdminProyectos;

import Controlador.ConexionBD;
import Controlador.ProyectoService;
import Controlador.TorreService;
import Modelo.Proyecto;
import Modelo.ProyectoDAO;
import Modelo.TorreDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CrearTorre extends javax.swing.JFrame {
     private String idProyecto;
     private TorreService torreService;
     private ProyectoService proyectoService;
     private HashMap<String, Integer> proyectoMap = new HashMap<>();
    /**
     * Creates new form CrearTorre
     */
    public CrearTorre() {
        initComponents();
        
        // Cargar la imagen como icono de la ventana
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Imagenes/logo3.png"));
        setIconImage(icono);
        
        setLocationRelativeTo(null);
        ConexionBD conexionBD = new ConexionBD();
        TorreDAO torreDAO = new TorreDAO(conexionBD.getConnection("Admin"));
        ProyectoDAO proyectoDAO = new ProyectoDAO(conexionBD.getConnection("Admin"));

        this.torreService = new TorreService(torreDAO);
        this.proyectoService = new ProyectoService(proyectoDAO);
        llenarComboBoxProyectos();
         
    }
    private void llenarComboBoxProyectos() {
        List<Proyecto> proyectos = proyectoService.obtenerProyectosBasicos();
        
        jComboBox1.removeAllItems(); 
        for (Proyecto proyecto : proyectos) {
            jComboBox1.addItem(proyecto.getNombreProyecto());
            proyectoMap.put(proyecto.getNombreProyecto(), proyecto.getIdproyecto());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombretorre = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        rSButtonMetro1 = new Vista.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Nueva Torre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Proyecto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Numero Torre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        jPanel1.add(nombretorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 240, 50));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 100, 50));

        rSButtonMetro1.setBackground(new java.awt.Color(0, 191, 99));
        rSButtonMetro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/save.png"))); // NOI18N
        rSButtonMetro1.setText("Guardar");
        rSButtonMetro1.setColorHover(new java.awt.Color(8, 136, 74));
        rSButtonMetro1.setColorNormal(new java.awt.Color(0, 191, 99));
        rSButtonMetro1.setColorPressed(new java.awt.Color(8, 136, 74));
        rSButtonMetro1.setContentAreaFilled(true);
        rSButtonMetro1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 200, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
           try {
        // Obtener los datos de los campos de texto
        int numeroTorre = Integer.parseInt(nombretorre.getText());
                
        // Obtener el ID del proyecto seleccionado en el JComboBox
        String nombreProyectoSeleccionado = (String) jComboBox1.getSelectedItem();
        Integer idProyecto = proyectoMap.get(nombreProyectoSeleccionado);

        if (idProyecto == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un proyecto válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Llamar al método del servicio para guardar la torre
        boolean resultado = torreService.insertarTorre(numeroTorre, idProyecto);

        // Mostrar mensaje de éxito o error
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Torre guardada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar la torre.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El número de torre y de apartamentos debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar la torre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    String proyectoSeleccionado = (String) jComboBox1.getSelectedItem();
            if (proyectoSeleccionado != null && proyectoMap.containsKey(proyectoSeleccionado)) {
                idProyecto = proyectoMap.get(proyectoSeleccionado).toString();
            }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearTorre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearTorre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombretorre;
    private Vista.RSButtonMetro rSButtonMetro1;
    // End of variables declaration//GEN-END:variables
}
