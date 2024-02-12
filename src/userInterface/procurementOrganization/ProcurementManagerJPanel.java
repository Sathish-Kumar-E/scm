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

public class ProcurementManagerJPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form ProcurementManagerJPanel
     */
    
    private JPanel userProcessContainer;
    private String username;
    
    private Business business;
    private ProcurementAvailableRawMaterials procurementAvailableRawMaterials;
    private ProcurementRawMaterialsDirectory procurementRawMaterialsDirectory;
    private ProcurementOrderDirectory procurementOrderDirectory;
    
    
    public ProcurementManagerJPanel(JPanel userProcessContainer, Business business, String username) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.username = username;
        this.business = business;
        this.procurementAvailableRawMaterials = this.business.getProcurementOrganization().getProcurementAvailableRawMaterials();
        this.procurementRawMaterialsDirectory = this.business.getProcurementOrganization().getProcurementRawMaterialsDirectory();
        this.procurementOrderDirectory = this.business.getProcurementOrganization().getProcurementOrderDirectory();
        
        comboBoxProcurementOrderStatus.removeAllItems();
        for(ProcurementOrderStatus pos : this.business.getProcurementOrganization().getProcurementOrderStatusDirectory().getProcurementOrderStatusList()) {
            comboBoxProcurementOrderStatus.addItem(pos.getName());
        }
        
        comboBoxProcurementOrderStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProcurementOrderStatusActionPerformed(evt);
            }
        });
        
        populateRawMaterialNameComboBox();
        populateRawMterialsTable();
        populateProcurementOrderTable((String) comboBoxProcurementOrderStatus.getSelectedItem());
        
        tblProcurementOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProcurementOrderMouseClicked(evt);
            }
        });
    }
    
    
    private void tblProcurementOrderMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRowIndex = tblProcurementOrder.getSelectedRow();
        if (selectedRowIndex >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblProcurementOrder.getModel();
            ProcurementOrder selectedOrder = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
            StringBuilder orderDetails = new StringBuilder();
            //orderDetails.append("Order ID : ").append(selectedOrder.getProcurementOrderId()).append("; ");
            //orderDetails.append("Status : ").append(selectedOrder.getStatus()).append("; ");
            orderDetails.append("Procurement Order Items :\n");
            HashMap<String, Integer> rawMaterials = selectedOrder.getProcurementOrder();
            for (Map.Entry<String, Integer> entry : rawMaterials.entrySet()) {
                orderDetails.append(entry.getKey()).append(" = ").append(entry.getValue()).append("; ");
            }
            if (orderDetails.length() > 2) {
                orderDetails.setLength(orderDetails.length() - 2);
            }
            txtProcurementOrderDetails.setText(orderDetails.toString());
        }
    }
    
    private void comboBoxProcurementOrderStatusActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedStatus = (String) comboBoxProcurementOrderStatus.getSelectedItem();
        populateProcurementOrderTable(selectedStatus);
        boolean isInitiated = "Initiated".equals(selectedStatus);
        btnApproveOrder.setEnabled(isInitiated);
        btnRejectOrder.setEnabled(isInitiated);
    }
    
    public void populateRawMaterialNameComboBox(){
        comboBoxRawMaterialName.removeAllItems();
        for(ProcurementRawMaterial procurementRawMaterial : this.procurementRawMaterialsDirectory.getProcurementRawMaterialsList()) {
            comboBoxRawMaterialName.addItem(procurementRawMaterial.getRawMaterialName());
        }
    }
    
    public void populateRawMterialsTable() {
        DefaultTableModel model = (DefaultTableModel) tblProcurementAvailableRawMaterials.getModel();
        model.setRowCount(0);
        for (Map.Entry<String, Integer> entry : procurementAvailableRawMaterials.getProcurementAvailableRawMaterials().entrySet()) {
            String rawMaterialName = entry.getKey();
            Integer availableUnits = entry.getValue();
            Integer pricePerUnit = 0;
            Object[] row = new Object[]{rawMaterialName, availableUnits};
            model.addRow(row);
        } 
    }
    
    public void populateProcurementOrderTable(String statusName) {
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrder.getModel();
        model.setRowCount(0);
        for (ProcurementOrder procurementOrder : this.procurementOrderDirectory.getProcurementOrderList()) {
            String procurementStatus = procurementOrder.getStatus();
            if (statusName == null || statusName.isEmpty() || procurementStatus.equals(statusName)) {
                HashMap<String, Integer> rawMaterials = procurementOrder.getProcurementOrder();
                int itemsCount = 0;
                for (Integer count : rawMaterials.values()) {
                    itemsCount += count;
                }
                int price = procurementOrder.getProcurementOrderPrice();
                Object[] row = new Object[]{procurementOrder, itemsCount, procurementStatus, price};
                model.addRow(row);    
            }
        }
        txtProcurementOrderDetails.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcurementAvailableRawMaterials = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboBoxRawMaterialName = new javax.swing.JComboBox<>();
        rawMaterialCount = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnManageRawMaterial = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProcurementOrder = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtProcurementOrderDetails = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnApproveOrder = new javax.swing.JButton();
        btnRejectOrder = new javax.swing.JButton();
        comboBoxProcurementOrderStatus = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROCUREMENT ORGANIZATION");

        tblProcurementAvailableRawMaterials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material Name", "Available Units"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProcurementAvailableRawMaterials);

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AVAILABLE RAW MATERIALS");

        comboBoxRawMaterialName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxRawMaterialName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRawMaterialNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Raw Material Name");

        jLabel4.setText("Count");

        btnManageRawMaterial.setText("SUBMIT");
        btnManageRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRawMaterialActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MANAGE RAW MATERIALS");

        tblProcurementOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Items", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProcurementOrder);

        txtProcurementOrderDetails.setColumns(20);
        txtProcurementOrderDetails.setRows(5);
        jScrollPane3.setViewportView(txtProcurementOrderDetails);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PROCUREMENT ORDER");

        btnApproveOrder.setText("APPROVE ORDER");
        btnApproveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveOrderActionPerformed(evt);
            }
        });

        btnRejectOrder.setText("REJECT ORDER");
        btnRejectOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectOrderActionPerformed(evt);
            }
        });

        comboBoxProcurementOrderStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 310, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addGap(288, 288, 288))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxRawMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rawMaterialCount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnManageRawMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnApproveOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRejectOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxProcurementOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBack, btnLogout});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout)
                    .addComponent(btnBack))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxProcurementOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnApproveOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRejectOrder)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnManageRawMaterial)
                                    .addComponent(rawMaterialCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxRawMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 132, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel6});

    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxRawMaterialNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRawMaterialNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboBoxRawMaterialNameActionPerformed
    
    private void btnManageRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRawMaterialActionPerformed
        String rawMaterialName = (String) comboBoxRawMaterialName.getSelectedItem();
        Object spinnerValue = rawMaterialCount.getValue();
        int count = (int) spinnerValue;
        this.procurementAvailableRawMaterials.addRawMaterial(rawMaterialName, count);
        populateRawMterialsTable();
    }//GEN-LAST:event_btnManageRawMaterialActionPerformed

    private void btnApproveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveOrderActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProcurementOrder.getSelectedRow();
            if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a procurement order to approve");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrder.getModel();
        ProcurementOrder selectedOrder = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
        if (!procurementAvailableRawMaterials.checkProcurementOrder(selectedOrder)) {
            JOptionPane.showMessageDialog(this, "There are not sufficient raw materials to process the procurement order with id = " + selectedOrder.getProcurementOrderId());
            return;
        }
        selectedOrder.setStatus("Procurement Approved");
        JOptionPane.showMessageDialog(this, "Procurement order with id = " + selectedOrder.getProcurementOrderId() + " has been approved");
        populateProcurementOrderTable("Initiated");  // Assuming this method refreshes the procurement order table
    }//GEN-LAST:event_btnApproveOrderActionPerformed
    
    
    private void btnRejectOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectOrderActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProcurementOrder.getSelectedRow();
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a procurement order to reject");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProcurementOrder.getModel();
        ProcurementOrder p = (ProcurementOrder) model.getValueAt(selectedRowIndex, 0);
        for(ProcurementOrder po : this.procurementOrderDirectory.getProcurementOrderList()) {
            if(p.getProcurementOrderId()==po.getProcurementOrderId()) {
                po.setStatus("Procurement Rejected");
                JOptionPane.showMessageDialog(this, "Procurement order with id = " + po.getProcurementOrderId() + " has been rejected");
                System.out.println(this.procurementOrderDirectory.getProcurementOrderList().get(0).getStatus());
                return;
            }
        }
        populateProcurementOrderTable("Initiated");
    }//GEN-LAST:event_btnRejectOrderActionPerformed
    
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
    private javax.swing.JButton btnApproveOrder;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageRawMaterial;
    private javax.swing.JButton btnRejectOrder;
    private javax.swing.JComboBox<String> comboBoxProcurementOrderStatus;
    private javax.swing.JComboBox<String> comboBoxRawMaterialName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner rawMaterialCount;
    private javax.swing.JTable tblProcurementAvailableRawMaterials;
    private javax.swing.JTable tblProcurementOrder;
    private javax.swing.JTextArea txtProcurementOrderDetails;
    // End of variables declaration//GEN-END:variables
}
