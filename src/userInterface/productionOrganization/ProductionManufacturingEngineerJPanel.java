/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.productionOrganization;

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
import userInterface.LoginJPanel;
import business.organization.procurement.*;
import business.organization.production.*;
import javax.swing.JOptionPane;

public class ProductionManufacturingEngineerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductionManufacturingEngineerJPanel
     */
    
    private JPanel userProcessContainer;
    
    private Business business;
    private String userName;
    private ProductionAvailableRawMaterials productionAvailableRawMaterials;
    private ProcurementRawMaterialsDirectory procuremetRawMaterialsDirectory;
    private ProductionAvailableProducts productionAvailableProducts;
    private ProductionOrderDirectory productionOrderDirectory;
    private ProductionOrderStatusDirectory productionOrderStatusDirectory;
    private ProductionProductSpecificationDirectory productionProductSpecificationDirectory;
    private ProcurementOrderDirectory procurementOrderDirectory;
    
    public ProductionManufacturingEngineerJPanel(JPanel userProcessContainer, Business business, String userName) {
        initComponents();
        
        tblManufactureOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManufactureOrderMouseClicked(evt);
            }
        });
        
        tblManufacturingOrderMyQueue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManufacturingOrderMyQueueMouseClicked(evt);
            }
        });
        
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userName = userName;
        
        this.productionAvailableRawMaterials = this.business.getProductionOrganization().getProductionAvailableRawMaterials();    
        this.productionAvailableProducts = this.business.getProductionOrganization().getProductionAvailableProducts();
        this.productionOrderDirectory = this.business.getProductionOrganization().getProductionOrderDirectory();
        this.productionOrderStatusDirectory = this.business.getProductionOrganization().getProductionOrderStatusDirectory();
        this.productionProductSpecificationDirectory = this.business.getProductionOrganization().getProductionProductSpecificationDirectory();
        
        this.procurementOrderDirectory = this.business.getProcurementOrganization().getProcurementOrderDirectory();
        this.procuremetRawMaterialsDirectory = this.business.getProcurementOrganization().getProcurementRawMaterialsDirectory();
        
        populateManufactureOrderTable();
        populateManufacturingOrderMyQueueTable();
    }
    
    
    private void tblManufacturingOrderMyQueueMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRowIndex = tblManufacturingOrderMyQueue.getSelectedRow();
        if (selectedRowIndex >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblManufacturingOrderMyQueue.getModel();
            int orderId = (Integer) model.getValueAt(selectedRowIndex, 0);
            int items = (Integer) model.getValueAt(selectedRowIndex, 1);
            String orderDetails = "Order ID: " + orderId + "\nItems: " + items;
            txtManufacturingOrderDetailsAssignedToMe.setText(orderDetails);
        }
    }
    
    public void populateManufacturingOrderMyQueueTable() {
        DefaultTableModel model = (DefaultTableModel) tblManufacturingOrderMyQueue.getModel();
        model.setRowCount(0);
        for(ProductionOrder productionOrder : this.productionOrderDirectory.getProductionOrderList()) {
            if(productionOrder.getStatus().equals("Production Approved") && productionOrder.getManufactureAssignedTo().equals(this.userName)) {
                int id = productionOrder.getProductionOrderId();
                int items = 0;
                for (Integer quantity : productionOrder.getProductionOrderProducts().values()) {
                    items += quantity;
                }
                String client = "Store";
                String status = productionOrder.getStatus();
                Object[] row = new Object[] {Integer.valueOf(id), Integer.valueOf(items), client, status};
                model.addRow(row);               
            }
        }
        txtManufacturingOrderDetailsAssignedToMe.setText("");
    }
    
    private void tblManufactureOrderMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRowIndex = tblManufactureOrder.getSelectedRow();
        if (selectedRowIndex >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblManufactureOrder.getModel();
            int orderId = (Integer) model.getValueAt(selectedRowIndex, 0);
            int items = (Integer) model.getValueAt(selectedRowIndex, 1);
            String orderDetails = "Order ID: " + orderId + "\nItems: " + items;
            txtManufacturingOrderDetails.setText(orderDetails);
        }
    }
    
    public void populateManufactureOrderTable() {
        DefaultTableModel model = (DefaultTableModel) tblManufactureOrder.getModel();
        model.setRowCount(0);
        for(ProductionOrder productionOrder : this.productionOrderDirectory.getProductionOrderList()) {
            if(productionOrder.getStatus().equals("Production Approved") && productionOrder.getManufactureAssignedTo().equals("NA")) {
                int id = productionOrder.getProductionOrderId();
                int items = 0;
                for (Integer quantity : productionOrder.getProductionOrderProducts().values()) {
                    items += quantity;
                }
                String client = "Store";
                String status = productionOrder.getStatus();
                Object[] row = new Object[] {Integer.valueOf(id), Integer.valueOf(items), client, status};
                model.addRow(row);               
            }
        }
        txtManufacturingOrderDetails.setText("");
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
        tblManufactureOrder = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtManufacturingOrderDetails = new javax.swing.JTextArea();
        btnAssignToMyQueue = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblManufacturingOrderMyQueue = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtManufacturingOrderDetailsAssignedToMe = new javax.swing.JTextArea();
        btnRemoveFromMyQueue = new javax.swing.JButton();
        btnProductionCompleted = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTION ORGANIZATION (MANUFACTURING ENGINEER)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MANUFACTURING ORDER");

        tblManufactureOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Items", "Client", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblManufactureOrder);

        txtManufacturingOrderDetails.setColumns(20);
        txtManufacturingOrderDetails.setRows(5);
        jScrollPane2.setViewportView(txtManufacturingOrderDetails);

        btnAssignToMyQueue.setText("ASSIGN TO MY QUEUE");
        btnAssignToMyQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMyQueueActionPerformed(evt);
            }
        });

        tblManufacturingOrderMyQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Items", "Client", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblManufacturingOrderMyQueue);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MANUFACTURING ORDER (ASSIGNED TO ME)");

        txtManufacturingOrderDetailsAssignedToMe.setColumns(20);
        txtManufacturingOrderDetailsAssignedToMe.setRows(5);
        jScrollPane4.setViewportView(txtManufacturingOrderDetailsAssignedToMe);

        btnRemoveFromMyQueue.setText("REMOVE FROM MY QUEUE");
        btnRemoveFromMyQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromMyQueueActionPerformed(evt);
            }
        });

        btnProductionCompleted.setText("PRODUCTION COMPLETED");
        btnProductionCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductionCompletedActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAssignToMyQueue)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnProductionCompleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRemoveFromMyQueue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnAssignToMyQueue))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnRemoveFromMyQueue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductionCompleted)))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToMyQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMyQueueActionPerformed
        // TODO add your handling code here:
         int selectedRowIndex = tblManufactureOrder.getSelectedRow();
        boolean isRowSelected = selectedRowIndex >= 0;
        if (!isRowSelected) {
            JOptionPane.showMessageDialog(this, "Please select a production order to assign to your queue");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblManufactureOrder.getModel();
        int orderId = (Integer) model.getValueAt(selectedRowIndex, 0);
        ProductionOrder selectedOrder = findProductionOrderById(orderId);
        if (selectedOrder != null) {
            selectedOrder.setManufactureAssignedTo(this.userName);
            JOptionPane.showMessageDialog(this, "Production Order " + orderId + " has been assigned to your queue");
        } else {
            JOptionPane.showMessageDialog(this, "Selected production order not found");
        }
        populateManufactureOrderTable();
        populateManufacturingOrderMyQueueTable();
        txtManufacturingOrderDetails.setText("");
        txtManufacturingOrderDetailsAssignedToMe.setText("");
    }//GEN-LAST:event_btnAssignToMyQueueActionPerformed
    
    
    
    private void btnRemoveFromMyQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromMyQueueActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblManufacturingOrderMyQueue.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a production order to remove from your queue");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblManufacturingOrderMyQueue.getModel();
        int orderId = (Integer) model.getValueAt(selectedRowIndex, 0);
        ProductionOrder selectedOrder = findProductionOrderById(orderId);
        if (selectedOrder != null) {
            selectedOrder.setManufactureAssignedTo("NA");
            JOptionPane.showMessageDialog(this, "Production Order " + orderId + " has been removed from your queue");
            populateManufacturingOrderMyQueueTable();
            populateManufactureOrderTable();
        } else {
            JOptionPane.showMessageDialog(this, "Selected production order not found");
        }
        txtManufacturingOrderDetailsAssignedToMe.setText("");
        txtManufacturingOrderDetails.setText("");
    }//GEN-LAST:event_btnRemoveFromMyQueueActionPerformed
    
    private void btnProductionCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductionCompletedActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblManufacturingOrderMyQueue.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a production order to complete the manufacturing process");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblManufacturingOrderMyQueue.getModel();
        int orderId = (Integer) model.getValueAt(selectedRowIndex, 0);
        ProductionOrder selectedOrder = findProductionOrderById(orderId);
        if (selectedOrder != null) {
            selectedOrder.setStatus("Production Completed");
            this.productionAvailableProducts.processProductionOrder(selectedOrder);
            this.productionAvailableRawMaterials.useRawMaterialsForProduction(selectedOrder, productionProductSpecificationDirectory);
            JOptionPane.showMessageDialog(this, "Manufacturing process completed for production order id =  " + orderId);
        } else {
            JOptionPane.showMessageDialog(this, "Selected production order not found");
        }
        populateManufacturingOrderMyQueueTable();
        populateManufactureOrderTable();
        txtManufacturingOrderDetailsAssignedToMe.setText("");
        txtManufacturingOrderDetails.setText("");
    }//GEN-LAST:event_btnProductionCompletedActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.business.getProductionOrganization().setProductionAvailableRawMaterials(this.productionAvailableRawMaterials);
        this.business.getProductionOrganization().setProductionAvailableProducts(this.productionAvailableProducts);
        this.business.getProductionOrganization().setProductionOrderDirectory(this.productionOrderDirectory);
        this.business.getProductionOrganization().setProductionOrderStatusDirectory(this.productionOrderStatusDirectory);
        this.business.getProductionOrganization().setProductionProductSpecificationDirectory(this.productionProductSpecificationDirectory);
        this.business.getProcurementOrganization().setProcurementOrderDirectory(this.procurementOrderDirectory);
        this.business.getProcurementOrganization().setProcurementRawMaterialsDirectory(this.procuremetRawMaterialsDirectory);
        LoginJPanel panel = new LoginJPanel(userProcessContainer, this.business);
        userProcessContainer.add("LoginJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.business.getProductionOrganization().setProductionAvailableRawMaterials(this.productionAvailableRawMaterials);
        this.business.getProductionOrganization().setProductionAvailableProducts(this.productionAvailableProducts);
        this.business.getProductionOrganization().setProductionOrderDirectory(this.productionOrderDirectory);
        this.business.getProductionOrganization().setProductionOrderStatusDirectory(this.productionOrderStatusDirectory);
        this.business.getProductionOrganization().setProductionProductSpecificationDirectory(this.productionProductSpecificationDirectory);
        this.business.getProcurementOrganization().setProcurementOrderDirectory(this.procurementOrderDirectory);
        this.business.getProcurementOrganization().setProcurementRawMaterialsDirectory(this.procuremetRawMaterialsDirectory);
        LoginJPanel panel = new LoginJPanel(userProcessContainer, this.business);
        userProcessContainer.add("LoginJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnLogoutActionPerformed
    
    private ProductionOrder findProductionOrderById(int orderId) {
        for (ProductionOrder order : productionOrderDirectory.getProductionOrderList()) {
            if (order.getProductionOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMyQueue;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProductionCompleted;
    private javax.swing.JButton btnRemoveFromMyQueue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblManufactureOrder;
    private javax.swing.JTable tblManufacturingOrderMyQueue;
    private javax.swing.JTextArea txtManufacturingOrderDetails;
    private javax.swing.JTextArea txtManufacturingOrderDetailsAssignedToMe;
    // End of variables declaration//GEN-END:variables
}
