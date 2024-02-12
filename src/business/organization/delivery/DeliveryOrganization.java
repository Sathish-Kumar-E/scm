/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.delivery;

/**
 *
 * @author sathi
 */

import business.organization.Organization;
import business.employee.EmployeeDirectory;

public class DeliveryOrganization {

    private Organization organization;
    private EmployeeDirectory employeeDirectory;

    public DeliveryOrganization() {
        this.organization = new Organization();
        this.employeeDirectory = new EmployeeDirectory();
    }

    public DeliveryOrganization(Organization organization, EmployeeDirectory employeeDirectory) {
        this.organization = organization;
        this.employeeDirectory = employeeDirectory;
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

    @Override
    public String toString() {
        return "DeliveryOrganization{" + "organization=" + organization + ", employeeDirectory=" + employeeDirectory + '}';
    }
    
}
