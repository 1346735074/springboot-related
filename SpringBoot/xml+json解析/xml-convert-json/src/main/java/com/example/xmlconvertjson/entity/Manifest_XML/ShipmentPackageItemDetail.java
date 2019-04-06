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
public class ShipmentPackageItemDetail {

    private String OrderingOrderId;
    private String itemID;
    private String itemTitle;
    private ItemQuantity itemQuantity;
    private ItemPriceInfo itemPriceInfo;
    private ItemWeight itemWeight;
    private String harmonizedTariffDescription;
    private String countryOfOrigin;
    private String ReplacementType;
    public void setOrderingOrderId(String OrderingOrderId) {
         this.OrderingOrderId = OrderingOrderId;
     }
     public String getOrderingOrderId() {
         return OrderingOrderId;
     }

    public void setItemID(String itemID) {
         this.itemID = itemID;
     }
     public String getItemID() {
         return itemID;
     }

    public void setItemTitle(String itemTitle) {
         this.itemTitle = itemTitle;
     }
     public String getItemTitle() {
         return itemTitle;
     }

    public void setItemQuantity(ItemQuantity itemQuantity) {
         this.itemQuantity = itemQuantity;
     }
     public ItemQuantity getItemQuantity() {
         return itemQuantity;
     }

    public void setItemPriceInfo(ItemPriceInfo itemPriceInfo) {
         this.itemPriceInfo = itemPriceInfo;
     }
     public ItemPriceInfo getItemPriceInfo() {
         return itemPriceInfo;
     }

    public void setItemWeight(ItemWeight itemWeight) {
         this.itemWeight = itemWeight;
     }
     public ItemWeight getItemWeight() {
         return itemWeight;
     }

    public void setHarmonizedTariffDescription(String harmonizedTariffDescription) {
         this.harmonizedTariffDescription = harmonizedTariffDescription;
     }
     public String getHarmonizedTariffDescription() {
         return harmonizedTariffDescription;
     }

    public void setCountryOfOrigin(String countryOfOrigin) {
         this.countryOfOrigin = countryOfOrigin;
     }
     public String getCountryOfOrigin() {
         return countryOfOrigin;
     }

    public void setReplacementType(String ReplacementType) {
         this.ReplacementType = ReplacementType;
     }
     public String getReplacementType() {
         return ReplacementType;
     }

}