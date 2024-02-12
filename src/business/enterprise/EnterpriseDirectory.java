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

public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        this.enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public void addNewEntreprise(Enterprise entreprise) {
        this.enterpriseList.add(entreprise);
    }
    
    public void deleteEntreprise(Enterprise entreprise) {
        this.enterpriseList.remove(entreprise);
    }
    
}
