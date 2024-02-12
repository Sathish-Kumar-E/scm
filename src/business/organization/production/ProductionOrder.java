/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.production;

/**
 *
 * @author sathi
 */

import java.util.HashMap;

public class ProductionOrder {
    
    private int productionOrderId;
    private HashMap<String, Integer> productionOrderProducts;
    private String status;
    private String initiatedBy = "NA";
    private String approvedBy = "NA";
    private String manufactureAssignedTo = "NA";
    private String driverAssigned = "NA";
    private String deliveryStatus = "NA";
    private int productionOrderPrice;
    
    public ProductionOrder() {
        this.productionOrderProducts = new HashMap<String, Integer>();
    }
    
    // Use this constructor
    public ProductionOrder(int productionOrderId, HashMap<String, Integer> productionOrderProducts, String status) {
        this.productionOrderProducts = new HashMap<String, Integer>();
        this.productionOrderId = productionOrderId;
        this.productionOrderProducts = productionOrderProducts;
        this.status = status;
    }
    
    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getManufactureAssignedTo() {
        return manufactureAssignedTo;
    }
    
    public void setManufactureAssignedTo(String manufactureAssignedTo) {
        this.manufactureAssignedTo = manufactureAssignedTo;
    }
    
    public int getProductionOrderId() {
        return productionOrderId;
    }
    
    public void setProductionOrderId(int productionOrderId) {
        this.productionOrderId = productionOrderId;
    }
    
    public HashMap<String, Integer> getProductionOrderProducts() {
        return productionOrderProducts;
    }
    
    public void setProductionOrderProducts(HashMap<String, Integer> productionOrderProducts) {
        this.productionOrderProducts = productionOrderProducts;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDriverAssigned() {
        return driverAssigned;
    }
    
    public void setDriverAssigned(String driverAssigned) {
        this.driverAssigned = driverAssigned;
    }
    
    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    
    public int getProductionOrderPrice() {
        return productionOrderPrice;
    }
    
    public void setProductionOrderPrice(int productionOrderPrice) {
        this.productionOrderPrice = productionOrderPrice;
    }
    
    public void addNewProductionOrderProduct(String productName, int count) {
        if (productionOrderProducts.containsKey(productName)) {
            int currentCount = productionOrderProducts.get(productName);
            productionOrderProducts.put(productName, currentCount + count);
        } else {
            productionOrderProducts.put(productName, count);
        }
    }
    
    public void removeProductionOrderProduct(String productName) {
        productionOrderProducts.remove(productName);
    }
    
    @Override
    public String toString() {
        return String.valueOf(productionOrderId);
    }
    
}
