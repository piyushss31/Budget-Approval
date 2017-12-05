
package loginpage;
import java.awt.Color;
import java.awt.Dialog;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import net.proteanit.sql.DbUtils;
import java.io.File;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


   
public class employee extends javax.swing.JFrame {
    
    Connection connection = null;
    ResultSet resp;
    String username;
    public employee(ResultSet res) {
        initComponents();
        resp = res;
        Random rand = new Random();
        int  n = rand.nextInt(50) + 1;
        //JOptionPane.showMessageDialog(null, jText);
        connection = Sqlite.dbConnector();
        try {
            String query = "select Requirement,Money,Bill_status from Bill where username = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            jLabel16.setText(res.getString("Name"));           
            jLabel14.setText(String.valueOf(n));
            jLabel15.setText(res.getString("email"));
            jLabel13.setText(res.getString("address"));
            jLabel20.setText(res.getString("ExtraS"));
            pst.setString(1, res.getString("username"));
            username = res.getString("username");
            
            ResultSet rs = pst.executeQuery();
            jTable1.setEnabled(false);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Profile");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 67, 90, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Active");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setText("License");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setText("Modified On");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setText("Employee Code");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setText("Address");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel11.setText("Email");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, -1, -1));

        jButton1.setBackground(new java.awt.Color(58, 143, 218));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setText("Get Statistics");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 299, -1, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, 220));

        jButton4.setBackground(new java.awt.Color(58, 143, 218));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Add Request");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 150, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 153, 0));
        jLabel13.setText("jLabel10");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 220, 21));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 153, 0));
        jLabel14.setText("jLabel10");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 110, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 153, 0));
        jLabel15.setText("jLabel10");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 250, 21));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 153, 0));
        jLabel16.setText("jLabel10");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 67, 110, 21));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 153, 0));
        jLabel17.setText("YES");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 110, 21));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 153, 0));
        jLabel19.setText("Employee License");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 167, 21));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 153, 0));
        jLabel20.setText("Managerial License");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 335, 21));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginpage/Webp.net-resizeimage.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 127, 147));

        jButton2.setBackground(new java.awt.Color(58, 143, 218));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Log Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginFrame ff=new LoginFrame();
        ff.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Adder adder = null;
        try {
            adder = new Adder(this, true,username);
        } catch (Exception ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        adder.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String query = "select Requirement,Money,Bill_status from Bill where username = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            jTable1.setEnabled(false);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
     
    
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
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
      
        
     
        
        java.awt.EventQueue.invokeLater(new Runnable() {
         
            
            public void run() {
                new employee(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}