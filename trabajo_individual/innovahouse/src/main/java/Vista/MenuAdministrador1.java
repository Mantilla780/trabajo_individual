/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ProyectoService;
import Vista.MenuAdminProyectos.Inmueble;
import Vista.MenuAdminProyectos.Proyectos;
import Vista.MenuAdminProyectos.Torres;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 *
 * @author omaci
 */
public class MenuAdministrador1 extends javax.swing.JFrame {
    private String idUsuario;
    private String idProyecto;
    private String numerotorre;
    private ProyectoService proyectoService; 
    /**
     * Creates new form MenuAdministrador
     */
    public MenuAdministrador1(String idUsuario) {
        initComponents(); 
        setLocationRelativeTo(null);
        this.idUsuario = idUsuario;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuSliding = new javax.swing.JPanel();
        ButtonProyecto = new Vista.RSButtonMetro();
        ButtonTorres = new Vista.RSButtonMetro();
        ButtonApartamentos = new Vista.RSButtonMetro();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(202, 232, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuSliding.setBackground(new java.awt.Color(76, 69, 153));
        MenuSliding.setForeground(new java.awt.Color(39, 33, 105));
        MenuSliding.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Proyectoo.png"))); // NOI18N
        ButtonProyecto.setText("Proyectos");
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

        ButtonTorres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Torre.png"))); // NOI18N
        ButtonTorres.setText("Torres");
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

        ButtonApartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/departamento.png"))); // NOI18N
        ButtonApartamentos.setText("Inmueble");
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

        getContentPane().add(MenuSliding, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 210, 800));

        jPanel3.setBackground(new java.awt.Color(202, 232, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1190, 720));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/logo3 (1).png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 540, 360));

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

        jPanel4.setBackground(new java.awt.Color(39, 33, 105));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(202, 232, 255));
        jLabel3.setText("INOVAHOUSE");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 80));

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
            
            Inmueble p3 = new Inmueble();
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
            
            Proyectos p1 = new Proyectos(idUsuario);
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
            
            Torres p2 = new Torres();
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
            java.util.logging.Logger.getLogger(MenuAdministrador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador1("default").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.RSButtonMetro ButtonApartamentos;
    private Vista.RSButtonMetro ButtonProyecto;
    private Vista.RSButtonMetro ButtonTorres;
    private javax.swing.JPanel MenuSliding;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
