/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.onlineShoppingStore;

/**
 *
 * @author sathi
 */

import java.util.ArrayList;

import business.organization.onlineShoppingStore.CustomerProductPrice;

public class CustomerProductPriceDirectory {
    
    private ArrayList<CustomerProductPrice> customerProductPriceList;

    public CustomerProductPriceDirectory() {
        this.customerProductPriceList = new ArrayList<CustomerProductPrice>();
    }

    public CustomerProductPriceDirectory(ArrayList<CustomerProductPrice> customerProductPriceList) {
        this.customerProductPriceList = customerProductPriceList;
    }

    public ArrayList<CustomerProductPrice> getCustomerProductPriceList() {
        return customerProductPriceList;
    }

    public void setCustomerProductPriceList(ArrayList<CustomerProductPrice> customerProductPriceList) {
        this.customerProductPriceList = customerProductPriceList;
    }
    
    public void addNewCustomerProductPrice(CustomerProductPrice customerProductPrice) {
        this.customerProductPriceList.add(customerProductPrice);
    }
    
    public void removeCustomerProductPrice(CustomerProductPrice customerProductPrice) {
        this.customerProductPriceList.remove(customerProductPrice);
    }

    @Override
    public String toString() {
        return "CustomerProductPriceDirectory{" + "customerProductPriceList=" + customerProductPriceList + '}';
    }
    
}
