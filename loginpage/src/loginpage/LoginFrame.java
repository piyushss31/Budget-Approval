
package loginpage;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {
    
    Connection connection = null;
    
    public LoginFrame() {
        initComponents();
        connection = Sqlite.dbConnector();
        ImageIcon icon = new ImageIcon("/img/back1.jpg"); 
        //jLabel5.setBackground(Color.yellow);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("User Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 259, 60));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 211, 35));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 201, 47));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 211, 37));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1373, 0, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, -1, 613));

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("SignUp");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 201, 47));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try{
            String query = "select * from Managerdb where username= ? and password= ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,jTextField1.getText());
            pst.setString(2, jPasswordField1.getText());

            ResultSet rs = pst.executeQuery();

            int count = 0;
            while(rs.next())
            {
                count++;
            }
            if(count==1)
            {
                rs = pst.executeQuery();
                dispose();
                try{
                    //JOptionPane.showMessageDialog(null, rs.getBoolean("isManager"));
                    if(rs.getString("isManager").equals("1"))
                    {
                        managerlogin man = new managerlogin(rs);
                        man.setVisible(true);
                    }
                    else
                    {
                        employee emp = new employee(rs);
                        emp.setVisible(true);
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
                pst.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username or Password incorrect");

                jTextField1.setText("");
                jPasswordField1.setText("");
                pst.close();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try {
                connection.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        dispose();
        signup page = new signup();
        page.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
