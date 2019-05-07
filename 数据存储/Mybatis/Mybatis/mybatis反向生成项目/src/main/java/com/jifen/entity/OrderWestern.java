package com.jifen.entity;

import java.math.BigDecimal;

public class OrderWestern {
    private String onlyId;

    private String openId;

    private String audit;

    private String deploy;

    private String physician;

    private String vouch;

    private String dispensing;

    private BigDecimal totalMoney;

    private Integer state;

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

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit == null ? null : audit.trim();
    }

    public String getDeploy() {
        return deploy;
    }

    public void setDeploy(String deploy) {
        this.deploy = deploy == null ? null : deploy.trim();
    }

    public String getPhysician() {
        return physician;
    }

    public void setPhysician(String physician) {
        this.physician = physician == null ? null : physician.trim();
    }

    public String getVouch() {
        return vouch;
    }

    public void setVouch(String vouch) {
        this.vouch = vouch == null ? null : vouch.trim();
    }

    public String getDispensing() {
        return dispensing;
    }

    public void setDispensing(String dispensing) {
        this.dispensing = dispensing == null ? null : dispensing.trim();
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}