/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import code.DBConnect;
import static interfaces.FoodItemControl.onlySeller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DeleteItem extends javax.swing.JFrame {

    /**
     * Creates new form DeleteItem
     */
    String email;
    Connection con = null;
    PreparedStatement pst1 = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst3 = null;
    PreparedStatement pst4 = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    ArrayList list = new ArrayList();
    ArrayList shouldDeleteList = new ArrayList();
    int sellerID;
    String item;
    int availability;
    String isDel = "deleted";
    String isNotDel = "not deleted";
    
    public DeleteItem() throws ClassNotFoundException, SQLException {
        initComponents();
        email = FoodItemControl.email;
        con = DBConnect.connection();
        setSellerID();
        setTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        foodItemControlButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delete Item");

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iten name", "delete status", "delete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemTable);

        jLabel1.setText("Item list");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        foodItemControlButton.setText("Food Item Control");
        foodItemControlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodItemControlButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodItemControlButton)
                    .addComponent(deleteButton))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profileButton)
                        .addGap(33, 33, 33)
                        .addComponent(foodItemControlButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        setShouldDeleteList();
        String query = "UPDATE items SET deletestatus = ? WHERE (itemname = ? AND sellerID = ?)";
        String x;
        
        for(int i=0;i<shouldDeleteList.size();i++){
            x = (String) shouldDeleteList.get(i);
            try {
                pst3 = con.prepareStatement(query);
                pst3.setString(1, isDel);
                pst3.setString(2, x);
                pst3.setInt(3, sellerID);
                pst3.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MakeItemAvailable.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        JOptionPane.showMessageDialog(null, "Deleted Succesfully");
        FoodItemControl fic = new FoodItemControl();
        fic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        if(onlySeller){
            sellerProfile sp;
            try {
                sp = new sellerProfile();
                sp.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            customerSellerProfile csp;
            try {
                csp = new customerSellerProfile();
                csp.setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_profileButtonActionPerformed

    private void foodItemControlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodItemControlButtonActionPerformed
        FoodItemControl fic = new FoodItemControl();
        fic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_foodItemControlButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void setSellerID() throws SQLException{
        
        String query;
        query = "SELECT sellerID FROM sellers WHERE email = ?";
        pst1 = con.prepareStatement(query);
        pst1.setString(1, email);
        rs1 = pst1.executeQuery();
        if(rs1.next()){
            sellerID = rs1.getInt("sellerID");
        }
    }
    
    private void setTable() throws SQLException{
        String query;
        query = "SELECT itemname FROM items WHERE (sellerID = ? AND deletestatus = ?)";
        pst2 = con.prepareStatement(query);
        pst2.setInt(1, sellerID);
        pst2.setString(2, isNotDel);
        rs2 = pst2.executeQuery();
        while(rs2.next()){
            list.add(rs2.getString("itemname"));
        }
        
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        Object rowData[] = new Object[3];
        
        for(int i=0;i<list.size();i++){
            rowData[0] = list.get(i);
            rowData[1] = isNotDel;
            rowData[2] = false;
            model.addRow(rowData);
        }
    }
    
    private void setShouldDeleteList(){
        String x;
        for(int i=0;i<itemTable.getRowCount();i++){
            if((Boolean) itemTable.getModel().getValueAt(i, 2)){
                x = (String) itemTable.getModel().getValueAt(i, 0);
                shouldDeleteList.add(x);
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DeleteItem().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton foodItemControlButton;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton profileButton;
    // End of variables declaration//GEN-END:variables
}
