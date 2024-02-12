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

public class ProductionOrderDirectory {
    
    private ArrayList<ProductionOrder> productionOrderList;

    public ProductionOrderDirectory() {
        this.productionOrderList = new ArrayList<ProductionOrder>();
    }
    
    public ArrayList<ProductionOrder> getProductionOrderList() {
        return productionOrderList;
    }
    
    public void setProductionOrderList(ArrayList<ProductionOrder> productionOrderList) {
        this.productionOrderList = productionOrderList;
    }
    
    public void addNewProductionOrder(ProductionOrder productionOrder) {
        this.productionOrderList.add(productionOrder);
    }
    
    public void removeProductionOrder(ProductionOrder productionOrder) {
        this.productionOrderList.remove(productionOrder);
    }
    
    @Override
    public String toString() {
        return "ProductionOrderDirectory{" + "productionOrderList=" + productionOrderList + '}';
    }
    
}
