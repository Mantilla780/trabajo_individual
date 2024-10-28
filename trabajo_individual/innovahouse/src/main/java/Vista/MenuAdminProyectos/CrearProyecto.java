
package Vista.MenuAdminProyectos;

import Controlador.ConexionBD;
import Controlador.ProyectoService;
import Modelo.ProyectoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author omaci
 */
public class CrearProyecto extends javax.swing.JFrame {
    private String idUsuario;
    private ProyectoService proyectoService;
  
   
    public CrearProyecto(String idUsuario) {
        initComponents();
        setLocationRelativeTo(null);
        initComponents();
        this.idUsuario= idUsuario;
        ConexionBD conexionBD = new ConexionBD();
        ProyectoDAO proyectoDAO = new ProyectoDAO(conexionBD.getConnection());
        this.proyectoService = new ProyectoService(proyectoDAO);
        
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
        cantidadtorres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonMetro1 = new Vista.RSButtonMetro();
        jLabel3 = new javax.swing.JLabel();
        nombreproyecto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cantidadtorres.setActionCommand("<Not Set>");
        cantidadtorres.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(cantidadtorres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 380, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Nuevo Proyecto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Cantidad Torres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        rSButtonMetro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/save.png"))); // NOI18N
        rSButtonMetro1.setText("Crear");
        rSButtonMetro1.setColorHover(new java.awt.Color(8, 136, 74));
        rSButtonMetro1.setColorNormal(new java.awt.Color(0, 191, 99));
        rSButtonMetro1.setColorPressed(new java.awt.Color(8, 136, 74));
        rSButtonMetro1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 200, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Nombre Proyecto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel1.add(nombreproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 380, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        try {
            String nombreProyecto = nombreproyecto.getText();
            int numeroTorres = Integer.parseInt(cantidadtorres.getText());
            System.out.println(numeroTorres);

            boolean resultado = proyectoService.agregarProyecto(nombreProyecto, numeroTorres, idUsuario);

            if (resultado) {
                JOptionPane.showMessageDialog(this, "Proyecto guardado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el proyecto.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número de torres debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el proyecto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearProyecto("default").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidadtorres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreproyecto;
    private Vista.RSButtonMetro rSButtonMetro1;
    // End of variables declaration//GEN-END:variables
}
