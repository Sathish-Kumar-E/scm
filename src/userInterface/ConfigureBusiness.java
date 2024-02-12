/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userInterface;

/**
 *
 * @author sathi
 */

import java.util.ArrayList;
import java.util.HashMap;

import business.organization.procurement.*;
import business.organization.production.*;
import business.organization.commodityConveyance.*;
import business.organization.consumerFoodDistribution.*;
import business.organization.onlineShoppingStore.*;
import business.person.*;
import business.employee.*;

public class ConfigureBusiness {
    
    private Business business;
    
    private ProcurementAvailableRawMaterials procurementAvailableRawMaterials;
    private ProcurementOrder procurementOrder;
    private ProcurementOrderDirectory procurementOrderDirectory;
    private ProcurementOrganization procurementOrganization;
    private ProcurementRawMaterial procurementRawMaterial;
    private ProcurementRawMaterialsDirectory procurementRawMaterialsDirectory;
    private ProcurementOrderStatusDirectory procurementOrderStatusDirectory;
    private ProductionAvailableProducts productionAvailableProducts;
    private ProductionOrganization productionOrganization;
    private ProductionAvailableRawMaterials productionAvailableRawMaterials;
    private ProductionOrderStatusDirectory productionOrderStatusDirectory;
    private ProductionOrderDirectory productionOrderDirectory;
    private ProductionProductSpecificationDirectory productionProductSpecificationDirectory;
    private PersonDirectory personDirectory;
    private CommodityConveyanceOrganization commodityConveyanceOrganization;
    private ConsumerFoodDistributionOrganization consumerFoodDistributionOrganization;
    private OnlineShoppingStoreOrganization onlineShoppingStoreOrganization;
    private InStockProducts inStockProducts;
    private CustomerProductPriceDirectory customerProductPriceDirectory;
    
    public ConfigureBusiness() {
        this.business = new Business();
        this.procurementAvailableRawMaterials = new ProcurementAvailableRawMaterials();
        this.procurementOrderDirectory = new ProcurementOrderDirectory();
        this.procurementRawMaterialsDirectory = new ProcurementRawMaterialsDirectory();
        this.procurementOrganization = new ProcurementOrganization();
        this.procurementOrderStatusDirectory = new ProcurementOrderStatusDirectory();
        this.productionAvailableProducts = new ProductionAvailableProducts();
        this.productionOrganization = new ProductionOrganization();
        this.productionAvailableRawMaterials = new ProductionAvailableRawMaterials();
        this.productionOrderStatusDirectory = new ProductionOrderStatusDirectory();
        this.productionOrderDirectory = new ProductionOrderDirectory();
        this.productionProductSpecificationDirectory = new ProductionProductSpecificationDirectory();
        this.personDirectory = new PersonDirectory();
        this.commodityConveyanceOrganization = new CommodityConveyanceOrganization();
        this.consumerFoodDistributionOrganization = new ConsumerFoodDistributionOrganization();
        this.onlineShoppingStoreOrganization = new OnlineShoppingStoreOrganization();
        this.inStockProducts = new InStockProducts();
        this.customerProductPriceDirectory = new CustomerProductPriceDirectory();
    }
    
