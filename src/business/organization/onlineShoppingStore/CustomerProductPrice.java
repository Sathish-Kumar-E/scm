/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization.onlineShoppingStore;

/**
 *
 * @author sathi
 */

public class CustomerProductPrice {
    
    private String name;
    private int price;

    public CustomerProductPrice() {
    }

    public CustomerProductPrice(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomerProductPrice{" + "name=" + name + ", price=" + price + '}';
    }
    
}
