/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.procurement;

/**
 *
 * @author sathi
 */

import java.util.ArrayList;

public class ProcurementRawMaterialsDirectory {
    
    private ArrayList<ProcurementRawMaterial> procurementRawMaterialsList;

    public ProcurementRawMaterialsDirectory() {
        this.procurementRawMaterialsList = new ArrayList<ProcurementRawMaterial>();
    }

    public ArrayList<ProcurementRawMaterial> getProcurementRawMaterialsList() {
        return procurementRawMaterialsList;
    }

    public void setProcurementRawMaterialsList(ArrayList<ProcurementRawMaterial> procurementRawMaterialsList) {
        this.procurementRawMaterialsList = procurementRawMaterialsList;
    }
    
    public void addProcurementRawMaterial(ProcurementRawMaterial procurementRawMaterial) {
        this.procurementRawMaterialsList.add(procurementRawMaterial);
    }
    
    public void removeProcurementRawMaterial(ProcurementRawMaterial procurementRawMaterial) {
        this.procurementRawMaterialsList.remove(procurementRawMaterial);
    }

    @Override
    public String toString() {
        return "ProcurementRawMaterialsDirectory{" + "procurementRawMaterialsList=" + procurementRawMaterialsList + '}';
    }
    
}
