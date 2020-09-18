/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import code.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class log extends javax.swing.JFrame {

        String enteredUsername = null;
        String enteredPassword = null;
        Connection con = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        public static String loggedUserName = null;
        public static String loggedEmail = null;
        public static String loggedMobileNumber = null;
    /**
     * Creates new form log
     * @throws java.lang.ClassNotFoundException
     */
    public log() throws ClassNotFoundException {
        
        con = DBConnect.connection();
        
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

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameBox = new javax.swing.JTextField();
        passwordBox = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        showPasswordCheckBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        forgotPasswordButton = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setText("User name ");

        jLabel2.setText("password");

        passwordBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordBoxActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        showPasswordCheckBox.setText("Show Password");
        showPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Fogot password");

        forgotPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameBox)
                            .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(loginButton)))
                        .addGap(29, 29, 29)
                        .addComponent(showPasswordCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(forgotPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPasswordCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(forgotPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordBoxActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        enteredUsername = usernameBox.getText();
        enteredPassword = new String(passwordBox.getPassword());
        try {
            getLogValues();
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void showPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckBoxActionPerformed
        if(showPasswordCheckBox.isSelected()){
            passwordBox.setEchoChar((char)0);
        }
        else{
            passwordBox.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordCheckBoxActionPerformed

    private void forgotPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordButtonActionPerformed
        ChangePassword cp;
            try {
                cp = new ChangePassword();
                cp.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_forgotPasswordButtonActionPerformed

    public void getLogValues() throws SQLException, ClassNotFoundException{
        String quary1;
        String quary2;
        Boolean cus;
        Boolean sel;
        
        try{
        quary1 = "SELECT * FROM customers WHERE username = ? AND password = ?";
        quary2 = "SELECT * FROM sellers WHERE username = ? AND password = ?";
        
        pst1 = con.prepareStatement(quary1);
        pst1.setString(1, enteredUsername);
        pst1.setString(2, enteredPassword);
        rs1 = pst1.executeQuery();
        
        pst2 = con.prepareStatement(quary2);
        pst2.setString(1, enteredUsername);
        pst2.setString(2, enteredPassword);
        rs2 = pst2.executeQuery();
        
        cus = rs1.next();
        sel = rs2.next();
        
        if(sel&&cus){
            System.out.println("cus sel");
            //it is a seller and also customer
            loggedUserName = rs2.getString("username");
            loggedEmail = rs2.getString("email");
            loggedMobileNumber = rs2.getString("mobilenumber");
            customerSellerProfile.username = loggedUserName;
            customerSellerProfile.email = loggedEmail;
            customerSellerProfile.mobileNumber = loggedMobileNumber;
            customerSellerProfile csp = new customerSellerProfile();
            csp.setVisible(true);
            this.dispose();
        }
        
        else if(cus){
            System.out.println("cus");
            //it is a customer
            loggedUserName = rs1.getString("username");
            loggedEmail = rs1.getString("email");
            loggedMobileNumber = rs1.getString("mobilenumber");
            customerProfile.username = loggedUserName;
            customerProfile.email = loggedEmail;
            customerProfile.mobilenumber = loggedMobileNumber;
            customerProfile cp = new customerProfile();
            cp.setVisible(true);
            this.dispose();

        }
        
        else if(sel){
            System.out.println("sel");
            //it is a seller
            loggedUserName = rs2.getString("username");
            loggedEmail = rs2.getString("email");
            loggedMobileNumber = rs2.getString("mobilenumber");
            sellerProfile.username = loggedUserName;
            sellerProfile.email = loggedEmail;
            sellerProfile.mobilenumber = loggedMobileNumber;
            sellerProfile sp = new sellerProfile();
            sp.setVisible(true);
            this.dispose();
        }
        
        }
        
        catch(SQLException e){
            System.out.println(e);
        }
        
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
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new log().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotPasswordButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordBox;
    private javax.swing.JCheckBox showPasswordCheckBox;
    private javax.swing.JTextField usernameBox;
    // End of variables declaration//GEN-END:variables
}
