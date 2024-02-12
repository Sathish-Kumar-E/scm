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
import business.organization.procurement.*;
import business.organization.production.*;
import javax.swing.JOptionPane;
import userInterface.LoginJPanel;

public class ProductionManagerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductionManagerJPanel
     */
    
    private JPanel userProcessContainer;
    
    private Business business;
    private ProductionAvailableRawMaterials productionAvailableRawMaterials;
    private ProcurementRawMaterialsDirectory procuremetRawMaterialsDirectory;
    private ProductionAvailableProducts productionAvailableProducts;
    private ProductionOrderDirectory productionOrderDirectory;
    private ProductionOrderStatusDirectory productionOrderStatusDirectory;
    private ProductionProductSpecificationDirectory productionProductSpecificationDirectory;
    private ProcurementOrderDirectory procurementOrderDirectory;
    
    public ProductionManagerJPanel(JPanel userProcessContainer, Business business, String userName) {
        initComponents();
        
        comboBoxProductionOrderStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProductionOrderStatusActionPerformed(evt);
            }
        });
        
        tblProductionOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductionOrderMouseClicked(evt);
            }
        });
        
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        
        this.productionAvailableRawMaterials = this.business.getProductionOrganization().getProductionAvailableRawMaterials();
        this.productionAvailableProducts = this.business.getProductionOrganization().getProductionAvailableProducts();
        this.productionOrderDirectory = this.business.getProductionOrganization().getProductionOrderDirectory();
        this.productionOrderStatusDirectory = this.business.getProductionOrganization().getProductionOrderStatusDirectory();
        this.productionProductSpecificationDirectory = this.business.getProductionOrganization().getProductionProductSpecificationDirectory();
        
        this.procuremetRawMaterialsDirectory = this.business.getProcurementOrganization().getProcurementRawMaterialsDirectory();
        this.procurementOrderDirectory = this.business.getProcurementOrganization().getProcurementOrderDirectory();
        
        populateProductionOrderStatusComboBox();
        populateAvailableRawMaterialsTable();
        populateProductionAvailableProductsTable();
    }
    
    private void tblProductionOrderMouseClicked(java.awt.event.MouseEvent evt) {                                                 
        int selectedRowIndex = tblProductionOrder.getSelectedRow();
        if(selectedRowIndex >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblProductionOrder.getModel();
            int productionOrderId = (Integer) model.getValueAt(selectedRowIndex, 0);
            ProductionOrder selectedOrder = findProductionOrderById(productionOrderId);
            displayProductionOrderDetails(selectedOrder);
        }
    }  
    
    private ProductionOrder findProductionOrderById(int productionOrderId) {
        for (ProductionOrder order : productionOrderDirectory.getProductionOrderList()) {
            if (order.getProductionOrderId() == productionOrderId) {
                return order;
            }
        }
        return null;
    }
    
    private void displayProductionOrderDetails(ProductionOrder order) {
        if (order != null) {
            StringBuilder details = new StringBuilder();
            details.append("Order ID: ").append(order.getProductionOrderId()).append("\n");
            details.append("Status: ").append(order.getStatus()).append("\n");
            details.append("Items:\n");
            for (Map.Entry<String, Integer> entry : order.getProductionOrderProducts().entrySet()) {
                details.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
            }
            txtProductionOrderDetails.setText(details.toString());
        }
    }
    
    private void comboBoxProductionOrderStatusActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        String selectedStatus = (String) comboBoxProductionOrderStatus.getSelectedItem();
        populateProductionOrderTable(selectedStatus);
        txtProductionOrderDetails.setText("");
        boolean isInitiatedStatus = "Initiated".equals(selectedStatus);
        btnApproveOrder.setEnabled(isInitiatedStatus);
        btnRejectOrder.setEnabled(isInitiatedStatus);
    }
    
    public void populateProductionOrderTable(String productionOrderStatusName) {
        DefaultTableModel model = (DefaultTableModel) tblProductionOrder.getModel();
        model.setRowCount(0);
        for(ProductionOrder productionOrder : this.productionOrderDirectory.getProductionOrderList()) {
            int id = productionOrder.getProductionOrderId();
            int items = 0;
            for (Integer quantity : productionOrder.getProductionOrderProducts().values()) {
                items += quantity;
            }
            String client = "Store";
            String status = productionOrder.getStatus();
            if(status.equals(productionOrderStatusName)) {
                Object[] row = new Object[] {Integer.valueOf(id), Integer.valueOf(items), client, status};
                model.addRow(row);
            }
        }
    }
    
    public void populateProductionOrderStatusComboBox() {
        comboBoxProductionOrderStatus.removeAllItems();
        for (ProductionOrderStatus pos : this.productionOrderStatusDirectory.getProductionOrderStatusList()) {
            comboBoxProductionOrderStatus.addItem(pos.getName());
        }
    }
    
    public void populateProductionAvailableProductsTable() {
        DefaultTableModel model = (DefaultTableModel) tblProductionAvailableProducts.getModel();
        model.setRowCount(0);
        for(Map.Entry<String, Integer> entry : this.productionAvailableProducts.getProducationAvailableProducts().entrySet()) {
            Object[] row = new Object[]{entry.getKey(), entry.getValue(), Integer.valueOf(0)};
            model.addRow(row);
        }
    }
    
    public void populateAvailableRawMaterialsTable() {
        DefaultTableModel model = (DefaultTableModel) tblProcurementAvailableRawMaterials.getModel();
        model.setRowCount(0);
        for(Map.Entry<String, Integer> entry : this.productionAvailableRawMaterials.getProductionAvailableRawMaterials().entrySet()) {
            String rawMaterialName = entry.getKey();
            Integer availableUnits = entry.getValue();
            Integer totalPrice = 0;
            for(ProcurementRawMaterial procurementRawMaterial : this.procuremetRawMaterialsDirectory.getProcurementRawMaterialsList()) {
                if(procurementRawMaterial.getRawMaterialName().equals(rawMaterialName)) {
                    totalPrice = availableUnits * procurementRawMaterial.getPricePerUnit();
                    break;
                }
            }
            Object[] row = new Object[]{rawMaterialName, availableUnits, totalPrice};
            model.addRow(row);
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcurementAvailableRawMaterials = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductionAvailableProducts = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductionOrder = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        comboBoxProductionOrderStatus = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtProductionOrderDetails = new javax.swing.JTextArea();
        btnApproveOrder = new javax.swing.JButton();
        btnRejectOrder = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AVAILABLE RAW MATERIALS");

        tblProcurementAvailableRawMaterials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material Name", "Available Units", "Total Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProcurementAvailableRawMaterials);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTION ORGANIZATION (MANAGER)");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AVAILABLE PRODUCTS");

        tblProductionAvailableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Available Units", "Price Per Unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProductionAvailableProducts);

        tblProductionOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Items", "Client", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProductionOrder);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PRODUCTION ORDER");

        comboBoxProductionOrderStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtProductionOrderDetails.setColumns(20);
        txtProductionOrderDetails.setRows(5);
        jScrollPane4.setViewportView(txtProductionOrderDetails);

        btnApproveOrder.setText("APPROVE ORDER");
        btnApproveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveOrderActionPerformed(evt);
            }
        });

        btnRejectOrder.setText("REJECT ORDER");

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
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxProductionOrderStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnApproveOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRejectOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogout)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(comboBoxProductionOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnApproveOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnRejectOrder)))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

    }// </editor-fold>//GEN-END:initComponents
    
    /*
    private void btnApproveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveOrderActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProductionOrder.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a production order to approve");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProductionOrder.getModel();
        int productionOrderId = (Integer) model.getValueAt(selectedRowIndex, 0);
        ProductionOrder selectedOrder = findProductionOrderById(productionOrderId);
        if (selectedOrder == null) {
            JOptionPane.showMessageDialog(this, "Selected production order not found");
            return;
        }
        if (productionAvailableRawMaterials.checkEnoughRawMaterialsForProduction(selectedOrder, this.productionProductSpecificationDirectory)) {
            // If enough raw materials are available
            selectedOrder.setStatus("Production Approved");
            JOptionPane.showMessageDialog(this, "Production order with id = " + selectedOrder.getProductionOrderId() + " has been approved");
            productionAvailableRawMaterials.useRawMaterialsForProduction(selectedOrder, this.productionProductSpecificationDirectory);
        } else {
            String message = productionAvailableRawMaterials.messageForProcurementOrder(selectedOrder, this.productionProductSpecificationDirectory);
            JOptionPane.showMessageDialog(this, message); // Modify the JOption Pane, along with OK button, there should be a button Create Procurement Order, this should create ProcurementOrder (procurementOrderID = sizeOfProcurementOrderDirectory + 1 , HashMap<String, Integer> procurementOrder with Key as Raw Material Name and Value as count, status as "Initiated" ) and add to the procurementOrderDirectory, 
        }
        populateProductionOrderTable((String) comboBoxProductionOrderStatus.getSelectedItem());
        txtProductionOrderDetails.setText("");
    }//GEN-LAST:event_btnApproveOrderActionPerformed
    */
    
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
    
    
    private void btnApproveOrderActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int selectedRowIndex = tblProductionOrder.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a production order to approve");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProductionOrder.getModel();
        int productionOrderId = (Integer) model.getValueAt(selectedRowIndex, 0);
        ProductionOrder selectedOrder = findProductionOrderById(productionOrderId);
        if (selectedOrder == null) {
            JOptionPane.showMessageDialog(this, "Selected production order not found");
            return;
        }
        if (productionAvailableRawMaterials.checkEnoughRawMaterialsForProduction(selectedOrder, this.productionProductSpecificationDirectory)) {
            selectedOrder.setStatus("Production Approved");
            JOptionPane.showMessageDialog(this, "Production order with id = " + selectedOrder.getProductionOrderId() + " has been approved");
            // productionAvailableRawMaterials.useRawMaterialsForProduction(selectedOrder, this.productionProductSpecificationDirectory);
        } else {
            String message = productionAvailableRawMaterials.messageForProcurementOrder(selectedOrder, this.productionProductSpecificationDirectory);
            int result = JOptionPane.showConfirmDialog(this, message, "Create Procurement Order?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                createProcurementOrder(selectedOrder);
            }
        }
        populateProductionOrderTable((String) comboBoxProductionOrderStatus.getSelectedItem());
        txtProductionOrderDetails.setText("");
    }
    
    private void createProcurementOrder(ProductionOrder productionOrder) {
        System.out.println(this.procurementOrderDirectory.getProcurementOrderList().size());
        int procurementOrderId = this.procurementOrderDirectory.getProcurementOrderList().size() + 1;
        HashMap<String, Integer> procurementOrderProducts = new HashMap<>();
        ProcurementOrder newProcurementOrder = new ProcurementOrder(procurementOrderId, procurementOrderProducts, "Initiated");
        this.procurementOrderDirectory.addProcurementOrder(newProcurementOrder);
        JOptionPane.showMessageDialog(this, "Procurement Order Created with ID: " + procurementOrderId);
        System.out.println(this.procurementOrderDirectory.getProcurementOrderList().size());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveOrder;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRejectOrder;
    private javax.swing.JComboBox<String> comboBoxProductionOrderStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblProcurementAvailableRawMaterials;
    private javax.swing.JTable tblProductionAvailableProducts;
    private javax.swing.JTable tblProductionOrder;
    private javax.swing.JTextArea txtProductionOrderDetails;
    // End of variables declaration//GEN-END:variables
}
