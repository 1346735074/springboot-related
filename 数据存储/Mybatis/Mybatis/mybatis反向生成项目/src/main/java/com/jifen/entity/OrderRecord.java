package com.jifen.entity;

import java.util.Date;

public class OrderRecord {
    private String onlyId;

    private String openId;

    private String orderSympId;

    private String orderDiagId;

    private String orderTreaId;

    private String orderMedId;

    private String name;

    private String sex;

    private Integer age;

    private String category;

    private String charge;

    private String history;

    private String phone;

    private String address;

    private String diagnose;

    private Date creationTime;

    private Integer status;

    public String getOnlyId() {
        return onlyId;
    }

    public void setOnlyId(String onlyId) {
        this.onlyId = onlyId == null ? null : onlyId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getOrderSympId() {
        return orderSympId;
    }

    public void setOrderSympId(String orderSympId) {
        this.orderSympId = orderSympId == null ? null : orderSympId.trim();
    }

    public String getOrderDiagId() {
        return orderDiagId;
    }

    public void setOrderDiagId(String orderDiagId) {
        this.orderDiagId = orderDiagId == null ? null : orderDiagId.trim();
    }

    public String getOrderTreaId() {
        return orderTreaId;
    }

    public void setOrderTreaId(String orderTreaId) {
        this.orderTreaId = orderTreaId == null ? null : orderTreaId.trim();
    }

    public String getOrderMedId() {
        return orderMedId;
    }

    public void setOrderMedId(String orderMedId) {
        this.orderMedId = orderMedId == null ? null : orderMedId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history == null ? null : history.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose == null ? null : diagnose.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}