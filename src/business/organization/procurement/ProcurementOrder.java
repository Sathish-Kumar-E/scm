/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.procurement;

/**
 *
 * @author sathi
 */

import java.util.HashMap;

public class ProcurementOrder {
    
    private int procurementOrderId;
    private HashMap<String, Integer> procurementOrder;
    private String status;
    private int procurementOrderPrice;
    private String procurementInitiatedBy;
    private String procurementApprovedBy = "Not Approved Yet";
    private String procurementPackingAssignedTo = "Not Assigned Yet";
    private String procurementPackingCompletedBy = "Not Completed Yet";
    private String procurementDeliveryAssignedTo = "Not Assigned Yet";
    private String procurementDeliveryPickedBy = "Not Picked Yet";
    private String procurementDeliveryCompletedBy = "Not Delivered Yet";
    
    public ProcurementOrder() {
        this.procurementOrder = new HashMap<String, Integer>();
    }
    
    public ProcurementOrder(int procurementOrderId, HashMap<String, Integer> procurementOrder, String status) {
        this.procurementOrderId = procurementOrderId;
        this.procurementOrder = procurementOrder;
        this.status = status;
    }
    
    public int getProcurementOrderId() {
        return procurementOrderId;
    }
    
    public void setProcurementOrderId(int procurementOrderId) {
        this.procurementOrderId = procurementOrderId;
    }
    
    public HashMap<String, Integer> getProcurementOrder() {
        return procurementOrder;
    }
    
    public void setProcurementOrder(HashMap<String, Integer> procurementOrder) {
        this.procurementOrder = procurementOrder;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getProcurementOrderPrice() {
        return procurementOrderPrice;
    }
    
    public void setProcurementOrderPrice(int procurementOrderPrice) {
        this.procurementOrderPrice = procurementOrderPrice;
    }
    
    public String getProcurementInitiatedBy() {
        return procurementInitiatedBy;
    }
    
    public void setProcurementInitiatedBy(String procurementInitiatedBy) {
        this.procurementInitiatedBy = procurementInitiatedBy;
    }
    
    public String getProcurementApprovedBy() {
        return procurementApprovedBy;
    }
    
    public void setProcurementApprovedBy(String procurementApprovedBy) {
        this.procurementApprovedBy = procurementApprovedBy;
    }
    
    public String getProcurementPackingAssignedTo() {
        return procurementPackingAssignedTo;
    }
    
    public void setProcurementPackingAssignedTo(String procurementPackingAssignedTo) {
        this.procurementPackingAssignedTo = procurementPackingAssignedTo;
    }
    
    public String getProcurementPackingCompletedBy() {
        return procurementPackingCompletedBy;
    }
    
    public void setProcurementPackingCompletedBy(String procurementPAckingCompletedBy) {
        this.procurementPackingCompletedBy = procurementPAckingCompletedBy;
    }
    
    public String getProcurementDeliveryAssignedTo() {
        return procurementDeliveryAssignedTo;
    }
    
    public void setProcurementDeliveryAssignedTo(String procurementDeliveryAssignedTo) {
        this.procurementDeliveryAssignedTo = procurementDeliveryAssignedTo;
    }
    
    public String getProcurementDeliveryPickedBy() {
        return procurementDeliveryPickedBy;
    }
    
    public void setProcurementDeliveryPickedBy(String procurementDeliveryPickedBy) {
        this.procurementDeliveryPickedBy = procurementDeliveryPickedBy;
    }
    
    public String getProcurementDeliveryCompletedBy() {
        return procurementDeliveryCompletedBy;
    }
    
    public void setProcurementDeliveryCompletedBy(String procurementDeliveryCompletedBy) {
        this.procurementDeliveryCompletedBy = procurementDeliveryCompletedBy;
    }
    
    public void addRawMaterialToProcurementOrderList(String rawMaterialName, int count) {
        if (procurementOrder.containsKey(rawMaterialName)) {
            int currentCount = procurementOrder.get(rawMaterialName);
            procurementOrder.put(rawMaterialName, currentCount + count);
        } else {
            procurementOrder.put(rawMaterialName, count);
        }
    }
    
    public void removeRawMaterialFromProcurementOrderList(String rawMaterialName) {
        procurementOrder.remove(rawMaterialName);
    }
    
    @Override
    public String toString() {
        return String.valueOf(procurementOrderId);
    }
    
}
