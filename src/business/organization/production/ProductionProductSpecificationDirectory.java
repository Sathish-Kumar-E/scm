/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.production;

/**
 *
 * @author sathi
 */

import java.util.ArrayList;

public class ProductionProductSpecificationDirectory {
    
    private ArrayList<ProductionProductSpecification> productionProductionSpecificationList;
    
    public ProductionProductSpecificationDirectory() {
        this.productionProductionSpecificationList = new ArrayList<ProductionProductSpecification>();
    }
    
    public ProductionProductSpecificationDirectory(ArrayList<ProductionProductSpecification> productionProductionSpecificationList) {
        this.productionProductionSpecificationList = productionProductionSpecificationList;
    }
    
    public ArrayList<ProductionProductSpecification> getProductionProductionSpecificationList() {
        return productionProductionSpecificationList;
    }
    
    public void setProductionProductionSpecificationList(ArrayList<ProductionProductSpecification> productionProductionSpecificationList) {
        this.productionProductionSpecificationList = productionProductionSpecificationList;
    }
    
    public void addNewProductionProductSpecification(ProductionProductSpecification productionProductSpecification) {
        this.productionProductionSpecificationList.add(productionProductSpecification);
    }
    
    public void removeProductionProductSpecification(ProductionProductSpecification productionProductSpecification) {
        this.productionProductionSpecificationList.remove(productionProductSpecification);
    }
    
    @Override
    public String toString() {
        return "ProductionProductSpecificationDirectory{" + "productionProductionSpecificationList=" + productionProductionSpecificationList + '}';
    }
    
}
