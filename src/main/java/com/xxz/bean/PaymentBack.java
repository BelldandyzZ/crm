package com.xxz.bean;

import java.io.Serializable;

public class PaymentBack implements Serializable {
    private Integer pbId;

    private Integer pbMoney;

    private Integer pbOrder;

    private static final long serialVersionUID = 1L;

    public Integer getPbId() {
        return pbId;
    }

    public void setPbId(Integer pbId) {
        this.pbId = pbId;
    }

    public Integer getPbMoney() {
        return pbMoney;
    }

    public void setPbMoney(Integer pbMoney) {
        this.pbMoney = pbMoney;
    }

    public Integer getPbOrder() {
        return pbOrder;
    }

    public void setPbOrder(Integer pbOrder) {
        this.pbOrder = pbOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pbId=").append(pbId);
        sb.append(", pbMoney=").append(pbMoney);
        sb.append(", pbOrder=").append(pbOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}