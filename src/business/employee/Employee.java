/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.employee;

/**
 *
 * @author sathi
 */

import business.person.Person;

public class Employee {
    
    private Person person;
    private String enterprise;
    private String organization;
    private String role;
    private int salary;
    
    public Employee() {
    }
    
    public Employee(Person person, String enterprise, String organization, String role, int salary) {
        this.person = person;
        this.enterprise = enterprise;
        this.organization = organization;
        this.role = role;
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "person=" + person + ", enterprise=" + enterprise + ", organization=" + organization + ", role=" + role + ", salary=" + salary + '}';
    }
    
}
