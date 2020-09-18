/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class OrderList extends javax.swing.JFrame {

    /**
     * Creates new form OrderList
     */
    ArrayList totalPrice = new ArrayList();
    int tot=0;
    
    public OrderList() {
        initComponents();
        
        setTotal();
        totalBox.setText(String.valueOf(tot));
        DefaultTableModel model = (DefaultTableModel) listTable.getModel();
        setTable(model);
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
        listTable = new javax.swing.JTable();
        totalBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order List");

        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seller name", "Item name", "no of item ", "total price", "Remove"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listTable);

        totalBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Total of total");

        removeButton.setText("Remove Selected");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(totalBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(removeButton)
                        .addGap(31, 31, 31)
                        .addComponent(okButton)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(okButton))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBoxActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) listTable.getModel();
        int total=0;
        int removingIndex;
        
        for(int i=0;i<model.getRowCount();i++){
            if((Boolean) listTable.getModel().getValueAt(i, 4)){
                removingIndex = AddOrder.o.sellerName.indexOf(listTable.getModel().getValueAt(i, 0));
                AddOrder.o.sellerName.remove(removingIndex);
                AddOrder.o.itemName.remove(removingIndex);
                AddOrder.o.price.remove(removingIndex);
                AddOrder.o.noOfItem.remove(removingIndex);
                AddOrder.o.selID.remove(removingIndex);
                AddOrder.o.iID.remove(removingIndex);
                model.removeRow(i);
            }
        }
        for(int i=0;i<model.getRowCount();i++){
            total = total + Integer.parseInt(String.valueOf(listTable.getModel().getValueAt(i, 3)));
        }
        totalBox.setText(String.valueOf(total));
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    private void setTotal(){
        int x;
        for(int i=0;i<AddOrder.o.price.size();i++){
            x = Integer.parseInt(String.valueOf(AddOrder.o.price.get(i)))*Integer.parseInt(String.valueOf(AddOrder.o.noOfItem.get(i)));
            AddOrder.o.totalPrice.add(x);
            totalPrice.add(x);
            tot = tot + x;
        }
    }
    
    private void setTable(DefaultTableModel model){
        Object rowData[] = new Object[5];
        for(int i=0;i<AddOrder.o.itemName.size();i++){
            rowData[0] = AddOrder.o.sellerName.get(i);
            rowData[1] = AddOrder.o.itemName.get(i);
            rowData[2] = AddOrder.o.noOfItem.get(i);
            rowData[3] = totalPrice.get(i);
            rowData[4] = false;
            model.addRow(rowData); 
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
            java.util.logging.Logger.getLogger(OrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listTable;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField totalBox;
    // End of variables declaration//GEN-END:variables
}
