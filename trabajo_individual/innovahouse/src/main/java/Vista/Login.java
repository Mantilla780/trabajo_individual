/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.LoginControlador;
import javax.swing.JOptionPane;

/**
 *
 * @author omaci
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    LoginControlador login;
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        login = new LoginControlador();
        
        
        //TextFieldUsuario.putClientProperty("JComponent.rountReact", 100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogin = new Vista.PanelRound();
        rButtonProyecto1 = new Vista.RSButtonMetro();
        Inovahouse = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        TextFieldUsuario = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        PasswordFieldContraseña = new javax.swing.JPasswordField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLogin.setBackground(new java.awt.Color(39, 33, 105));
        PanelLogin.setForeground(new java.awt.Color(39, 33, 105));
        PanelLogin.setPreferredSize(new java.awt.Dimension(500, 650));
        PanelLogin.setRoundBottomLeft(50);
        PanelLogin.setRoundBottomRight(50);
        PanelLogin.setRoundTopLeft(50);
        PanelLogin.setRoundTopRight(50);
        PanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rButtonProyecto1.setBackground(new java.awt.Color(5, 10, 48));
        rButtonProyecto1.setText("Login");
        rButtonProyecto1.setColorNormal(new java.awt.Color(5, 10, 48));
        rButtonProyecto1.setColorPressed(new java.awt.Color(39, 33, 105));
        rButtonProyecto1.setFocusPainted(false);
        rButtonProyecto1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
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
        PanelLogin.add(rButtonProyecto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 200, 50));

        Inovahouse.setBackground(new java.awt.Color(255, 255, 255));
        Inovahouse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Inovahouse.setForeground(new java.awt.Color(255, 255, 255));
        Inovahouse.setText("INOVAHOUSE");
        PanelLogin.add(Inovahouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/image1.png"))); // NOI18N
        PanelLogin.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        TextFieldUsuario.setBackground(new java.awt.Color(177, 175, 201));
        TextFieldUsuario.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        TextFieldUsuario.setText("Usuario:");
        TextFieldUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TextFieldUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldUsuarioMouseClicked(evt);
            }
        });
        TextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldUsuarioActionPerformed(evt);
            }
        });
        PanelLogin.add(TextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 300, 60));

        jRadioButton1.setBackground(new java.awt.Color(39, 33, 105));
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Mostrar Contraseña");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        PanelLogin.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        PasswordFieldContraseña.setBackground(new java.awt.Color(177, 175, 201));
        PasswordFieldContraseña.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        PasswordFieldContraseña.setText("Contraseña:");
        PasswordFieldContraseña.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PasswordFieldContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordFieldContraseñaMouseClicked(evt);
            }
        });
        PasswordFieldContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldContraseñaActionPerformed(evt);
            }
        });
        PanelLogin.add(PasswordFieldContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 300, 60));

        getContentPane().add(PanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 500, 650));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldUsuarioActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            PasswordFieldContraseña.setEchoChar((char) 0);
        } else {
            PasswordFieldContraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void TextFieldUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldUsuarioMouseClicked
        TextFieldUsuario.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_TextFieldUsuarioMouseClicked

    private void PasswordFieldContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldContraseñaActionPerformed

    private void PasswordFieldContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordFieldContraseñaMouseClicked
        PasswordFieldContraseña.setText("");
    }//GEN-LAST:event_PasswordFieldContraseñaMouseClicked

    private void rButtonProyecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto1ActionPerformed
          // Obtener el nombre de usuario y la contraseña desde los campos de texto
                String usuario = TextFieldUsuario.getText();
                String contraseña = new String(PasswordFieldContraseña.getPassword());

                // Usar el LoginControlador para autenticar al usuario
                String[] autenticacion = login.autenticar(usuario, contraseña);

                // Si la autenticación es exitosa y el idUsuario no es nulo
                if (autenticacion != null) {
                    String idUsuario = autenticacion[0];
                    String rol = autenticacion[1].trim();

                    System.out.println("Rol del usuario autenticado: " + rol);

                    // Redirigir según el rol
                    if ("Admin".equalsIgnoreCase(rol)) {
                        JOptionPane.showMessageDialog(this, "Login exitoso. ¡Bienvenido Admin!");
                        MenuAdministrador menuAdmin = new MenuAdministrador(idUsuario);
                        menuAdmin.setVisible(true);
                    } else if ("Asesor".equalsIgnoreCase(rol)) {
                        JOptionPane.showMessageDialog(this, "Login exitoso. ¡Bienvenido Asesor!");
                        MenuAsesor menuase = new MenuAsesor(idUsuario);
                        menuase.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Rol desconocido.");
                    }

                    // Cerrar la ventana de login
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                }
          
    }//GEN-LAST:event_rButtonProyecto1ActionPerformed

    private void rButtonProyecto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto1MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto1MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Inovahouse;
    private javax.swing.JLabel Logo;
    private Vista.PanelRound PanelLogin;
    private javax.swing.JPasswordField PasswordFieldContraseña;
    private javax.swing.JTextField TextFieldUsuario;
    private javax.swing.JRadioButton jRadioButton1;
    private Vista.RSButtonMetro rButtonProyecto1;
    // End of variables declaration//GEN-END:variables
}
