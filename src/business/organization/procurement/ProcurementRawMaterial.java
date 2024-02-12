/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.procurement;

/**
 *
 * @author sathi
 */

public class ProcurementRawMaterial {
    
    private int id;
    private String rawMaterialName;
    private int pricePerUnit;

    public ProcurementRawMaterial() {
    }

    public ProcurementRawMaterial(int id, String rawMaterialName, int pricePerUnit) {
        this.id = id;
        this.rawMaterialName = rawMaterialName;
        this.pricePerUnit = pricePerUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "RawMaterial{" + "id=" + id + ", rawMaterialName=" + rawMaterialName + ", pricePerUnit=" + pricePerUnit + '}';
    }
    
}
