/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.procurement;

/**
 *
 * @author sathi
 */

import java.util.Map;
import java.util.HashMap;

public class ProcurementAvailableRawMaterials {
    
    private HashMap<String, Integer> procurementAvailableRawMaterials;
    
    public ProcurementAvailableRawMaterials() {
        this.procurementAvailableRawMaterials = new HashMap<String, Integer>();
    }
    
    public HashMap<String, Integer> getProcurementAvailableRawMaterials() {
        return procurementAvailableRawMaterials;
    }
    
    public void setProcurementAvailableRawMaterials(HashMap<String, Integer> procurementAvailableRawMaterials) {
        this.procurementAvailableRawMaterials = procurementAvailableRawMaterials;
    }
    
    public void addRawMaterial(String rawMaterialName, int count) {
        if (procurementAvailableRawMaterials.containsKey(rawMaterialName)) {
            int currentCount = procurementAvailableRawMaterials.get(rawMaterialName);
            procurementAvailableRawMaterials.put(rawMaterialName, currentCount + count);
        } else {
            procurementAvailableRawMaterials.put(rawMaterialName, count);
        }
    }
    
    public void removeRawMaterial(String rawMaterialName, int count) {
        if (procurementAvailableRawMaterials.containsKey(rawMaterialName)) {
            int currentCount = procurementAvailableRawMaterials.get(rawMaterialName);
            int newCount = Math.max(0, currentCount - count);
            if (newCount == 0) {
                procurementAvailableRawMaterials.remove(rawMaterialName);
            } else {
                procurementAvailableRawMaterials.put(rawMaterialName, newCount);
            }
        } else {
            System.out.println("Raw Material doesn't exist");
        }
    }
    
    public boolean checkForAvailableStock(HashMap<String, Integer> procurementOrder) {
        for (Map.Entry<String, Integer> orderEntry : procurementOrder.entrySet()) {
            String rawMaterialName = orderEntry.getKey();
            int requiredQuantity = orderEntry.getValue();
            if (!procurementAvailableRawMaterials.containsKey(rawMaterialName)) {
                return false;
            }
            int availableQuantity = procurementAvailableRawMaterials.get(rawMaterialName);
            if (availableQuantity < requiredQuantity) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkProcurementOrder(ProcurementOrder procurementOrder) {
        HashMap<String, Integer> requiredRawMaterials = procurementOrder.getProcurementOrder();
        for (Map.Entry<String, Integer> entry : requiredRawMaterials.entrySet()) {
            String rawMaterialName = entry.getKey();
            int requiredQuantity = entry.getValue();
            if (!procurementAvailableRawMaterials.containsKey(rawMaterialName) || procurementAvailableRawMaterials.get(rawMaterialName) < requiredQuantity) {
                return false; // Not enough raw material available
            }
        }
        return true;
    }
    
    public boolean processProcurementOrder(ProcurementOrder procurementOrder) {
        HashMap<String, Integer> requiredRawMaterials = procurementOrder.getProcurementOrder();
        if (!checkForAvailableStock(requiredRawMaterials)) {
            return false;
        }
        for (Map.Entry<String, Integer> orderEntry : requiredRawMaterials.entrySet()) {
            String rawMaterialName = orderEntry.getKey();
            int requiredQuantity = orderEntry.getValue();
            int availableQuantity = procurementAvailableRawMaterials.get(rawMaterialName);
            procurementAvailableRawMaterials.put(rawMaterialName, availableQuantity - requiredQuantity);
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ProcumentAvailableRawMaterials{" + "procurementAvailableRawMaterials=" + procurementAvailableRawMaterials + '}';
    }
    
}
