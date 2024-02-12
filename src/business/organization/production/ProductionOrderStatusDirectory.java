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

public class ProductionOrderStatusDirectory {
    
    private ArrayList<ProductionOrderStatus> productionOrderStatusList;

    public ProductionOrderStatusDirectory() {
        this.productionOrderStatusList = new ArrayList<ProductionOrderStatus>();
    }

    public ArrayList<ProductionOrderStatus> getProductionOrderStatusList() {
        return productionOrderStatusList;
    }

    public void setProductionOrderStatusList(ArrayList<ProductionOrderStatus> productionOrderStatusList) {
        this.productionOrderStatusList = productionOrderStatusList;
    }
    
    public void addNewProductionOrderStatus(ProductionOrderStatus productionOrderStatus) {
        this.productionOrderStatusList.add(productionOrderStatus);
    }
    
    public void removeProductionOrderStatus(ProductionOrderStatus productionOrderStatus) {
        this.productionOrderStatusList.remove(productionOrderStatus);
    }
    
    @Override
    public String toString() {
        return "ProductionOrderStatusDirectory{" + "productionOrderStatusList=" + productionOrderStatusList + '}';
    }
    
}
