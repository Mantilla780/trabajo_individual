/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.MenuAsesorProyectos;



/**
 *
 * @author omaci
 */
public class Clientes extends javax.swing.JPanel {
   

    public Clientes() {
        initComponents();
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
        rButtonProyecto2.setText("Añadir Nuevo Cliente");
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

        jLabel1.setText("Clientes");
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
            
    }//GEN-LAST:event_rButtonProyecto1ActionPerformed

    private void rButtonProyecto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto2MouseClicked
        AnadirCliente p1 = new AnadirCliente();
        p1.setVisible(true);
    }//GEN-LAST:event_rButtonProyecto2MouseClicked

    private void rButtonProyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rButtonProyecto2ActionPerformed

    private void rButtonProyecto3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rButtonProyecto3MouseClicked
        
    }//GEN-LAST:event_rButtonProyecto3MouseClicked

    private void rButtonProyecto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonProyecto3ActionPerformed

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
