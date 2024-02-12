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
import java.util.Map;
import java.util.HashMap;

import business.organization.procurement.ProcurementOrder;

public class ProductionAvailableRawMaterials {
    
    private HashMap<String, Integer> productionAvailableRawMaterials;
    
    public ProductionAvailableRawMaterials() {
        this.productionAvailableRawMaterials = new HashMap<String, Integer>();
    }
    
    public HashMap<String, Integer> getProductionAvailableRawMaterials() {
        return productionAvailableRawMaterials;
    }
    
    public void setProductionAvailableRawMaterials(HashMap<String, Integer> productionAvailableRawMaterials) {
        this.productionAvailableRawMaterials = productionAvailableRawMaterials;
    }
    
    public void addRawMaterial(String rawMaterialName, int count) {
        if (productionAvailableRawMaterials.containsKey(rawMaterialName)) {
            int currentCount = productionAvailableRawMaterials.get(rawMaterialName);
            productionAvailableRawMaterials.put(rawMaterialName, currentCount + count);
        } else {
            productionAvailableRawMaterials.put(rawMaterialName, count);
        }
    }
    
    public void removeRawMaterial(String rawMaterialName) {
        productionAvailableRawMaterials.remove(rawMaterialName);
    }
    
    public boolean checkEnoughRawMaterialsForProduction(ProductionOrder productionOrder, ProductionProductSpecificationDirectory productionProductSpecificationDirectory) {
        HashMap<String, Integer> productionOrderProducts = productionOrder.getProductionOrderProducts();
        ArrayList<ProductionProductSpecification> productionProductSpecificationList = productionProductSpecificationDirectory.getProductionProductionSpecificationList();
        for (Map.Entry<String, Integer> orderEntry : productionOrderProducts.entrySet()) {
            String productName = orderEntry.getKey();
            int productCount = orderEntry.getValue();
            for (ProductionProductSpecification productSpec : productionProductSpecificationList) {
                if (productSpec.getProductName().equals(productName)) {
                    HashMap<String, Integer> rawMaterialsRequired = productSpec.getRawMaterialsRequired();
                    for (Map.Entry<String, Integer> materialEntry : rawMaterialsRequired.entrySet()) {
                        String materialName = materialEntry.getKey();
                        int materialCountNeeded = materialEntry.getValue() * productCount;
                        if (!productionAvailableRawMaterials.containsKey(materialName) || productionAvailableRawMaterials.get(materialName) < materialCountNeeded) {
                            return false;
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }
    
    public String messageForProcurementOrder(ProductionOrder productionOrder, ProductionProductSpecificationDirectory productionProductSpecificationDirectory) {
        StringBuilder message = new StringBuilder();
        boolean isProcurementNeeded = false;
        message.append("There are not enough raw materials in the inventory to manufacture the production order with id = ")
           .append(productionOrder.getProductionOrderId()).append(". \nWe need ");
        HashMap<String, Integer> productionOrderProducts = productionOrder.getProductionOrderProducts();
        ArrayList<ProductionProductSpecification> productionProductSpecificationList = productionProductSpecificationDirectory.getProductionProductionSpecificationList();
        for (Map.Entry<String, Integer> orderEntry : productionOrderProducts.entrySet()) {
            String productName = orderEntry.getKey();
            int productCount = orderEntry.getValue();
            for (ProductionProductSpecification productSpec : productionProductSpecificationList) {
                if (productSpec.getProductName().equals(productName)) {
                    HashMap<String, Integer> rawMaterialsRequired = productSpec.getRawMaterialsRequired();
                    for (Map.Entry<String, Integer> materialEntry : rawMaterialsRequired.entrySet()) {
                        String materialName = materialEntry.getKey();
                        int materialCountNeeded = materialEntry.getValue() * productCount;
                        if (!productionAvailableRawMaterials.containsKey(materialName) || productionAvailableRawMaterials.get(materialName) < materialCountNeeded) {
                            int deficit = materialCountNeeded - (productionAvailableRawMaterials.containsKey(materialName) ? productionAvailableRawMaterials.get(materialName) : 0);
                            message.append(deficit).append(" more ").append(materialName).append(", ");
                            isProcurementNeeded = true;
                        }
                    }
                    break;
                }
            }
        }
        if (isProcurementNeeded) {
            message.setLength(message.length() - 2);
            message.append(" to manufacture the production order. \nDo you want to create the procurement order with the required materials?");
        } else {
            return "All necessary materials for production are available.";
        }
        return message.toString();
    }
    
    public ProductionOrder useRawMaterialsForProduction(ProductionOrder productionOrder, ProductionProductSpecificationDirectory productionProductSpecificationDirectory) {
        HashMap<String, Integer> productionOrderProducts = productionOrder.getProductionOrderProducts();
        ArrayList<ProductionProductSpecification> productionProductSpecificationList = productionProductSpecificationDirectory.getProductionProductionSpecificationList();
        for (Map.Entry<String, Integer> orderEntry : productionOrderProducts.entrySet()) {
            String productName = orderEntry.getKey();
            int productCount = orderEntry.getValue();
            for (ProductionProductSpecification productSpec : productionProductSpecificationList) {
                if (productSpec.getProductName().equals(productName)) {
                    HashMap<String, Integer> rawMaterialsRequired = productSpec.getRawMaterialsRequired();
                    for (Map.Entry<String, Integer> materialEntry : rawMaterialsRequired.entrySet()) {
                        String materialName = materialEntry.getKey();
                        int materialCountNeeded = materialEntry.getValue() * productCount;
                        if (productionAvailableRawMaterials.containsKey(materialName)) {
                            int currentMaterialCount = productionAvailableRawMaterials.get(materialName);
                            productionAvailableRawMaterials.put(materialName, Math.max(0, currentMaterialCount - materialCountNeeded));
                        } else {
                            System.out.println("Insufficient " + materialName + " for production of " + productName);
                        }
                    }
                    break;
                }
            }
        }
        return productionOrder;
    }
    
    public void procurementOrderDelivered(ProcurementOrder procurementOrder) {
        HashMap<String, Integer> deliveredRawMaterials = procurementOrder.getProcurementOrder();
        for (Map.Entry<String, Integer> entry : deliveredRawMaterials.entrySet()) {
            String rawMaterialName = entry.getKey();
            int quantity = entry.getValue();
            addRawMaterial(rawMaterialName, quantity);
        }
    }
    
    @Override
    public String toString() {
        return "ProductionAvailableRawMaterials{" + "productionAvailableRawMaterials=" + productionAvailableRawMaterials + '}';
    }
    
}
