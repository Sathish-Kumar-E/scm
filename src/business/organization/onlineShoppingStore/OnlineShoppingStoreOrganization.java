/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.onlineShoppingStore;

/**
 *
 * @author sathi
 */

import business.organization.Organization;
import business.employee.EmployeeDirectory;

public class OnlineShoppingStoreOrganization {
    
    private Organization organization;
    private EmployeeDirectory employeeDirectory;
    private InStockProducts inStockProducts;
    private CustomerOrderDirectory customerOrderDirectory;
    private CustomerProductPriceDirectory customerProductPriceDirectory;
    
    public OnlineShoppingStoreOrganization() {
        this.organization = new Organization();
        this.employeeDirectory = new EmployeeDirectory();
        this.inStockProducts = new InStockProducts();
        this.customerOrderDirectory = new CustomerOrderDirectory();
        this.customerProductPriceDirectory = new CustomerProductPriceDirectory();
    }
    
    public CustomerProductPriceDirectory getCustomerProductPriceDirectory() {
        return customerProductPriceDirectory;
    }
    
    public void setCustomerProductPriceDirectory(CustomerProductPriceDirectory customerProductPriceDirectory) {
        this.customerProductPriceDirectory = customerProductPriceDirectory;
    }
    
    public CustomerOrderDirectory getCustomerOrderDirectory() {
        return customerOrderDirectory;
    }

    public void setCustomerOrderDirectory(CustomerOrderDirectory customerOrderDirectory) {
        this.customerOrderDirectory = customerOrderDirectory;
    }
    
    public InStockProducts getInStockProducts() {
        return inStockProducts;
    }
    
    public void setInStockProducts(InStockProducts inStockProducts) {
        this.inStockProducts = inStockProducts;
    }
    
    public Organization getOrganization() {
        return organization;
    }
    
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    
    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }
    
    @Override
    public String toString() {
        return "ShoppingStoreOrganization{" + "organization=" + organization + ", employeeDirectory=" + employeeDirectory + ", inStockProducts=" + inStockProducts + '}';
    }
    
}
