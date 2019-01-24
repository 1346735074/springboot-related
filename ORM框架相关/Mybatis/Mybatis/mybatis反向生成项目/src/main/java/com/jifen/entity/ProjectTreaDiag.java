package com.jifen.entity;

import java.math.BigDecimal;

public class ProjectTreaDiag {
    private Integer id;

    private String treaId;

    private String diagId;

    private Integer classification;

    private String projectNumber;

    private String projectName;

    private BigDecimal price;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTreaId() {
        return treaId;
    }

    public void setTreaId(String treaId) {
        this.treaId = treaId == null ? null : treaId.trim();
    }

    public String getDiagId() {
        return diagId;
    }

    public void setDiagId(String diagId) {
        this.diagId = diagId == null ? null : diagId.trim();
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber == null ? null : projectNumber.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}