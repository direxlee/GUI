/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP745 G3
 */
public class changecontact extends javax.swing.JFrame {

    /**
     * Creates new form changecontact
     */
    public changecontact() {
        initComponents();
    }

  private boolean phoneExists(String phoneNumber) {
    boolean exists = false;
    try {
         connectDB db = new connectDB();
        String query = "SELECT * FROM tbl_user WHERE contact = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, phoneNumber);
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            exists = true;  
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return exists;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cnum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nnum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(63, 84, 67));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 40));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 50, 420));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Change Contact Number");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 250, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Current User ID:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Current Contact:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        cnum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(cnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 250, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("New Contact:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        nnum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(nnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 250, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Cancel");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 355, -1, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Submmit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 355, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 510, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     String currentPhoneText = cnum.getText();  
        String newPhoneText = nnum.getText();


if (currentPhoneText.isEmpty() || newPhoneText.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Both current and new phone numbers are required.");
    return;
}


if (!newPhoneText.matches("\\d+")) {
    JOptionPane.showMessageDialog(null, "Phone number must only contain digits.");
    return;
}

if (newPhoneText.length() > 15 || newPhoneText.length() < 10) {
    JOptionPane.showMessageDialog(null, "Phone number must be between 10 to 15 digits long.");
    return;
}


if (!phoneExists(currentPhoneText)) {
    JOptionPane.showMessageDialog(null, "The current phone number does not exist in the database.");
    return;
}


try {
    connectDB db = new connectDB();
    String query = "UPDATE tbl_user SET contact = ? WHERE id = ?";
    
    PreparedStatement pstmt = db.getConnection().prepareStatement(query);
    pstmt.setString(1, newPhoneText);
    pstmt.setString(2, id.getText()); 

   
    int rowsUpdated = pstmt.executeUpdate();

  
    if (rowsUpdated > 0) {
       
        Session sess = Session.getInstance();  
        sess.setContact(newPhoneText); 

        JOptionPane.showMessageDialog(null, "Phone number updated successfully!");

       
        AdminDash changecontact = new  AdminDash();  
        changecontact.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Phone number update failed. Please try again.");
    }

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating phone number: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changecontact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changecontact().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cnum;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nnum;
    // End of variables declaration//GEN-END:variables
}
