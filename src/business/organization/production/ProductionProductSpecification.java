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

public class ProductionProductSpecification {
    
    private String productName;
    private HashMap<String, Integer> rawMaterialsRequired;
    private int productPricePerUnit;
    
    public ProductionProductSpecification() {
        this.rawMaterialsRequired = new HashMap<String, Integer>();
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public HashMap<String, Integer> getRawMaterialsRequired() {
        return rawMaterialsRequired;
    }
    
    public void setRawMaterialsRequired(HashMap<String, Integer> rawMaterialsRequired) {
        this.rawMaterialsRequired = rawMaterialsRequired;
    }
    
    public int getProductPricePerUnit() {
        return productPricePerUnit;
    }
    
    public void setProductPricePerUnit(int productPricePerUnit) {
        this.productPricePerUnit = productPricePerUnit;
    }
    
    public void addRawMaterialDetails(String rawMaterialName, int count) {
        if (rawMaterialsRequired.containsKey(rawMaterialName)) {
            int currentCount = rawMaterialsRequired.get(rawMaterialName);
            rawMaterialsRequired.put(rawMaterialName, currentCount + count);
        } else {
            rawMaterialsRequired.put(rawMaterialName, count);
        }
    }
    
    public void removeRawMaterialDetails(String rawMaterialName) {
        rawMaterialsRequired.remove(rawMaterialName);
    }
    
    @Override
    public String toString() {
        return "ProductSpecification{" + "productName=" + productName + ", rawMaterialsRequired=" + rawMaterialsRequired + ", productPricePerUnit=" + productPricePerUnit + '}';
    }
    
}
