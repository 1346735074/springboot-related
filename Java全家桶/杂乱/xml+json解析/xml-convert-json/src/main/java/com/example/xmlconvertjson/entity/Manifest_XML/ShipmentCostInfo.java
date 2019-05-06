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
public class ShipmentCostInfo {

    private String paymentMethod;
    private ValueOfGoods valueOfGoods;
    private CashOnDeliveryCharge CashOnDeliveryCharge;
    public void setPaymentMethod(String paymentMethod) {
         this.paymentMethod = paymentMethod;
     }
     public String getPaymentMethod() {
         return paymentMethod;
     }

    public void setValueOfGoods(ValueOfGoods valueOfGoods) {
         this.valueOfGoods = valueOfGoods;
     }
     public ValueOfGoods getValueOfGoods() {
         return valueOfGoods;
     }

    public void setCashOnDeliveryCharge(CashOnDeliveryCharge CashOnDeliveryCharge) {
         this.CashOnDeliveryCharge = CashOnDeliveryCharge;
     }
     public CashOnDeliveryCharge getCashOnDeliveryCharge() {
         return CashOnDeliveryCharge;
     }

}