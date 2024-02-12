/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.employee;

/**
 *
 * @author sathi
 */

import java.util.ArrayList;

public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public void addNewEmployee(Employee employee) {
        this.employeeList.add(employee);
    }
    
    public void removeEmployee(Employee employee) {
        this.employeeList.remove(employee);
    }
    
}
