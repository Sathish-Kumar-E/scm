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

public class ProcurementOrderDirectory {
    
    private ArrayList<ProcurementOrder> procurementOrderList;

    public ProcurementOrderDirectory() {
        this.procurementOrderList = new ArrayList<ProcurementOrder>();
    }

    public ArrayList<ProcurementOrder> getProcurementOrderList() {
        return procurementOrderList;
    }

    public void setProcurementOrderList(ArrayList<ProcurementOrder> procurementOrderList) {
        this.procurementOrderList = procurementOrderList;
    }
    
    public void addProcurementOrder(ProcurementOrder procurementOrder) {
        this.procurementOrderList.add(procurementOrder);
    }
    
    public void removeProcurementOrder(ProcurementOrder procurementOrder) {
        this.procurementOrderList.remove(procurementOrder);
    }

    @Override
    public String toString() {
        return "ProcurementOrderDirectory{" + "procurementOrderList=" + procurementOrderList + '}';
    }
    
}
