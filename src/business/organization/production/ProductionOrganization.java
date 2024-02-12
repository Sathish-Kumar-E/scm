/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.production;

/**
 *
 * @author sathi
 */

import business.organization.Organization;
import business.employee.EmployeeDirectory;

public class ProductionOrganization {
    
    private Organization organization;
    private EmployeeDirectory employeeDirectory;
    private ProductionAvailableRawMaterials productionAvailableRawMaterials;
    private ProductionProductSpecificationDirectory productionProductSpecificationDirectory;
    private ProductionOrderDirectory productionOrderDirectory;
    private ProductionAvailableProducts productionAvailableProducts;
    private ProductionOrderStatusDirectory productionOrderStatusDirectory;
    
    public ProductionOrganization() {
        this.organization = new Organization();
        this.employeeDirectory = new EmployeeDirectory();
        this.productionAvailableRawMaterials = new ProductionAvailableRawMaterials();
        this.productionProductSpecificationDirectory = new ProductionProductSpecificationDirectory();
        this.productionOrderDirectory = new ProductionOrderDirectory();
        this.productionAvailableProducts = new ProductionAvailableProducts();
        this.productionOrderStatusDirectory = new ProductionOrderStatusDirectory();
    }
    
    public ProductionOrganization(Organization organization, EmployeeDirectory employeeDirectory, ProductionAvailableRawMaterials productionAvailableRawMaterials, ProductionProductSpecificationDirectory productionProductSpecificationDirectory, ProductionOrderDirectory productionOrderDirectory, ProductionAvailableProducts productionAvailableProducts, ProductionOrderStatusDirectory productionOrderStatusDirectory) {
        this.organization = organization;
        this.employeeDirectory = employeeDirectory;
        this.productionAvailableRawMaterials = productionAvailableRawMaterials;
        this.productionProductSpecificationDirectory = productionProductSpecificationDirectory;
        this.productionOrderDirectory = productionOrderDirectory;
        this.productionAvailableProducts = productionAvailableProducts;
        this.productionOrderStatusDirectory = productionOrderStatusDirectory;
    }
    
    public ProductionAvailableProducts getProductionAvailableProducts() {
        return productionAvailableProducts;
    }
    
    public void setProductionAvailableProducts(ProductionAvailableProducts productionAvailableProducts) {
        this.productionAvailableProducts = productionAvailableProducts;
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
    
    public ProductionAvailableRawMaterials getProductionAvailableRawMaterials() {
        return productionAvailableRawMaterials;
    }
    
    public void setProductionAvailableRawMaterials(ProductionAvailableRawMaterials productionAvailableRawMaterials) {
        this.productionAvailableRawMaterials = productionAvailableRawMaterials;
    }
    
    public ProductionProductSpecificationDirectory getProductionProductSpecificationDirectory() {
        return productionProductSpecificationDirectory;
    }
    
    public void setProductionProductSpecificationDirectory(ProductionProductSpecificationDirectory productionProductSpecificationDirectory) {
        this.productionProductSpecificationDirectory = productionProductSpecificationDirectory;
    }
    
    public ProductionOrderDirectory getProductionOrderDirectory() {
        return productionOrderDirectory;
    }
    
    public void setProductionOrderDirectory(ProductionOrderDirectory productionOrderDirectory) {
        this.productionOrderDirectory = productionOrderDirectory;
    }
    
    public ProductionOrderStatusDirectory getProductionOrderStatusDirectory() {
        return productionOrderStatusDirectory;
    }
    
    public void setProductionOrderStatusDirectory(ProductionOrderStatusDirectory productionOrderStatusDirectory) {
        this.productionOrderStatusDirectory = productionOrderStatusDirectory;
    }
    
}
