/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.onlineShoppingStore;

/**
 *
 * @author sathi
 */

import java.util.HashMap;

public class CustomerOrder {
    
    private int id;
    private HashMap<String, Integer> items;
    private int orderPrice;
    private String status;
    private String driver;
    private String username;
    
    public CustomerOrder() {
        this.items = new HashMap<String, Integer>();
    }
    
    public CustomerOrder(int id, HashMap<String, Integer> items, int orderPrice, String status, String driver) {
        this.id = id;
        this.items = items;
        this.orderPrice = orderPrice;
        this.status = status;
        this.driver = driver;
    }

    public CustomerOrder(int id, HashMap<String, Integer> items, int orderPrice, String status, String driver, String username) {
        this.id = id;
        this.items = items;
        this.orderPrice = orderPrice;
        this.status = status;
        this.driver = driver;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public HashMap<String, Integer> getItems() {
        return items;
    }
    
    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }
    
    public int getOrderPrice() {
        return orderPrice;
    }
    
    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDriver() {
        return driver;
    }
    
    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    @Override
    public String toString() {
        return "CustomerOrder{" + "id=" + id + ", items=" + items + ", orderPrice=" + orderPrice + ", status=" + status + ", driver=" + driver + '}';
    }
    
}
