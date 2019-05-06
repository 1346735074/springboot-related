/**
  * Copyright 2018 bejson.com 
  */
package com.example.xmlconvertjson.entity.Manifest_XML;
import com.example.xmlconvertjson.converter.XStreamYMDDateConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2018-10-17 13:38:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class ManifestHeader {

    private String warehouseLocationID;
    private String carrierInternalID;
    private String manifestNumber;
    private String carrierAccountID;
    private String carrierManifestID;
    //"shipmentDate":"2012-10-15T01:10:25",
    //com.thoughtworks.xstream.converters.ConversionException: Cannot parse date
    @XStreamConverter(value = XStreamYMDDateConverter.class)
    private Date shipmentDate;
    private String currencyCode;
    private ShipFromAddress shipFromAddress;

}