    public Business getBusinessData() {
        ProcurementRawMaterial potato = new ProcurementRawMaterial(1, "Potato", 3);
        ProcurementRawMaterial orange = new ProcurementRawMaterial(2, "Orange", 4);
        ProcurementRawMaterial mango = new ProcurementRawMaterial(3, "Mango", 2);
        ProcurementRawMaterial water = new ProcurementRawMaterial(4, "Water", 1);
        ProcurementRawMaterial sugar = new ProcurementRawMaterial(5, "Sugar", 1);
        ProcurementRawMaterial juiceBottles = new ProcurementRawMaterial(6, "Juice Bottles", 1);
        ProcurementRawMaterial waterBottles = new ProcurementRawMaterial(7, "Water Bottles", 1);
        ProcurementRawMaterial chipsBag = new ProcurementRawMaterial(8, "Chips Bag", 1);
        ProcurementRawMaterial salt = new ProcurementRawMaterial(9, "Salt", 1);
        
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(potato);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(orange);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(mango);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(water);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(sugar);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(juiceBottles);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(waterBottles);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(chipsBag);
        this.procurementRawMaterialsDirectory.addProcurementRawMaterial(salt);
        
        this.procurementAvailableRawMaterials.addRawMaterial("Potato", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Orange", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Mango", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Water", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Sugar", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Juice Bottles", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Water Bottles", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Chips Bag", 10);
        this.procurementAvailableRawMaterials.addRawMaterial("Salt", 10);
        
        ProcurementOrder procurementOrder1 = new ProcurementOrder();
        procurementOrder1.setProcurementOrderId(1);
        procurementOrder1.setStatus("Initiated");
        HashMap<String, Integer> rawMaterials1 = new HashMap<String, Integer>();
        rawMaterials1.put("Water", Integer.valueOf(1));
        rawMaterials1.put("Potato", Integer.valueOf(4));
        rawMaterials1.put("Orange", Integer.valueOf(2));
        procurementOrder1.setProcurementOrder(rawMaterials1);
        
        ProcurementOrder procurementOrder2 = new ProcurementOrder();
        procurementOrder2.setProcurementOrderId(2);
        procurementOrder2.setStatus("Procurement Approved");
        HashMap<String, Integer> rawMaterials2 = new HashMap<String, Integer>();
        rawMaterials2.put("Mango", Integer.valueOf(3));
        rawMaterials2.put("Sugar", Integer.valueOf(2));
        rawMaterials2.put("Chips Bag", Integer.valueOf(5));
        rawMaterials2.put("Water Bottles", Integer.valueOf(7));
        rawMaterials2.put("Juice Bottles", Integer.valueOf(1));
        procurementOrder2.setProcurementOrder(rawMaterials2);
        
        this.procurementOrderDirectory.addProcurementOrder(procurementOrder1);
        this.procurementOrderDirectory.addProcurementOrder(procurementOrder2);
        
        ProcurementOrderStatus procurementOrderStatus_01 = new ProcurementOrderStatus(1, "Initiated", "");
        ProcurementOrderStatus procurementOrderStatus_02 = new ProcurementOrderStatus(2, "Procurement Approved", "");
        ProcurementOrderStatus procurementOrderStatus_03 = new ProcurementOrderStatus(3, "Procurement Rejected", "");
        ProcurementOrderStatus procurementOrderStatus_04 = new ProcurementOrderStatus(4, "Packing Completed", "");
        ProcurementOrderStatus procurementOrderStatus_05 = new ProcurementOrderStatus(5,"Transportation Assigned","");
        ProcurementOrderStatus procurementOrderStatus_06 = new ProcurementOrderStatus(6,"Delivery Completed","");
        
        this.procurementOrderStatusDirectory.addNewProcurementOrderStatus(procurementOrderStatus_01);
        this.procurementOrderStatusDirectory.addNewProcurementOrderStatus(procurementOrderStatus_02);
        this.procurementOrderStatusDirectory.addNewProcurementOrderStatus(procurementOrderStatus_03);
        this.procurementOrderStatusDirectory.addNewProcurementOrderStatus(procurementOrderStatus_04);
        this.procurementOrderStatusDirectory.addNewProcurementOrderStatus(procurementOrderStatus_05);
        this.procurementOrderStatusDirectory.addNewProcurementOrderStatus(procurementOrderStatus_06);
        
        Person person_01 = new Person(1, "Virat", "Kohli", "virat_kohli@gmail.com", "+1-(857)-222-3748", "virat.kohli", "RCB18");
        Person person_02 = new Person(2, "Rohit", "Sharma", "rohit_sharma@gmail.com", "+1-(857)-293-2812", "rohit.sharma", "MI45");
        Person person_03 = new Person(3, "MS", "Dhoni", "ms_dhoni@gmail.com", "+1-(763)-232-3049", "ms.dhoni", "CSK07");
        Person person_04 = new Person(4, "Virendar", "Sehwag", "virendar_sehwag@gmail.com", "+1-(726)-304-2938", "virendar.sehwag", "VS300s");
        
        this.personDirectory.addNewPerson(person_01);
        this.personDirectory.addNewPerson(person_02);
        this.personDirectory.addNewPerson(person_03);
        this.personDirectory.addNewPerson(person_04);
        
        Employee employee_01 = new Employee(person_01, "Manufacturing", "Procurement", "Procurement Manager", 30000);
        Employee employee_02 = new Employee(person_02, "Manufacturing", "Procurement", "Procurement Manager", 30000);
        
        Employee employee_03 = new Employee(person_03, "Manufacturing", "Procurement", "Packing Supervisor", 17000);
        Employee employee_04 = new Employee(person_04, "Manufacturing", "Procurement", "Packing Supervisor", 13000);
        
        EmployeeDirectory procurementEmployees = new EmployeeDirectory();
        procurementEmployees.addNewEmployee(employee_01);
        procurementEmployees.addNewEmployee(employee_02);
        procurementEmployees.addNewEmployee(employee_03);
        procurementEmployees.addNewEmployee(employee_04);
        
        this.procurementOrganization.setEmployeeDirectory(procurementEmployees);
        
        this.procurementOrganization.setProcurementAvailableRawMaterials(procurementAvailableRawMaterials);
        this.procurementOrganization.setProcurementRawMaterialsDirectory(procurementRawMaterialsDirectory);
        this.procurementOrganization.setProcurementOrderDirectory(procurementOrderDirectory);
        this.procurementOrganization.setProcurementOrderStatusDirectory(procurementOrderStatusDirectory);
        
        Person person_09 = new Person(9, "Rajat","Patidar","rajat.patidar@gmail.com","+1-(029)-203-4837","rajat.patidar","RCB113");
        Person person_10 = new Person(10, "Sanju", "Samson","sanju.samson@gmail.com","+1-(293)-018-2038","sanju.samson","CSK2023");
        
        this.personDirectory.addNewPerson(person_09);
        this.personDirectory.addNewPerson(person_10);
        
        Employee employee_09 = new Employee(person_09,"Logistics","Commodity Conveyance", "Freight Truck Driver", 15000);
        Employee employee_10 = new Employee(person_10,"Logistics","Commodity Conveyance", "Freight Truck Driver",12000);
        
        EmployeeDirectory commodityConveyanceEmployees = new EmployeeDirectory();
        commodityConveyanceEmployees.addNewEmployee(employee_09);
        commodityConveyanceEmployees.addNewEmployee(employee_10);
        
        this.commodityConveyanceOrganization.setEmployeeDirectory(commodityConveyanceEmployees);
        
        this.productionAvailableProducts.addNewProductionAvailableProducts("Potato Chips",Integer.valueOf(5));
        this.productionAvailableProducts.addNewProductionAvailableProducts("Orange Juice",Integer.valueOf(10));
        this.productionAvailableProducts.addNewProductionAvailableProducts("Water Bottles",Integer.valueOf(7));
        this.productionAvailableProducts.addNewProductionAvailableProducts("Mango Juice",Integer.valueOf(8));
        
        this.productionAvailableRawMaterials.addRawMaterial("Water", 10);
        this.productionAvailableRawMaterials.addRawMaterial("Potato", 17);
        this.productionAvailableRawMaterials.addRawMaterial("Salt", 12);
        this.productionAvailableRawMaterials.addRawMaterial("Juice Bottles", 30);
        this.productionAvailableRawMaterials.addRawMaterial("Mango", 22);
        this.productionAvailableRawMaterials.addRawMaterial("Water Bottles", 35);
        this.productionAvailableRawMaterials.addRawMaterial("Chips Bag", 18);
        this.productionAvailableRawMaterials.addRawMaterial("Orange", 25);
        this.productionAvailableRawMaterials.addRawMaterial("Sugar", 27);
        
        ProductionOrderStatus pos_01 = new ProductionOrderStatus(1, "Initiated", "");
        ProductionOrderStatus pos_02 = new ProductionOrderStatus(2,"Production Approved","");
        ProductionOrderStatus pos_03 = new ProductionOrderStatus(3,"Production Rejected","");
        ProductionOrderStatus pos_04 = new ProductionOrderStatus(4,"Production Completed","");
        ProductionOrderStatus pos_05 = new ProductionOrderStatus(5,"Transportation Assigned","");
        ProductionOrderStatus pos_06 = new ProductionOrderStatus(6,"Delivery Picked","");
        ProductionOrderStatus pos_07 = new ProductionOrderStatus(7,"Delivery Completed","");
        
        this.productionOrderStatusDirectory.addNewProductionOrderStatus(pos_01);
        this.productionOrderStatusDirectory.addNewProductionOrderStatus(pos_02);
        this.productionOrderStatusDirectory.addNewProductionOrderStatus(pos_03);
        this.productionOrderStatusDirectory.addNewProductionOrderStatus(pos_04);
        this.productionOrderStatusDirectory.addNewProductionOrderStatus(pos_05);
        this.productionOrderStatusDirectory.addNewProductionOrderStatus(pos_06);
        this.productionOrderStatusDirectory.addNewProductionOrderStatus(pos_07);
        
        HashMap<String, Integer> productionOrderProducts1 = new HashMap<>();
        productionOrderProducts1.put("Potato Chips", 20);
        productionOrderProducts1.put("Orange Juice", 15);
        ProductionOrder productionOrder1 = new ProductionOrder(1, productionOrderProducts1, "Production Approved");
        
        HashMap<String, Integer> productionOrderProducts2 = new HashMap<>();
        productionOrderProducts2.put("Mango Juice", 13);
        productionOrderProducts2.put("Water Bottles", 11);
        ProductionOrder productionOrder2 = new ProductionOrder(2, productionOrderProducts2, "Production Approved");
        
        HashMap<String, Integer> productionOrderProducts3 = new HashMap<>();
        productionOrderProducts3.put("Mango Juice", 27);
        productionOrderProducts3.put("Orange Juice", 18);
        ProductionOrder productionOrder3 = new ProductionOrder(3, productionOrderProducts3, "Production Approved");
        
        this.productionOrderDirectory.addNewProductionOrder(productionOrder1);
        this.productionOrderDirectory.addNewProductionOrder(productionOrder2);
        this.productionOrderDirectory.addNewProductionOrder(productionOrder3);
        
        ProductionProductSpecification pps_01 = new ProductionProductSpecification();
        pps_01.setProductName("Potato Chips");
        pps_01.addRawMaterialDetails("Potato", 1);
        pps_01.addRawMaterialDetails("Salt", 1);
        pps_01.addRawMaterialDetails("Chips Bag", 1);
        pps_01.setProductPricePerUnit(15);
        
        ProductionProductSpecification pps_02 = new ProductionProductSpecification();
        pps_02.setProductName("Mango Juice");
        pps_02.addRawMaterialDetails("Mango", 1);
        pps_02.addRawMaterialDetails("Water", 1);
        pps_02.addRawMaterialDetails("Juice Bottles", 1);
        pps_02.addRawMaterialDetails("Sugar", 1);
        pps_02.setProductPricePerUnit(20);
        
        ProductionProductSpecification pps_03 = new ProductionProductSpecification();
        pps_03.setProductName("Orange Juice");
        pps_03.addRawMaterialDetails("Orange", 1);
        pps_03.addRawMaterialDetails("Water", 1);
        pps_03.addRawMaterialDetails("Juice Bottles", 1);
        pps_03.addRawMaterialDetails("Sugar", 1);
        pps_03.setProductPricePerUnit(14);
        
        ProductionProductSpecification pps_04 = new ProductionProductSpecification();
        pps_04.setProductName("Water Bottles");
        pps_04.addRawMaterialDetails("Water Bottles", 1);
        pps_04.addRawMaterialDetails("Water", 1);
        pps_04.setProductPricePerUnit(17);
        
        this.productionProductSpecificationDirectory.addNewProductionProductSpecification(pps_01);
        this.productionProductSpecificationDirectory.addNewProductionProductSpecification(pps_02);
        this.productionProductSpecificationDirectory.addNewProductionProductSpecification(pps_03);
        this.productionProductSpecificationDirectory.addNewProductionProductSpecification(pps_04);
        
        Person person_05 = new Person(5, "Sachin", "Tendulkar", "sachin_tendulkar@gmail.com", "+1-(830)-293-4059", "sachin.tendulkar", "MI10");
        Person person_06 = new Person(6, "Chris", "Gayle", "chris_gayle@gmail.com", "+1-(283)-224-9302", "chris.gayle", "RCB175");
        Person person_07 = new Person(7, "Yuvraj", "Singh", "yuvraj_singh@gmail.com", "+1-(364)-293-2019", "yuvraj.singh", "IND36");
        Person person_08 = new Person(8, "AB", "de Villiers", "ab_de_villiers@gmail.com", "+1-(283)-271-2093", "ab.de.villiers", "RCB133");
        
        this.personDirectory.addNewPerson(person_05);
        this.personDirectory.addNewPerson(person_06);
        this.personDirectory.addNewPerson(person_07);
        this.personDirectory.addNewPerson(person_08);
        
        Employee employee_05 = new Employee(person_05, "Manufacturing", "Production", "Production Manager", 35000);
        Employee employee_06 = new Employee(person_06, "Manufacturing", "Production", "Production Manager", 31000);
        
        Employee employee_07 = new Employee(person_07, "Manufacturing", "Production", "Manufacturing Engineer", 17000);
        Employee employee_08 = new Employee(person_08, "Manufacturing", "Production", "Manufacturing Engineer", 15000);
        
        EmployeeDirectory productionEmployees = new EmployeeDirectory();
        productionEmployees.addNewEmployee(employee_05);
        productionEmployees.addNewEmployee(employee_06);
        productionEmployees.addNewEmployee(employee_07);
        productionEmployees.addNewEmployee(employee_08);
        
        this.productionOrganization.setEmployeeDirectory(productionEmployees);
        
        this.productionOrganization.setProductionAvailableProducts(this.productionAvailableProducts);
        this.productionOrganization.setProductionAvailableRawMaterials(this.productionAvailableRawMaterials);
        this.productionOrganization.setProductionOrderStatusDirectory(this.productionOrderStatusDirectory);
        this.productionOrganization.setProductionOrderDirectory(this.productionOrderDirectory);
        this.productionOrganization.setProductionProductSpecificationDirectory(this.productionProductSpecificationDirectory);
        
        this.inStockProducts.addProduct("Potato Chips", 30);
        this.inStockProducts.addProduct("Mango Juice", 50);
        this.inStockProducts.addProduct("Orange Juice", 20);
        this.inStockProducts.addProduct("Water Bottles", 70);
        
        CustomerProductPrice cpp_01 = new CustomerProductPrice("Potato Chips", 15);
        CustomerProductPrice cpp_02 = new CustomerProductPrice("Mango Juice", 12);
        CustomerProductPrice cpp_03 = new CustomerProductPrice("Orange Juice", 18);
        CustomerProductPrice cpp_04 = new CustomerProductPrice("Water Bottles", 13);
        
        this.customerProductPriceDirectory.addNewCustomerProductPrice(cpp_01);
        this.customerProductPriceDirectory.addNewCustomerProductPrice(cpp_02);
        this.customerProductPriceDirectory.addNewCustomerProductPrice(cpp_03);
        this.customerProductPriceDirectory.addNewCustomerProductPrice(cpp_04);
        
        Person person_11 = new Person(11, "Praveen","Kumar","praveen_kumar@gmail.com","+1-(928)-283-0982","praveen.kumar","RCB08");
        this.personDirectory.addNewPerson(person_11);
        
        Employee employee_11 = new Employee(person_11, "Logistics", "Consumer Food Distribution", "Cullinary Freight Operator", 16000);
        
        EmployeeDirectory consumerFoodDistributionDrivers = new EmployeeDirectory();
        consumerFoodDistributionDrivers.addNewEmployee(employee_11);
        
        this.consumerFoodDistributionOrganization.setEmployeeDirectory(consumerFoodDistributionDrivers);
        
        Person person_12 = new Person(12, "Suresh","Raina","suresh_raina@gmail.com","+1-(876)-283-0394","suresh.raina","CSKSR");
        Employee employee_12 = new Employee(person_12,"Sales","Online Shopping Store","Retailer",10000);
        
        Person person_13 = new Person(13, "Gautham","Gambhir", "gautham.gambhir@gmail.com", "+1-(029)-203-2931", "gautham.gambhir", "WC97");
        Employee employee_13 = new Employee(person_13, "Sales", "Online Shopping Store", "Customer",10000);
        
        EmployeeDirectory onlineShoppingStoreEmployees = new EmployeeDirectory();
        onlineShoppingStoreEmployees.addNewEmployee(employee_12);
        onlineShoppingStoreEmployees.addNewEmployee(employee_13);
        
        this.onlineShoppingStoreOrganization.setEmployeeDirectory(onlineShoppingStoreEmployees);
        this.onlineShoppingStoreOrganization.setInStockProducts(this.inStockProducts);
        this.onlineShoppingStoreOrganization.setCustomerProductPriceDirectory(customerProductPriceDirectory);
        
        this.business.setPersonDirectory(this.personDirectory);
        this.business.setProcurementOrganization(procurementOrganization);
        this.business.setProductionOrganization(productionOrganization);
        this.business.setCommodityConveyanceOrganization(commodityConveyanceOrganization);
        this.business.setConsumerFoodDistributionOrganization(consumerFoodDistributionOrganization);
        this.business.setOnlineShoppingStoreOrganization(onlineShoppingStoreOrganization);
        
        return this.business;
    }
    
}
