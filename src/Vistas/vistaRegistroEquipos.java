/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import equipos.futbol2.Conexionn;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class vistaRegistroEquipos extends javax.swing.JFrame {

    /**
     * Creates new form vistaRegistroEquipos
     */
    public vistaRegistroEquipos() {
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

        jFrame1 = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jFrame2 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        txtNombreEquipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValorEquipo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana Pro Semibold", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Nombre de Equipo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 20));

        txtNombreEquipo.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(txtNombreEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 280, 20));

        jLabel3.setFont(new java.awt.Font("Verdana Pro Semibold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Valor:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtValorEquipo.setBackground(new java.awt.Color(204, 255, 204));
        txtValorEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 60, 20));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Verdana Pro Semibold", 1, 14)); // NOI18N
        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/cancha futbol (2).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtValorEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorEquipoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //Equipo equipo = new Equipo();
        
        //EquipoController equipoController = new EquipoController();
        
        String nomEquipo =  txtNombreEquipo.getText();
        int valorEquipo = Integer.parseInt(txtValorEquipo.getText());
        
        Conexionn cc=new Conexionn();
        Connection cn = null;
        try {
            cn = cc.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(vistaRegistroEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            if(existe(nomEquipo)){
                JOptionPane.showMessageDialog(null,"EL EQUIPO YA EXISTE!!!");
            }else{  
    
                PreparedStatement pst=cn.prepareStatement("INSERT INTO EQUIPO_FUTBOL(NOMBRE_EQUIPO,VALOR_EQUIPO) VALUES(?,?)");
                pst.setString(1,nomEquipo);
                pst.setInt(2,valorEquipo);
                int a=pst.executeUpdate();
                if(a>0){
                    JOptionPane.showMessageDialog(null,"Registro exitoso");
                    limpiar();
                }
                else{
                         JOptionPane.showMessageDialog(null,"Error al agregar");
                    }
            }
        }      
            catch(Exception e){
       }
            
            

        
    }//GEN-LAST:event_jButton2ActionPerformed
    private boolean existe(String nombre_equipo) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = null;
        Conexionn cc=new Conexionn();
        Connection cn = null;
        cn = cc.getConexion();
        //Connection con = getConexion();
        ResultSet rs;
        String sql = "SELECT NOMBRE_EQUIPO FROM EQUIPO_FUTBOL WHERE NOMBRE_EQUIPO = ?";

        ps = cn.prepareStatement(sql);
        ps.setString(1, nombre_equipo);
        rs = ps.executeQuery();
        
        if(rs.next()){
            return true;

        }else
            return false;
    }
    private void limpiar(){
        txtNombreEquipo.setText("");
        txtValorEquipo.setText("");
    }
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
            java.util.logging.Logger.getLogger(vistaRegistroEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaRegistroEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaRegistroEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaRegistroEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaRegistroEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNombreEquipo;
    private javax.swing.JTextField txtValorEquipo;
    // End of variables declaration//GEN-END:variables
}
