package com.freshtxp.core.dal.domain;

import java.io.Serializable;
import java.util.Date;

public class PrizeLogDO implements Serializable {
    private Long id;

    private String memberId;

    private String openId;

    private String awardId;

    private String awardType;

    private String activityType;

    private String benefitGroup;

    private String attributes;

    private Date gmtCreate;

    private Date gmtModified;

    private String isDeleted;

    private Long version;

    private Long sellerId;

    private byte[] memberName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId == null ? null : awardId.trim();
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType == null ? null : awardType.trim();
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    public String getBenefitGroup() {
        return benefitGroup;
    }

    public void setBenefitGroup(String benefitGroup) {
        this.benefitGroup = benefitGroup == null ? null : benefitGroup.trim();
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes == null ? null : attributes.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public byte[] getMemberName() {
        return memberName;
    }

    public void setMemberName(byte[] memberName) {
        this.memberName = memberName;
    }
}