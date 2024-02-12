/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface;

/**
 *
 * @author sathi
 */
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

import business.employee.Employee;
import business.employee.EmployeeDirectory;

import userInterface.Business;
import userInterface.procurementOrganization.ProcurementManagerJPanel;
import userInterface.procurementOrganization.ProcurementPackingSupervisorJPanel;
import userInterface.productionOrganization.ProductionManagerJPanel;
import userInterface.productionOrganization.ProductionManufacturingEngineerJPanel;
import userInterface.commodityConveyanceOrganization.FreightTruckDriverJPanel;
import userInterface.consumerFoodDistribution.CullinaryFreightOperatorJPanel;
import userInterface.onlineShoppingStore.RetailerJPanel;
import userInterface.onlineShoppingStore.CustomerJPanel;
import userInterface.admin.AdminJPanel;
import userInterface.delivery.DeliveryJPanel;

public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    private JPanel userProcessContainer;
    private Business business;
    
    public LoginJPanel(JPanel userProcessContainer, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
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
        jLabel3 = new javax.swing.JLabel();
        txtLoginUsername = new javax.swing.JTextField();
        txtLoginPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN HERE");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(451, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, txtLoginPassword, txtLoginUsername});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, txtLoginPassword, txtLoginUsername});

    }// </editor-fold>//GEN-END:initComponents
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username = txtLoginUsername.getText();
        String password = txtLoginPassword.getText();
        boolean isUserFound = false;
        if(username.equals("driver") && password.equals("driver")) {
            isUserFound = true;
            DeliveryJPanel panel = new DeliveryJPanel(userProcessContainer, this.business, username);
            userProcessContainer.add("DeliveryJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        if(username.equals("admin") && password.equals("admin")) {
            isUserFound = true;
            AdminJPanel panel = new AdminJPanel(userProcessContainer, this.business);
            userProcessContainer.add("ProcurementManagerJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        for (Employee employee : this.business.getProcurementOrganization().getEmployeeDirectory().getEmployeeList()) {
            if (employee.getPerson().getUserName().equals(username) && employee.getPerson().getPassword().equals(password)) {
                isUserFound = true;
                if (employee.getRole().equals("Procurement Manager")) {
                    ProcurementManagerJPanel panel = new ProcurementManagerJPanel(userProcessContainer, this.business, username);
                    userProcessContainer.add("ProcurementManagerJPanel", panel);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                } else if (employee.getRole().equals("Packing Supervisor")) {
                    ProcurementPackingSupervisorJPanel panel = new ProcurementPackingSupervisorJPanel(userProcessContainer, this.business, username);
                    userProcessContainer.add("ProcurementPackingSupervisorJPanel", panel);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                }
                break;
            }
        }
        if (!isUserFound) {
            for (Employee employee : this.business.getProductionOrganization().getEmployeeDirectory().getEmployeeList()) {
                if (employee.getPerson().getUserName().equals(username) && employee.getPerson().getPassword().equals(password)) {
                    isUserFound = true;
                    if (employee.getRole().equals("Production Manager")) {
                        ProductionManagerJPanel panel = new ProductionManagerJPanel(userProcessContainer, this.business, username);
                        userProcessContainer.add("ProductionManagerJPanel", panel);
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        layout.next(userProcessContainer);    
                    } else if (employee.getRole().equals("Manufacturing Engineer")) {
                        ProductionManufacturingEngineerJPanel panel = new ProductionManufacturingEngineerJPanel(userProcessContainer, this.business, username);
                        userProcessContainer.add("ProductionManufacturingEngineerJPanel", panel);
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        layout.next(userProcessContainer); 
                    }   
                    break; 
                }
            }
        }
        if(!isUserFound) {
            for(Employee employee : this.business.getCommodityConveyanceOrganization().getEmployeeDirectory().getEmployeeList()) {
                if(employee.getPerson().getUserName().equals(username) && employee.getPerson().getPassword().equals(password) && employee.getRole().equals("Freight Truck Driver")) {
                    isUserFound = true;
                    FreightTruckDriverJPanel panel = new FreightTruckDriverJPanel(userProcessContainer, this.business, username);
                    userProcessContainer.add("FreightTruckDriverJPanel", panel);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer); 
                }
            }
        }
        if(!isUserFound) {
            for(Employee employee : this.business.getConsumerFoodDistributionOrganization().getEmployeeDirectory().getEmployeeList()) {
                if(employee.getPerson().getUserName().equals(username) && employee.getPerson().getPassword().equals(password) && employee.getRole().equals("Cullinary Freight Operator")) {
                    isUserFound = true;
                    CullinaryFreightOperatorJPanel panel = new CullinaryFreightOperatorJPanel(userProcessContainer, this.business, username);
                    userProcessContainer.add("CullinaryFreightOperatorJPanel", panel);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer); 
                }
            }
        }
        if(!isUserFound) {
            for(Employee employee : this.business.getOnlineShoppingStoreOrganization().getEmployeeDirectory().getEmployeeList()) {
                if(employee.getPerson().getUserName().equals(username) && employee.getPerson().getPassword().equals(password)) {
                    isUserFound = true;
                    if(employee.getRole().equals("Retailer")) {
                        RetailerJPanel panel = new RetailerJPanel(userProcessContainer, this.business, username);
                        userProcessContainer.add("RetailerJPanel", panel);
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        layout.next(userProcessContainer); 
                    } else if(employee.getRole().equals("Customer")) {
                        CustomerJPanel panel = new CustomerJPanel(userProcessContainer, this.business, username);
                        userProcessContainer.add("CustomerJPanel", panel);
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        layout.next(userProcessContainer); 
                    }
                }
            }
        }
        if (!isUserFound) {
            JOptionPane.showMessageDialog(this, "Invalid credentials or user role not found.");
            txtLoginUsername.setText("");
            txtLoginPassword.setText("");
        }     
    }//GEN-LAST:event_btnLoginActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtLoginPassword;
    private javax.swing.JTextField txtLoginUsername;
    // End of variables declaration//GEN-END:variables
}
