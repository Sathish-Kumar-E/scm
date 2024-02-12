/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.consumerFoodDistribution;

/**
 *
 * @author sathi
 */

import business.organization.Organization;
import business.employee.EmployeeDirectory;

public class ConsumerFoodDistributionOrganization {
    
    private Organization organization;
    private int enterpriseId;
    private EmployeeDirectory employeeDirectory;
    
    public ConsumerFoodDistributionOrganization() {
    }

    public ConsumerFoodDistributionOrganization(Organization organization, int enterpriseId, EmployeeDirectory employeeDirectory) {
        this.organization = organization;
        this.enterpriseId = enterpriseId;
        this.employeeDirectory = employeeDirectory;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    @Override
    public String toString() {
        return "ConsumerFoodDistributionOrganization{" + "organization=" + organization + ", enterpriseId=" + enterpriseId + ", employeeDirectory=" + employeeDirectory + '}';
    }
    
}
