/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.admin;

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
import userInterface.*;
import business.employee.*;

import userInterface.procurementOrganization.ProcurementManagerJPanel;
import userInterface.procurementOrganization.ProcurementPackingSupervisorJPanel;
import userInterface.productionOrganization.ProductionManagerJPanel;
import userInterface.productionOrganization.ProductionManufacturingEngineerJPanel;
import userInterface.commodityConveyanceOrganization.FreightTruckDriverJPanel;
import userInterface.consumerFoodDistribution.CullinaryFreightOperatorJPanel;
import userInterface.onlineShoppingStore.RetailerJPanel;
import userInterface.onlineShoppingStore.CustomerJPanel;
import userInterface.admin.AdminJPanel;
import business.organization.commodityConveyance.*;
import business.organization.consumerFoodDistribution.*;
import business.organization.onlineShoppingStore.*;
import business.organization.procurement.*;
import business.organization.production.*;
import business.person.Person;
import business.person.PersonDirectory;

public class AdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminJPanel
     */
    
    private JPanel userProcessContainer;
    private Business business;
    
    public AdminJPanel(JPanel userProcessContainer, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        populateData();
        populateCOmboBox();
    }
    
    public void populateCOmboBox() {
        // Write a code to populate combo box list
        String[] enterprises = { "Manufacturing", "Logistics", "Sales", "Delivery" };
        comboBoxEnterprise.setModel(new javax.swing.DefaultComboBoxModel<>(enterprises));
        // Populating comboBoxOrganization
        String[] organizations = { "Procurement", "Production", "Commodity Conveyance", "Consumer Food Distribution", "Online Shopping Store", "Delivery Organization" };
        comboBoxOrganization.setModel(new javax.swing.DefaultComboBoxModel<>(organizations));
        // Populating jComboBox1 (Roles)
        String[] roles = { "Procurement Manager", "Packing Supervisor", "Retailer", "Customer", "Production Manager", "Manufacturing Engineer", "Freight Truck Driver", "Culinary Freight Operator" };
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(roles));
    }
    
    public void populateData() {
    // 1. Total Number of Employees
    int totalEmployees = business.getPersonDirectory().getPersonList().size();
    txtEmployeesCount.setText(String.valueOf(totalEmployees));
    
    // 2. Total Number of Production Orders
    int totalProdOrders = business.getProductionOrganization().getProductionOrderDirectory().getProductionOrderList().size();
    txtProductionOrdersCount.setText(String.valueOf(totalProdOrders));

    // 3. Total Number of Customer Orders
    int totalCustOrders = business.getOnlineShoppingStoreOrganization().getCustomerOrderDirectory().getCustomerOrderList().size();
    txtCustomerOrdersCount.setText(String.valueOf(totalCustOrders));
    
    // 4. Average Salary of Employees
    int total = 0;
    for(Employee employee : this.business.getCommodityConveyanceOrganization().getEmployeeDirectory().getEmployeeList()) {
        total = total + employee.getSalary();
    }
    for(Employee employee : this.business.getConsumerFoodDistributionOrganization().getEmployeeDirectory().getEmployeeList()) {
        total = total + employee.getSalary();
    }
    for(Employee employee : this.business.getOnlineShoppingStoreOrganization().getEmployeeDirectory().getEmployeeList()) {
        total = total + employee.getSalary();
    }
    for(Employee employee : this.business.getProcurementOrganization().getEmployeeDirectory().getEmployeeList()) {
        total = total + employee.getSalary();
    }
    for(Employee employee : this.business.getProductionOrganization().getEmployeeDirectory().getEmployeeList()) {
        total = total + employee.getSalary();
    }
    txtAverageSalary.setText(String.valueOf(total / totalEmployees));
    
    // 5. Total Number of Items in Procurement Org Inventory
    int totalProcurementItems = 0;
    for (Integer quantity : business.getProcurementOrganization().getProcurementAvailableRawMaterials().getProcurementAvailableRawMaterials().values()) {
        totalProcurementItems += quantity;
    }
    txtProcurementOrganizationInventoryItemsCount.setText(String.valueOf(totalProcurementItems));
    
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
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtEmployeesCount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProductionOrdersCount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCustomerOrdersCount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAverageSalary = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtProcurementOrganizationInventoryItemsCount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        comboBoxEnterprise = new javax.swing.JComboBox<>();
        comboBoxOrganization = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN SCREEN");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 6, 290, 30));

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 10, 100, -1));

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 100, -1));

        jLabel2.setText("Total Number of Employees in the Eco System");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 260, 30));
        add(txtEmployeesCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 110, 30));

        jLabel3.setText("Total Numbet of Production Orders");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 250, 30));
        add(txtProductionOrdersCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 110, 30));

        jLabel4.setText("Total Number of Customer Orders");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 250, 30));
        add(txtCustomerOrdersCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 110, 30));

        jLabel5.setText("Average Salary of Employees in the Eco System");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 250, 30));
        add(txtAverageSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 110, 30));

        jLabel6.setText("Total Number of Items in Procurement Organization Inventory");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 340, 40));

        txtProcurementOrganizationInventoryItemsCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcurementOrganizationInventoryItemsCountActionPerformed(evt);
            }
        });
        add(txtProcurementOrganizationInventoryItemsCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CREATE AN USER");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 500, 30));

        jLabel8.setText("First Name");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 160, 30));

        jLabel9.setText("Last Name");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 196, 150, 30));

        jLabel10.setText("Enterprise");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 150, 30));

        jLabel11.setText("Organization");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 150, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 130, 30));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 130, 30));

        comboBoxEnterprise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboBoxEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 242, 130, 30));

        comboBoxOrganization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboBoxOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 130, 30));

        jLabel12.setText("Role");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 146, 130, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 150, 120, 30));

        jLabel13.setText("Username");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 140, 30));

        jLabel14.setText("Password");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 236, 130, 30));
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 200, 120, -1));
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 240, 120, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("CREATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 280, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtProcurementOrganizationInventoryItemsCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProcurementOrganizationInventoryItemsCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProcurementOrganizationInventoryItemsCountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        LoginJPanel panel = new LoginJPanel(userProcessContainer, this.business);
        userProcessContainer.add("LoginJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        LoginJPanel panel = new LoginJPanel(userProcessContainer, this.business);
        userProcessContainer.add("LoginJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String firstName = jTextField1.getText();
        String lastName = jTextField2.getText();
        String enterprise = (String) comboBoxEnterprise.getSelectedItem();
        String organization = (String) comboBoxOrganization.getSelectedItem();
        String role = (String) jComboBox1.getSelectedItem();
        String username = jTextField3.getText();
        String password = jTextField4.getText();
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }
        if(organization.equals("Procurement")) {
            Person person = new Person();
            person.setId(this.business.getPersonDirectory().getPersonList().size());
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setUserName(username);
            person.setPassword(password);
            Employee emp = new Employee();
            emp.setPerson(person);
            emp.setOrganization(organization);
            emp.setEnterprise(enterprise);
            emp.setRole(role);
            this.business.getProcurementOrganization().getEmployeeDirectory().addNewEmployee(emp);
        }
        if(organization.equals("Production")) {
            Person person = new Person();
            person.setId(this.business.getPersonDirectory().getPersonList().size());
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setUserName(username);
            person.setPassword(password);
            Employee emp = new Employee();
            emp.setPerson(person);
            emp.setOrganization(organization);
            emp.setEnterprise(enterprise);
            emp.setRole(role);
            this.business.getProductionOrganization().getEmployeeDirectory().addNewEmployee(emp);
        }
        if(organization.equals("Commodity Conveyance")) {
            Person person = new Person();
            person.setId(this.business.getPersonDirectory().getPersonList().size());
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setUserName(username);
            person.setPassword(password);
            Employee emp = new Employee();
            emp.setPerson(person);
            emp.setOrganization(organization);
            emp.setEnterprise(enterprise);
            emp.setRole(role);
            this.business.getCommodityConveyanceOrganization().getEmployeeDirectory().addNewEmployee(emp);
        }
        if(organization.equals("Consumer Food Distribution")) {
            Person person = new Person();
            person.setId(this.business.getPersonDirectory().getPersonList().size());
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setUserName(username);
            person.setPassword(password);
            Employee emp = new Employee();
            emp.setPerson(person);
            emp.setOrganization(organization);
            emp.setEnterprise(enterprise);
            emp.setRole(role);
            this.business.getConsumerFoodDistributionOrganization().getEmployeeDirectory().addNewEmployee(emp);
        }
        if(organization.equals("Online Shopping Store")) {
            Person person = new Person();
            person.setId(this.business.getPersonDirectory().getPersonList().size());
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setUserName(username);
            person.setPassword(password);
            Employee emp = new Employee();
            emp.setPerson(person);
            emp.setOrganization(organization);
            emp.setEnterprise(enterprise);
            emp.setRole(role);
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> comboBoxEnterprise;
    private javax.swing.JComboBox<String> comboBoxOrganization;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField txtAverageSalary;
    private javax.swing.JTextField txtCustomerOrdersCount;
    private javax.swing.JTextField txtEmployeesCount;
    private javax.swing.JTextField txtProcurementOrganizationInventoryItemsCount;
    private javax.swing.JTextField txtProductionOrdersCount;
    // End of variables declaration//GEN-END:variables
}
