package com.xxz.bean;

import java.io.Serializable;

public class Contract implements Serializable {
    private Integer ctId;

    private String ctContractAmount;

    private String ctContractDocment;

    private String ctTenderAmount;

    private String ctTenderDocment;

    private Integer pId;

    private static final long serialVersionUID = 1L;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtContractAmount() {
        return ctContractAmount;
    }

    public void setCtContractAmount(String ctContractAmount) {
        this.ctContractAmount = ctContractAmount == null ? null : ctContractAmount.trim();
    }

    public String getCtContractDocment() {
        return ctContractDocment;
    }

    public void setCtContractDocment(String ctContractDocment) {
        this.ctContractDocment = ctContractDocment == null ? null : ctContractDocment.trim();
    }

    public String getCtTenderAmount() {
        return ctTenderAmount;
    }

    public void setCtTenderAmount(String ctTenderAmount) {
        this.ctTenderAmount = ctTenderAmount == null ? null : ctTenderAmount.trim();
    }

    public String getCtTenderDocment() {
        return ctTenderDocment;
    }

    public void setCtTenderDocment(String ctTenderDocment) {
        this.ctTenderDocment = ctTenderDocment == null ? null : ctTenderDocment.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ctId=").append(ctId);
        sb.append(", ctContractAmount=").append(ctContractAmount);
        sb.append(", ctContractDocment=").append(ctContractDocment);
        sb.append(", ctTenderAmount=").append(ctTenderAmount);
        sb.append(", ctTenderDocment=").append(ctTenderDocment);
        sb.append(", pId=").append(pId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}