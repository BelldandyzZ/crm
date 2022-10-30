package com.xxz.bean;

import java.io.Serializable;

public class PaymentBack implements Serializable {
    private Integer pbId;

    private Integer pbMoney;

    private Integer pbOrder;

    private String pbTime;

    public String getPbTime() {
        return pbTime;
    }

    public void setPbTime(String pbTime) {
        this.pbTime = pbTime;
    }

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
        return "PaymentBack{" +
                "pbId=" + pbId +
                ", pbMoney=" + pbMoney +
                ", pbOrder=" + pbOrder +
                ", pbTime='" + pbTime + '\'' +
                '}';
    }
}