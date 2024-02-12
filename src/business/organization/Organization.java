/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

/**
 *
 * @author sathi
 */

public class Organization {
    
    private int organizationId;
    private String organizationName;
    private int enterpriseId;

    public Organization() {
    }

    public Organization(int organizationId, String organizationName, int entrepriseId) {
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.enterpriseId = entrepriseId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Override
    public String toString() {
        return "Organization{" + "organizationId=" + organizationId + ", organizationName=" + organizationName + ", entrepriseId=" + enterpriseId + '}';
    }
    
}
