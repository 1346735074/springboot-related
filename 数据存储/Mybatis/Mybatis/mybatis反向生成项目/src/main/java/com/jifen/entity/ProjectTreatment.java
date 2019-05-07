package com.jifen.entity;

import java.math.BigDecimal;

public class ProjectTreatment {
    private String onlyId;

    private String courseNumber;

    private String courseName;

    private Integer quantity;

    private Integer classify;

    private Integer doctor;

    private Integer frequency;

    private String wubiCode;

    private String alphabeticCode;

    private BigDecimal ceilingPrice;

    private BigDecimal totalPrices;

    private BigDecimal preferentialPrice;

    private BigDecimal deduct;

    private String explaination;

    private Integer isOpen;

    public String getOnlyId() {
        return onlyId;
    }

    public void setOnlyId(String onlyId) {
        this.onlyId = onlyId == null ? null : onlyId.trim();
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber == null ? null : courseNumber.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getWubiCode() {
        return wubiCode;
    }

    public void setWubiCode(String wubiCode) {
        this.wubiCode = wubiCode == null ? null : wubiCode.trim();
    }

    public String getAlphabeticCode() {
        return alphabeticCode;
    }

    public void setAlphabeticCode(String alphabeticCode) {
        this.alphabeticCode = alphabeticCode == null ? null : alphabeticCode.trim();
    }

    public BigDecimal getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(BigDecimal ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    public BigDecimal getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(BigDecimal totalPrices) {
        this.totalPrices = totalPrices;
    }

    public BigDecimal getPreferentialPrice() {
        return preferentialPrice;
    }

    public void setPreferentialPrice(BigDecimal preferentialPrice) {
        this.preferentialPrice = preferentialPrice;
    }

    public BigDecimal getDeduct() {
        return deduct;
    }

    public void setDeduct(BigDecimal deduct) {
        this.deduct = deduct;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination == null ? null : explaination.trim();
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }
}