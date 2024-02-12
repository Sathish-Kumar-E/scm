/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.person;

/**
 *
 * @author sathi
 */

public class Person {
    
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phNo;
    private String userName;
    private String password;
    
    public Person() {
    }

    public Person(int id, String firstName, String lastName, String emailId, String phNo, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phNo = phNo;
        this.userName = userName;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public String getPhNo() {
        return phNo;
    }
    
    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phNo=" + phNo + ", userName=" + userName + ", password=" + password + '}';
    }
    
}
