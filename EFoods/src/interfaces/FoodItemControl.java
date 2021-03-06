/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FoodItemControl extends javax.swing.JFrame {

    /**
     * Creates new form FoodItemControl
     */
    public static String email;
    public static Boolean onlySeller;
        
    public FoodItemControl() {
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

        addButton = new javax.swing.JButton();
        availableButton = new javax.swing.JButton();
        unavailableButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Item Control");

        addButton.setText("Add Food Item");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        availableButton.setText("Make Food Items Available");
        availableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableButtonActionPerformed(evt);
            }
        });

        unavailableButton.setText("Make Food Items Unavailable");
        unavailableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unavailableButtonActionPerformed(evt);
            }
        });

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete  Item");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(profileButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unavailableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(availableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(profileButton)
                .addGap(46, 46, 46)
                .addComponent(addButton)
                .addGap(40, 40, 40)
                .addComponent(availableButton)
                .addGap(40, 40, 40)
                .addComponent(unavailableButton)
                .addGap(40, 40, 40)
                .addComponent(deleteButton)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddItem ai;
        try {
            ai = new AddItem();
            ai.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        if(onlySeller){
            sellerProfile sp;
            try {
                sp = new sellerProfile();
                sp.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FoodItemControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            customerSellerProfile csp;
            try {
                csp = new customerSellerProfile();
                csp.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FoodItemControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_profileButtonActionPerformed

    private void availableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableButtonActionPerformed
        MakeItemAvailable mia;
        try {
            mia = new MakeItemAvailable();
            mia.setVisible(true);
            this.dispose();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FoodItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_availableButtonActionPerformed

    private void unavailableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unavailableButtonActionPerformed
        try {
            MakeItemUnavailable miu = new MakeItemUnavailable();
            miu.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FoodItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_unavailableButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            DeleteItem di = new DeleteItem();
            di.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FoodItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FoodItemControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodItemControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodItemControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodItemControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodItemControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton availableButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton unavailableButton;
    // End of variables declaration//GEN-END:variables
}
