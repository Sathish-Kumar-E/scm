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

public class CustomerOrderDirectory {
    
    private ArrayList<CustomerOrder> customerOrderList;

    public CustomerOrderDirectory() {
        this.customerOrderList = new ArrayList<CustomerOrder>();
    }

    public ArrayList<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomerOrderList(ArrayList<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }
    
    public void addCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrderList.add(customerOrder);
    }
    
    public void removeCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrderList.remove(customerOrder);
    }

    @Override
    public String toString() {
        return "CustomerOrderDirectory{" + "customerOrderList=" + customerOrderList + '}';
    }
    
}
