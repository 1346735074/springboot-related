package com.jifen.entity;

import java.math.BigDecimal;

public class OrderWesternList {
    private String onlyId;

    private Integer drugId;

    private String drugName;

    private String specification;

    private String directions;

    private String dose;

    private String unit;

    private String logogram;

    private Integer days;

    private Integer gross;

    private String skuUnit;

    private BigDecimal price;

    private String source;

    private String comment;

    private Integer isTry;

    private String westId;

    public String getOnlyId() {
        return onlyId;
    }

    public void setOnlyId(String onlyId) {
        this.onlyId = onlyId == null ? null : onlyId.trim();
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions == null ? null : directions.trim();
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose == null ? null : dose.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getLogogram() {
        return logogram;
    }

    public void setLogogram(String logogram) {
        this.logogram = logogram == null ? null : logogram.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public String getSkuUnit() {
        return skuUnit;
    }

    public void setSkuUnit(String skuUnit) {
        this.skuUnit = skuUnit == null ? null : skuUnit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getIsTry() {
        return isTry;
    }

    public void setIsTry(Integer isTry) {
        this.isTry = isTry;
    }

    public String getWestId() {
        return westId;
    }

    public void setWestId(String westId) {
        this.westId = westId == null ? null : westId.trim();
    }
}