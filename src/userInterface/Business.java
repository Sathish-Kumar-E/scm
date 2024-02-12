/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userInterface;

/**
 *
 * @author sathi
 */

import business.person.PersonDirectory;
import business.organization.procurement.ProcurementOrganization;
import business.organization.production.ProductionOrganization;
import business.organization.commodityConveyance.CommodityConveyanceOrganization;
import business.organization.consumerFoodDistribution.ConsumerFoodDistributionOrganization;
import business.organization.onlineShoppingStore.OnlineShoppingStoreOrganization;

public class Business {
    
    private PersonDirectory personDirectory;
    private ProcurementOrganization procurementOrganization;
    private ProductionOrganization productionOrganization;
    private CommodityConveyanceOrganization commodityConveyanceOrganization;
    private ConsumerFoodDistributionOrganization consumerFoodDistributionOrganization;
    private OnlineShoppingStoreOrganization onlineShoppingStoreOrganization;
    
    public Business() {
        this.personDirectory = new PersonDirectory();
        this.procurementOrganization = new ProcurementOrganization();
        this.productionOrganization = new ProductionOrganization();
        this.commodityConveyanceOrganization = new CommodityConveyanceOrganization();
        this.consumerFoodDistributionOrganization = new ConsumerFoodDistributionOrganization();
        this.onlineShoppingStoreOrganization = new OnlineShoppingStoreOrganization();
    }
    
    public Business(PersonDirectory personDirectory, ProcurementOrganization procurementOrganization, ProductionOrganization productionOrganization, CommodityConveyanceOrganization commodityConveyanceOrganization, ConsumerFoodDistributionOrganization consumerFoodDistributionOrganization, OnlineShoppingStoreOrganization retailerOrganization) {
        this.personDirectory = personDirectory;
        this.procurementOrganization = procurementOrganization;
        this.productionOrganization = productionOrganization;
        this.commodityConveyanceOrganization = commodityConveyanceOrganization;
        this.consumerFoodDistributionOrganization = consumerFoodDistributionOrganization;
        this.onlineShoppingStoreOrganization = retailerOrganization;
    }
    
    public ConsumerFoodDistributionOrganization getConsumerFoodDistributionOrganization() {
        return consumerFoodDistributionOrganization;
    }
    
    public void setConsumerFoodDistributionOrganization(ConsumerFoodDistributionOrganization consumerFoodDistributionOrganization) {
        this.consumerFoodDistributionOrganization = consumerFoodDistributionOrganization;
    }

    public OnlineShoppingStoreOrganization getOnlineShoppingStoreOrganization() {
        return onlineShoppingStoreOrganization;
    }

    public void setOnlineShoppingStoreOrganization(OnlineShoppingStoreOrganization onlineShoppingStoreOrganization) {
        this.onlineShoppingStoreOrganization = onlineShoppingStoreOrganization;
    }
    
    public CommodityConveyanceOrganization getCommodityConveyanceOrganization() {
        return commodityConveyanceOrganization;
    }
    
    public void setCommodityConveyanceOrganization(CommodityConveyanceOrganization commodityConveyanceOrganization) {
        this.commodityConveyanceOrganization = commodityConveyanceOrganization;
    }
    
    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public ProcurementOrganization getProcurementOrganization() {
        return procurementOrganization;
    }

    public void setProcurementOrganization(ProcurementOrganization procurementOrganization) {
        this.procurementOrganization = procurementOrganization;
    }

    public ProductionOrganization getProductionOrganization() {
        return productionOrganization;
    }

    public void setProductionOrganization(ProductionOrganization productionOrganization) {
        this.productionOrganization = productionOrganization;
    }

    @Override
    public String toString() {
        return "Business{" + "personDirectory=" + personDirectory + ", procurementOrganization=" + procurementOrganization + ", productionOrganization=" + productionOrganization + ", commodityConveyanceOrganization=" + commodityConveyanceOrganization + ", consumerFoodDistributionOrganization=" + consumerFoodDistributionOrganization + ", onlineShoppingStoreOrganization=" + onlineShoppingStoreOrganization + '}';
    }
    
}
