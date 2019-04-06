/**
  * Copyright 2018 bejson.com 
  */
package com.example.xmlconvertjson.entity.Manifest_XML;
import com.example.xmlconvertjson.converter.XStreamYMDDateConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Date;

/**
 * Auto-generated: 2018-10-17 13:38:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ShipmentPackageInfo {

    private CartonID cartonID;
    private PackageShipmentMethod packageShipmentMethod;
    private String shipZone;
    private String shipSort;
    private String pointID;

    @XStreamConverter(value = XStreamYMDDateConverter.class)
    private Date commercialInvoiceDate;

    @XStreamConverter(value = XStreamYMDDateConverter.class)
    private Date scheduledDeliveryDate;
    private ShipmentPackageActualGrossWeight shipmentPackageActualGrossWeight;
    private ShipmentPackageDimensions shipmentPackageDimensions;
    private ShipmentPackageItemDetail shipmentPackageItemDetail;
    private String totalDeclaredValue;
    private String pkgHarmonizedTariffDescription;
    private ShipmentPackageItemQuantity shipmentPackageItemQuantity;
    public void setCartonID(CartonID cartonID) {
         this.cartonID = cartonID;
     }
     public CartonID getCartonID() {
         return cartonID;
     }

    public void setPackageShipmentMethod(PackageShipmentMethod packageShipmentMethod) {
         this.packageShipmentMethod = packageShipmentMethod;
     }
     public PackageShipmentMethod getPackageShipmentMethod() {
         return packageShipmentMethod;
     }

    public void setShipZone(String shipZone) {
         this.shipZone = shipZone;
     }
     public String getShipZone() {
         return shipZone;
     }

    public void setShipSort(String shipSort) {
         this.shipSort = shipSort;
     }
     public String getShipSort() {
         return shipSort;
     }

    public void setPointID(String pointID) {
         this.pointID = pointID;
     }
     public String getPointID() {
         return pointID;
     }

    public void setCommercialInvoiceDate(Date commercialInvoiceDate) {
         this.commercialInvoiceDate = commercialInvoiceDate;
     }
     public Date getCommercialInvoiceDate() {
         return commercialInvoiceDate;
     }

    public void setScheduledDeliveryDate(Date scheduledDeliveryDate) {
         this.scheduledDeliveryDate = scheduledDeliveryDate;
     }
     public Date getScheduledDeliveryDate() {
         return scheduledDeliveryDate;
     }

    public void setShipmentPackageActualGrossWeight(ShipmentPackageActualGrossWeight shipmentPackageActualGrossWeight) {
         this.shipmentPackageActualGrossWeight = shipmentPackageActualGrossWeight;
     }
     public ShipmentPackageActualGrossWeight getShipmentPackageActualGrossWeight() {
         return shipmentPackageActualGrossWeight;
     }

    public void setShipmentPackageDimensions(ShipmentPackageDimensions shipmentPackageDimensions) {
         this.shipmentPackageDimensions = shipmentPackageDimensions;
     }
     public ShipmentPackageDimensions getShipmentPackageDimensions() {
         return shipmentPackageDimensions;
     }

    public void setShipmentPackageItemDetail(ShipmentPackageItemDetail shipmentPackageItemDetail) {
         this.shipmentPackageItemDetail = shipmentPackageItemDetail;
     }
     public ShipmentPackageItemDetail getShipmentPackageItemDetail() {
         return shipmentPackageItemDetail;
     }

    public void setTotalDeclaredValue(String totalDeclaredValue) {
         this.totalDeclaredValue = totalDeclaredValue;
     }
     public String getTotalDeclaredValue() {
         return totalDeclaredValue;
     }

    public void setPkgHarmonizedTariffDescription(String pkgHarmonizedTariffDescription) {
         this.pkgHarmonizedTariffDescription = pkgHarmonizedTariffDescription;
     }
     public String getPkgHarmonizedTariffDescription() {
         return pkgHarmonizedTariffDescription;
     }

    public void setShipmentPackageItemQuantity(ShipmentPackageItemQuantity shipmentPackageItemQuantity) {
         this.shipmentPackageItemQuantity = shipmentPackageItemQuantity;
     }
     public ShipmentPackageItemQuantity getShipmentPackageItemQuantity() {
         return shipmentPackageItemQuantity;
     }

}