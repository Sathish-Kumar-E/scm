/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.onlineShoppingStore;

/**
 *
 * @author sathi
 */

import java.util.HashMap;

import business.organization.production.ProductionOrder;

public class InStockProducts {
    
    private HashMap<String, Integer> inStockProducts;

    public InStockProducts() {
        this.inStockProducts = new HashMap<String, Integer>();
    }

    public InStockProducts(HashMap<String, Integer> retailerInStockProducts) {
        this.inStockProducts = retailerInStockProducts;
    }

    public HashMap<String, Integer> getInStockProducts() {
        return inStockProducts;
    }

    public void setInStockProducts(HashMap<String, Integer> inStockProducts) {
        this.inStockProducts = inStockProducts;
    }
    
    public void addProduct(String productName, int count) {
        if (inStockProducts.containsKey(productName)) {
            inStockProducts.put(productName, inStockProducts.get(productName) + count);
        } else {
            inStockProducts.put(productName, count);
        }
    }
    
    public void removeProduct(String productName) {
        inStockProducts.remove(productName);
    }
    
    public void receiveProductionOrder(ProductionOrder productionOrder) {
        productionOrder.getProductionOrderProducts().forEach((productName, count) -> {
            addProduct(productName, count);
        });
    }
    
    @Override
    public String toString() {
        return "RetailerInStockProducts{" + "retailerInStockProducts=" + inStockProducts + '}';
    }
    
}
