/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import authentication.Login;
import config.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author HP745 G3
 */
public class adduser extends javax.swing.JFrame {

    /**
     * Creates new form adduser
     */
    public adduser() {
        initComponents();
    }
     private boolean isEmailValid(String email) {
     
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
      
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static String email1,username1;
     public boolean duplicateChecker() {
    connectDB db = new connectDB();
    boolean isDuplicate = false;

    try {
        String query = "SELECT username, email FROM tbl_users WHERE username = ? OR email = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, username.getText());
        pstmt.setString(2, em.getText());
        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) { 
            String existingEmail = resultSet.getString("email");
            String existingUsername = resultSet.getString("username");

            if (existingEmail.equals(em.getText())) {
                JOptionPane.showMessageDialog(null, "Email is Already Used");
                em.setText("");
                isDuplicate = true;
            }
            if (existingUsername.equals(username.getText())) {
                JOptionPane.showMessageDialog(null, "Username is Already Used");
                username.setText("");
                isDuplicate = true;
            }
        }

        resultSet.close();
        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return isDuplicate;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        us = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ut = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cpass = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo00_1.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 170, 110));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setText("DOCUMENTS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 190, 40));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setText("BARANGAY");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 170, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 110));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Username"));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 170, 60));

        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "First Name"));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 170, 60));

        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Last Name"));
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 170, 60));

        em.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Email"));
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 170, 60));

        pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Password"));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 170, 60));

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel1.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 180, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("User Type");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Secretary", "Admin" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel1.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 180, 60));

        jLabel5.setText("Status Type");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("New User");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        cpass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Confirm Password"));
        jPanel1.add(cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 170, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 800, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         connectDB db = new connectDB();

        if(username.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() || em.getText().isEmpty()
            || pass.getText().isEmpty() || username.getText().isEmpty()){ 
            JOptionPane.showMessageDialog(null, "All fields required");

        }else if(!isEmailValid(em.getText())){
            JOptionPane.showMessageDialog(null, "Your email format is invalid, Please Try again!");
        }else if(duplicateChecker()){
            System.out.println("Duplicate Existed");
       
        }else if(pass.getText().length() < 8){

            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
        }else if(!pass.getText().equals(username.getText())){

            JOptionPane.showMessageDialog(null, "Password not Matches");
        }else if (db.insertData("INSERT INTO tbl_users(username, fname, lname, email, type, pass, cpass, status) "
                + "VALUES ('"+username.getText()+"', '"+fname.getText()+"', '"+lname.getText()+"', '"+em.getText()+"', '"+ut.getSelectedItem()+"', '"+pass.getText()+"', "
                        + "'"+username.getText()+"', '"+us.getSelectedItem()+"')") > 0 ) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }else{
            
            JOptionPane.showMessageDialog(null, "Submitted Successfuly");
            Login adduser = new Login();
            adduser.setVisible(true);
            this.dispose();
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
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adduser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpass;
    private javax.swing.JTextField em;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField pass;
    public javax.swing.JComboBox<String> us;
    private javax.swing.JTextField username;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
