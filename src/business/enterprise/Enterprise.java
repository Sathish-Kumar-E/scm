/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.enterprise;

/**
 *
 * @author sathi
 */

import java.util.ArrayList;

import business.organization.Organization;

public class Enterprise {
    
    private int enterpriseId;
    private String enterpriseName;
    private ArrayList<Organization> organizationList; 

    public Enterprise() {
        this.organizationList = new ArrayList<Organization>();
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public void addNewOrganization(Organization organization) {
        this.organizationList.add(organization);
    }
    
    public void removeOrganization(Organization organization) {
        this.organizationList.remove(organization);
    }

    @Override
    public String toString() {
        return "Entreprise{" + "entrepriseId=" + enterpriseId + ", entrepriseName=" + enterpriseName + ", organizationList=" + organizationList + '}';
    }
    
}
