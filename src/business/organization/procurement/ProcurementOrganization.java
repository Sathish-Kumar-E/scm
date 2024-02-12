/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.procurement;

/**
 *
 * @author sathi
 */

import business.organization.Organization;
import business.employee.EmployeeDirectory;

public class ProcurementOrganization {
    
    private Organization organization;
    private EmployeeDirectory employeeDirectory;
    private ProcurementAvailableRawMaterials procurementAvailableRawMaterials;
    private ProcurementOrderDirectory procurementOrderDirectory;
    private ProcurementRawMaterialsDirectory procurementRawMaterialsDirectory;
    private ProcurementOrderStatusDirectory procurementOrderStatusDirectory;
    
    public ProcurementOrganization() {
        this.organization = new Organization();
        this.employeeDirectory = new EmployeeDirectory();
        this.procurementAvailableRawMaterials = new ProcurementAvailableRawMaterials();
        this.procurementOrderDirectory = new ProcurementOrderDirectory();
        this.procurementRawMaterialsDirectory = new ProcurementRawMaterialsDirectory();
        this.procurementOrderStatusDirectory = new ProcurementOrderStatusDirectory();
    }
    
    public ProcurementOrganization(Organization organization, EmployeeDirectory employeeDirectory, ProcurementAvailableRawMaterials procurementAvailableRawMaterials, ProcurementOrderDirectory procurementOrderDirectory, ProcurementRawMaterialsDirectory procurementRawMaterialsDirectory, ProcurementOrderStatusDirectory procuementOrderStatusDirectory) {
        this.organization = organization;
        this.employeeDirectory = employeeDirectory;
        this.procurementAvailableRawMaterials = procurementAvailableRawMaterials;
        this.procurementOrderDirectory = procurementOrderDirectory;
        this.procurementRawMaterialsDirectory = procurementRawMaterialsDirectory;
        this.procurementOrderStatusDirectory = procuementOrderStatusDirectory;
    }
    
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public ProcurementAvailableRawMaterials getProcurementAvailableRawMaterials() {
        return procurementAvailableRawMaterials;
    }

    public void setProcurementAvailableRawMaterials(ProcurementAvailableRawMaterials procurementAvailableRawMaterials) {
        this.procurementAvailableRawMaterials = procurementAvailableRawMaterials;
    }

    public ProcurementOrderDirectory getProcurementOrderDirectory() {
        return procurementOrderDirectory;
    }

    public void setProcurementOrderDirectory(ProcurementOrderDirectory procurementOrderDirectory) {
        this.procurementOrderDirectory = procurementOrderDirectory;
    }

    public ProcurementRawMaterialsDirectory getProcurementRawMaterialsDirectory() {
        return procurementRawMaterialsDirectory;
    }

    public void setProcurementRawMaterialsDirectory(ProcurementRawMaterialsDirectory procurementRawMaterialsDirectory) {
        this.procurementRawMaterialsDirectory = procurementRawMaterialsDirectory;
    }

    public ProcurementOrderStatusDirectory getProcurementOrderStatusDirectory() {
        return procurementOrderStatusDirectory;
    }

    public void setProcurementOrderStatusDirectory(ProcurementOrderStatusDirectory procurementOrderStatusDirectory) {
        this.procurementOrderStatusDirectory = procurementOrderStatusDirectory;
    }
    
    @Override
    public String toString() {
        return "ProcurementOrganization{" + "organization=" + organization + ", employeeDirectory=" + employeeDirectory + ", procurementAvailableRawMaterials=" + procurementAvailableRawMaterials + ", procurementOrderDirectory=" + procurementOrderDirectory + ", procurementRawMaterialsDirectory=" + procurementRawMaterialsDirectory + '}';
    }
    
}
