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

public class ProcurementOrderStatusDirectory {
    
    private ArrayList<ProcurementOrderStatus> procurementOrderStatusList;

    public ProcurementOrderStatusDirectory() {
        this.procurementOrderStatusList = new ArrayList<ProcurementOrderStatus>();
    }

    public ArrayList<ProcurementOrderStatus> getProcurementOrderStatusList() {
        return procurementOrderStatusList;
    }

    public void setProcurementOrderStatusList(ArrayList<ProcurementOrderStatus> procurementOrderStatusList) {
        this.procurementOrderStatusList = procurementOrderStatusList;
    }
    
    public void addNewProcurementOrderStatus(ProcurementOrderStatus procurementOrderStatus) {
        this.procurementOrderStatusList.add(procurementOrderStatus);
    }
    
    public void removeProcurementOrderStatus(ProcurementOrderStatus procurementOrderStatus) {
        this.procurementOrderStatusList.remove(procurementOrderStatus);
    }
    
    @Override
    public String toString() {
        return "ProcurementOrderStatusDirectory{" + "procurementOrderStatusList=" + procurementOrderStatusList + '}';
    }
    
}
