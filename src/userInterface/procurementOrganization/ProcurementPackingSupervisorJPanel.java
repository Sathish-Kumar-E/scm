/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.procurementOrganization;

/**
 *
 * @author sathi
 */

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;

import userInterface.Business;
import business.organization.procurement.*;
import javax.swing.JOptionPane;
import userInterface.LoginJPanel;

public class ProcurementPackingSupervisorJPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form ProcurementPackingSupervisorJPanel
     */
    
    private JPanel userProcessContainer;
    
    private String userName;
    private Business business;
    private ProcurementAvailableRawMaterials procurementAvailableRawMaterials;
    private ProcurementRawMaterialsDirectory procurementRawMaterialsDirectory;
    private ProcurementOrderDirectory procurementOrderDirectory;
    
    public ProcurementPackingSupervisorJPanel(JPanel userProcessContainer, Business business, String userName) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userName = userName;
        this.business = business;
        this.procurementAvailableRawMaterials = this.business.getProcurementOrganization().getProcurementAvailableRawMaterials();
        this.procurementRawMaterialsDirectory = this.business.getProcurementOrganization().getProcurementRawMaterialsDirectory();
        this.procurementOrderDirectory = this.business.getProcurementOrganization().getProcurementOrderDirectory();
        populateProcurementOrderTableAllOrder();
        populateProcurementOrderTableMyQueue(this.userName);
        tblProcurementOrderAllOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProcurementOrderAllOrderMouseClicked(evt);
            }
        });
        tblProcurementOrderMyQueue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProcurementOrderMyQueueMouseClicked(evt);
            }
        });
    }
    
    public void populateProcurementOrderTableAllOrder() {
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrderAllOrder.getModel();
        model.setRowCount(0);
        for(ProcurementOrder procurementOrder : this.procurementOrderDirectory.getProcurementOrderList()) {
            if(procurementOrder.getStatus().equals("Procurement Approved")) {
                HashMap<String, Integer> rawMaterials = procurementOrder.getProcurementOrder();
                int itemsCount = 0;
                for (Integer count : rawMaterials.values()) {
                    itemsCount += count;
                }
                int price = procurementOrder.getProcurementOrderPrice();
                Object[] row = new Object[]{procurementOrder, itemsCount, procurementOrder.getStatus(), price};
                if(procurementOrder.getProcurementPackingAssignedTo().equals("Not Assigned Yet")) {
                    model.addRow(row);
                }
            }
        }
    }
    
    public void populateProcurementOrderTableMyQueue(String userName) {
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrderMyQueue.getModel();
        model.setRowCount(0);
        for(ProcurementOrder procurementOrder : this.procurementOrderDirectory.getProcurementOrderList()) {
            if(procurementOrder.getStatus().equals("Procurement Approved")) {
                HashMap<String, Integer> rawMaterials = procurementOrder.getProcurementOrder();
                int itemsCount = 0;
                for (Integer count : rawMaterials.values()) {
                    itemsCount += count;
                }
                int price = procurementOrder.getProcurementOrderPrice();
                Object[] row = new Object[]{procurementOrder, itemsCount, procurementOrder.getStatus(), price};
                if(procurementOrder.getProcurementPackingAssignedTo().equals(userName)) {
                    model.addRow(row); 
                }
            }
        }
    }
    
    private void tblProcurementOrderAllOrderMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRowIndex = tblProcurementOrderAllOrder.getSelectedRow();
        if (selectedRowIndex >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblProcurementOrderAllOrder.getModel();
            ProcurementOrder selectedOrder = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
            StringBuilder orderDetails = new StringBuilder();
            orderDetails.append("Procurement Order Items :\n");
            HashMap<String, Integer> rawMaterials = selectedOrder.getProcurementOrder();
            for (Map.Entry<String, Integer> entry : rawMaterials.entrySet()) {
                orderDetails.append(entry.getKey()).append(" = ").append(entry.getValue()).append("; ");
            }
            if (orderDetails.length() > 2) {
                orderDetails.setLength(orderDetails.length() - 2);
            }
            txtProcurementOrderDetailsAllOrder.setText(orderDetails.toString());
        }
    }
    
    private void tblProcurementOrderMyQueueMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRowIndex = tblProcurementOrderMyQueue.getSelectedRow();
        if (selectedRowIndex >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblProcurementOrderMyQueue.getModel();
            ProcurementOrder selectedOrder = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
            StringBuilder orderDetails = new StringBuilder();
            orderDetails.append("Procurement Order Items :\n");
            HashMap<String, Integer> rawMaterials = selectedOrder.getProcurementOrder();
            for (Map.Entry<String, Integer> entry : rawMaterials.entrySet()) {
                orderDetails.append(entry.getKey()).append(" = ").append(entry.getValue()).append("; ");
            }
            if (orderDetails.length() > 2) {
                orderDetails.setLength(orderDetails.length() - 2);
            }
            txtProcurementOrderDetailsMyQueue.setText(orderDetails.toString());
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcurementOrderAllOrder = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProcurementOrderDetailsAllOrder = new javax.swing.JTextArea();
        btnAssignToMyQueue = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProcurementOrderMyQueue = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtProcurementOrderDetailsMyQueue = new javax.swing.JTextArea();
        btnRemoveFromMyQueue = new javax.swing.JButton();
        btnPackingComplete = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROCUREMENT ORGANIZATION (PROCUREMENT PACKING SUPERVISOR)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ALL PROCUREMENT ORDER");

        tblProcurementOrderAllOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Items", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProcurementOrderAllOrder);

        txtProcurementOrderDetailsAllOrder.setColumns(20);
        txtProcurementOrderDetailsAllOrder.setRows(5);
        jScrollPane2.setViewportView(txtProcurementOrderDetailsAllOrder);

        btnAssignToMyQueue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAssignToMyQueue.setText("ASSIGN TO MY QUEUE");
        btnAssignToMyQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMyQueueActionPerformed(evt);
            }
        });

        tblProcurementOrderMyQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Items", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProcurementOrderMyQueue);

        txtProcurementOrderDetailsMyQueue.setColumns(20);
        txtProcurementOrderDetailsMyQueue.setRows(5);
        jScrollPane4.setViewportView(txtProcurementOrderDetailsMyQueue);

        btnRemoveFromMyQueue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemoveFromMyQueue.setText("REMOVE FROM MY QUEUE");
        btnRemoveFromMyQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromMyQueueActionPerformed(evt);
            }
        });

        btnPackingComplete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPackingComplete.setText("PACKING COMPLETED");
        btnPackingComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPackingCompleteActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAssignToMyQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnRemoveFromMyQueue, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                            .addComponent(btnPackingComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignToMyQueue)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRemoveFromMyQueue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPackingComplete)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToMyQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMyQueueActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProcurementOrderAllOrder.getSelectedRow();
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a procurement order to assign");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrderAllOrder.getModel();
        ProcurementOrder p = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
        for(ProcurementOrder po : this.procurementOrderDirectory.getProcurementOrderList()) {
            if(p.getProcurementOrderId()==po.getProcurementOrderId()) {
                po.setProcurementPackingAssignedTo(this.userName);
                JOptionPane.showMessageDialog(this, "Procurement order with id = " + po.getProcurementOrderId() + " has been assigned to you");
            }
        }
        populateProcurementOrderTableAllOrder();
        populateProcurementOrderTableMyQueue(this.userName);
        txtProcurementOrderDetailsAllOrder.setText("");
        txtProcurementOrderDetailsMyQueue.setText("");
    }//GEN-LAST:event_btnAssignToMyQueueActionPerformed

    private void btnRemoveFromMyQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromMyQueueActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProcurementOrderMyQueue.getSelectedRow();
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a procurement order to remove from your queue");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrderMyQueue.getModel();
        ProcurementOrder p = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
        for(ProcurementOrder po : this.procurementOrderDirectory.getProcurementOrderList()) {
            if(p.getProcurementOrderId()==po.getProcurementOrderId()) {
                po.setProcurementPackingAssignedTo("Not Assigned Yet");
                JOptionPane.showMessageDialog(this, "Procurement order with id = " + po.getProcurementOrderId() + " has been removed from your queue");
            }
        }
        populateProcurementOrderTableAllOrder();
        populateProcurementOrderTableMyQueue(this.userName);
        txtProcurementOrderDetailsAllOrder.setText("");
        txtProcurementOrderDetailsMyQueue.setText("");
    }//GEN-LAST:event_btnRemoveFromMyQueueActionPerformed

    private void btnPackingCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPackingCompleteActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProcurementOrderMyQueue.getSelectedRow();
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a procurement order to complete the packing");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrderMyQueue.getModel();
        ProcurementOrder p = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
        for(ProcurementOrder po : this.procurementOrderDirectory.getProcurementOrderList()) {
            if(p.getProcurementOrderId()==po.getProcurementOrderId()) {
                po.setStatus("Packing Completed");
                po.setProcurementPackingCompletedBy(this.userName);
                this.procurementAvailableRawMaterials.processProcurementOrder(po);
                JOptionPane.showMessageDialog(this, "Packing has been completed for the procurement order with id = " + po.getProcurementOrderId());
            }
        }
        populateProcurementOrderTableAllOrder();
        populateProcurementOrderTableMyQueue(this.userName);
        txtProcurementOrderDetailsAllOrder.setText("");
        txtProcurementOrderDetailsMyQueue.setText("");
    }//GEN-LAST:event_btnPackingCompleteActionPerformed
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.business.getProcurementOrganization().setProcurementOrderDirectory(this.procurementOrderDirectory);
        this.business.getProcurementOrganization().setProcurementRawMaterialsDirectory(this.procurementRawMaterialsDirectory);
        this.business.getProcurementOrganization().setProcurementAvailableRawMaterials(this.procurementAvailableRawMaterials);
        LoginJPanel panel = new LoginJPanel(userProcessContainer, this.business);
        userProcessContainer.add("LoginJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed
    
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.business.getProcurementOrganization().setProcurementOrderDirectory(this.procurementOrderDirectory);
        this.business.getProcurementOrganization().setProcurementRawMaterialsDirectory(this.procurementRawMaterialsDirectory);
        this.business.getProcurementOrganization().setProcurementAvailableRawMaterials(this.procurementAvailableRawMaterials);
        LoginJPanel panel = new LoginJPanel(userProcessContainer, this.business);
        userProcessContainer.add("LoginJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnLogoutActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMyQueue;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPackingComplete;
    private javax.swing.JButton btnRemoveFromMyQueue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblProcurementOrderAllOrder;
    private javax.swing.JTable tblProcurementOrderMyQueue;
    private javax.swing.JTextArea txtProcurementOrderDetailsAllOrder;
    private javax.swing.JTextArea txtProcurementOrderDetailsMyQueue;
    // End of variables declaration//GEN-END:variables
}
