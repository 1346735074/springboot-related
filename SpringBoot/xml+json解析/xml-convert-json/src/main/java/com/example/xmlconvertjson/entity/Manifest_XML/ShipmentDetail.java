/**
  * Copyright 2018 bejson.com 
  */
package com.example.xmlconvertjson.entity.Manifest_XML;

/**
 * Auto-generated: 2018-10-17 13:38:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ShipmentDetail {

    private String customerOrderNumber;
    private ConsigneeAddress consigneeAddress;
    private ShipmentCostInfo shipmentCostInfo;
    private ShipmentPackageInfo shipmentPackageInfo;
    private String preferredDeliveryTime;
    public void setCustomerOrderNumber(String customerOrderNumber) {
         this.customerOrderNumber = customerOrderNumber;
     }
     public String getCustomerOrderNumber() {
         return customerOrderNumber;
     }

    public void setConsigneeAddress(ConsigneeAddress consigneeAddress) {
         this.consigneeAddress = consigneeAddress;
     }
     public ConsigneeAddress getConsigneeAddress() {
         return consigneeAddress;
     }

    public void setShipmentCostInfo(ShipmentCostInfo shipmentCostInfo) {
         this.shipmentCostInfo = shipmentCostInfo;
     }
     public ShipmentCostInfo getShipmentCostInfo() {
         return shipmentCostInfo;
     }

    public void setShipmentPackageInfo(ShipmentPackageInfo shipmentPackageInfo) {
         this.shipmentPackageInfo = shipmentPackageInfo;
     }
     public ShipmentPackageInfo getShipmentPackageInfo() {
         return shipmentPackageInfo;
     }

    public void setPreferredDeliveryTime(String preferredDeliveryTime) {
         this.preferredDeliveryTime = preferredDeliveryTime;
     }
     public String getPreferredDeliveryTime() {
         return preferredDeliveryTime;
     }

}