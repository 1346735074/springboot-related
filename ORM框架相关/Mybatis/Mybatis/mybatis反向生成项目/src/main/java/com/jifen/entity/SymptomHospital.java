package com.jifen.entity;

import java.util.Date;

public class SymptomHospital {
    private String onlyId;

    private String chiefInfo;

    private String historyOfPresent;

    private String previousHistory;

    private String allergicHistory;

    private Double animalHeat;

    private Double bpm;

    private Integer breathe;

    private Integer stature;

    private Double weight;

    private Double bmi;

    private Double actuatingPressure;

    private Double diastolicPressure;

    private String diagnose;

    private String examination;

    private String handlingSuggestion;

    private Date creationTime;

    public String getOnlyId() {
        return onlyId;
    }

    public void setOnlyId(String onlyId) {
        this.onlyId = onlyId == null ? null : onlyId.trim();
    }

    public String getChiefInfo() {
        return chiefInfo;
    }

    public void setChiefInfo(String chiefInfo) {
        this.chiefInfo = chiefInfo == null ? null : chiefInfo.trim();
    }

    public String getHistoryOfPresent() {
        return historyOfPresent;
    }

    public void setHistoryOfPresent(String historyOfPresent) {
        this.historyOfPresent = historyOfPresent == null ? null : historyOfPresent.trim();
    }

    public String getPreviousHistory() {
        return previousHistory;
    }

    public void setPreviousHistory(String previousHistory) {
        this.previousHistory = previousHistory == null ? null : previousHistory.trim();
    }

    public String getAllergicHistory() {
        return allergicHistory;
    }

    public void setAllergicHistory(String allergicHistory) {
        this.allergicHistory = allergicHistory == null ? null : allergicHistory.trim();
    }

    public Double getAnimalHeat() {
        return animalHeat;
    }

    public void setAnimalHeat(Double animalHeat) {
        this.animalHeat = animalHeat;
    }

    public Double getBpm() {
        return bpm;
    }

    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    public Integer getBreathe() {
        return breathe;
    }

    public void setBreathe(Integer breathe) {
        this.breathe = breathe;
    }

    public Integer getStature() {
        return stature;
    }

    public void setStature(Integer stature) {
        this.stature = stature;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getActuatingPressure() {
        return actuatingPressure;
    }

    public void setActuatingPressure(Double actuatingPressure) {
        this.actuatingPressure = actuatingPressure;
    }

    public Double getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(Double diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose == null ? null : diagnose.trim();
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination == null ? null : examination.trim();
    }

    public String getHandlingSuggestion() {
        return handlingSuggestion;
    }

    public void setHandlingSuggestion(String handlingSuggestion) {
        this.handlingSuggestion = handlingSuggestion == null ? null : handlingSuggestion.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}