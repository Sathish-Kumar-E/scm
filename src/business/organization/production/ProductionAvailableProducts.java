/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.production;

/**
 *
 * @author sathi
 */

import java.util.Map;
import java.util.HashMap;

public class ProductionAvailableProducts {
    
    private HashMap<String, Integer> productionAvailableProducts;
    
    public ProductionAvailableProducts() {
        this.productionAvailableProducts = new HashMap<String, Integer>();
    }
    
    public HashMap<String, Integer> getProducationAvailableProducts() {
        return productionAvailableProducts;
    }
    
    public void setProducationAvailableProducts(HashMap<String, Integer> producationAvailableProducts) {
        this.productionAvailableProducts = producationAvailableProducts;
    }
    
    public void addNewProductionAvailableProducts(String productName, int count) {
        if (productionAvailableProducts.containsKey(productName)) {
            int currentCount = productionAvailableProducts.get(productName);
            productionAvailableProducts.put(productName, currentCount + count);
        } else {
            productionAvailableProducts.put(productName, count);
        }
    }
    
    public void removeProductionAvailableProducts(String productName) {
        productionAvailableProducts.remove(productName);
    }
    
    public void addManufacturedProducts(ProductionOrder productionOrder) {
        HashMap<String, Integer> manufacturedProducts = productionOrder.getProductionOrderProducts();
        for (Map.Entry<String, Integer> productEntry : manufacturedProducts.entrySet()) {
            String productName = productEntry.getKey();
            int productCount = productEntry.getValue();
            addNewProductionAvailableProducts(productName, productCount);
        }
    }
    
    public boolean checkProductionOrder(ProductionOrder productionOrder) {
        HashMap<String, Integer> orderProducts = productionOrder.getProductionOrderProducts();
        for (Map.Entry<String, Integer> entry : orderProducts.entrySet()) {
            String productName = entry.getKey();
            int quantityRequired = entry.getValue();
            if (!productionAvailableProducts.containsKey(productName) || productionAvailableProducts.get(productName) < quantityRequired) {
                return false;
            }
        }
        return true;
    }
    
    public void processProductionOrder(ProductionOrder productionOrder) {
        if (!checkProductionOrder(productionOrder)) {
            System.out.println("Insufficient products available for production order: " + productionOrder.getProductionOrderId());
            return;
        }
        for (Map.Entry<String, Integer> entry : productionOrder.getProductionOrderProducts().entrySet()) {
            String productName = entry.getKey();
            int requiredQuantity = entry.getValue();
            int availableQuantity = productionAvailableProducts.getOrDefault(productName, 0);
            if (availableQuantity >= requiredQuantity) {
                productionAvailableProducts.put(productName, availableQuantity - requiredQuantity);
            } else {
                System.out.println("Error: Insufficient quantity for product: " + productName);
            }
        }
    }
    
    @Override
    public String toString() {
        return "ProductionAvailableProducts{" + "productionAvailableProducts=" + productionAvailableProducts + '}';
    }
    
}
