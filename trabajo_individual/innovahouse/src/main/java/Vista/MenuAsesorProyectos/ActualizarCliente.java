/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.MenuAsesorProyectos;


import Controlador.ClienteService;
import Modelo.Cliente;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


/**
 *
 * @author USER
 */
public class ActualizarCliente extends javax.swing.JFrame {
    private ClienteService clienteService;
    private int cedula;
    
    public ActualizarCliente(int cedula, String nombre, String sisben, int subsidioMinisterio, String direccion, int telefono, String correoElectronico, ClienteService clienteService) {
        initComponents(); 
        
        // Cargar la imagen como icono de la ventana
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Imagenes/logo3.png"));
        setIconImage(icono);
        
        this.clienteService = clienteService;
        this.cedula= cedula;
       
        // Inicializar campos del formulario con los valores recibidos
        nombreTextField.setText(nombre);
        sisbenCheckBox.setSelected("SI".equalsIgnoreCase(sisben));
        subsidioTextField.setText(String.valueOf(subsidioMinisterio));
        direccionTextField.setText(direccion);
        telefonoTextField.setText(String.valueOf(telefono));
        correoTextField.setText(correoElectronico);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreproyecto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombreproyecto1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        nombreproyecto2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nombreproyecto3 = new javax.swing.JTextField();
        nombreproyecto4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombreproyecto5 = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Nombre Proyecto");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(1, 60, 136));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/actualizar.png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 200, 60));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Actualizar Cliente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        nombreproyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreproyectoActionPerformed(evt);
            }
        });
        jPanel1.add(nombreproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 380, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Nombre Cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        nombreproyecto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreproyecto1ActionPerformed(evt);
            }
        });
        jPanel1.add(nombreproyecto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 380, 50));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jCheckBox1.setText("Sisben");
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("Numero Cedula");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        nombreproyecto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreproyecto2ActionPerformed(evt);
            }
        });
        jPanel1.add(nombreproyecto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 380, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setText("Subsidio");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        nombreproyecto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreproyecto3ActionPerformed(evt);
            }
        });
        jPanel1.add(nombreproyecto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 380, 50));

        nombreproyecto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreproyecto4ActionPerformed(evt);
            }
        });
        jPanel1.add(nombreproyecto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 380, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setText("Correo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        nombreproyecto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreproyecto5ActionPerformed(evt);
            }
        });
        jPanel1.add(nombreproyecto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 380, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void nombreproyecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreproyecto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreproyecto1ActionPerformed

    private void nombreproyecto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreproyecto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreproyecto3ActionPerformed

    private void nombreproyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreproyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreproyectoActionPerformed

    private void nombreproyecto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreproyecto4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreproyecto4ActionPerformed

    private void nombreproyecto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreproyecto5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreproyecto5ActionPerformed

    private void nombreproyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreproyecto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreproyecto2ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreproyecto;
    private javax.swing.JTextField nombreproyecto1;
    private javax.swing.JTextField nombreproyecto2;
    private javax.swing.JTextField nombreproyecto3;
    private javax.swing.JTextField nombreproyecto4;
    private javax.swing.JTextField nombreproyecto5;
    // End of variables declaration//GEN-END:variables
}
