/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

/**
 *
 * @author sathi
 */

import java.util.ArrayList;

public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        this.organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public Organization addNewOrganization() {
        Organization organization = new Organization();
        this.organizationList.add(organization);
        return organization;
    }
    
    public void deleteOrganization(Organization organization) {
        this.organizationList.remove(organization);
    }
    
}
