/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.MenuAsesorProyectos;

import Controlador.ClienteService;
import Controlador.ConexionBD;
import Modelo.Cliente;
import java.sql.Connection;
import javax.swing.JOptionPane;


/**
 *
 * @author USER
 */
public class ActualizarCliente extends javax.swing.JFrame {
    
    private ClienteService clienteService;
    
    public ActualizarCliente(int cedula, String nombre, String sisben, int subsidio, String direccion, int telefono, String correoElectronico) {
        initComponents(); 
          Connection conexion = ConexionBD.getInstancia().getConnection("Asesor");
        
        // Inicializar ClienteService con la conexión
        clienteService = new ClienteService(conexion);
    // Establece los valores en los campos correspondientes
        nombreproyecto1.setText(nombre); // Campo para el nombre
        nombreproyecto3.setText(String.valueOf(cedula)); // Convierte int a String para mostrar
        jCheckBox1.setSelected("Sí".equalsIgnoreCase(sisben)); // Maneja sisben como booleano o similar
        nombreproyecto.setText(subsidio > 0 ? String.valueOf(subsidio) : ""); // Manejo de nulo o 0
        nombreproyecto4.setText(direccion != null ? direccion : ""); // Manejo de nulo
        nombreproyecto2.setText(telefono > 0 ? String.valueOf(telefono) : ""); // Manejo de nulo o 0
        nombreproyecto5.setText(correoElectronico != null ? correoElectronico : ""); // Manejo de nulo
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Actualizar Cliente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        nombreproyecto.setEnabled(false);
        jPanel1.add(nombreproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 380, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Nombre Cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
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
        jPanel1.add(nombreproyecto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 380, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setText("Subsidio");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));
        jPanel1.add(nombreproyecto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 380, 50));
        jPanel1.add(nombreproyecto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 380, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setText("Correo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));
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

       // Obtener los datos de los campos del formulario
        String nombre = nombreproyecto1.getText();
        String direccion = nombreproyecto4.getText();
        String correo = nombreproyecto5.getText();
        int telefono = 0;
        try {
            telefono = Integer.parseInt(nombreproyecto2.getText()); // Convertir el teléfono a entero
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número de teléfono válido.");
            return;
        }

        int cedula = 0;
        try {
            cedula = Integer.parseInt(nombreproyecto3.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una cédula válida.");
            return;
        }

        int subsidio = 0;
        try {
            subsidio = Integer.parseInt(nombreproyecto.getText());
        } catch (NumberFormatException e) {
            // Si no hay subsidio o es 0, lo dejamos como 0
        }

        boolean tieneSisben = jCheckBox1.isSelected();
        
        // Crear el objeto Cliente y llamar al método de actualización
        Cliente cliente = new Cliente(cedula, nombre, tieneSisben ? "Sí" : "No", subsidio, direccion, telefono, correo);
        boolean resultado = clienteService.actualizarCliente(cliente);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Cliente actualizado exitosamente.");
            dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al actualizar el cliente.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        nombreproyecto.setEnabled(jCheckBox1.isSelected());         
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
                new ActualizarCliente(0,"default","default",0,"default",0,"default").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
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
