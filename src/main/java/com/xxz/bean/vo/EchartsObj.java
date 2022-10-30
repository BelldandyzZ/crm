package com.xxz.bean.vo;

public class EchartsObj {

    private Integer eId; //员工编号

    private String empName; //员工姓名

    private String backPrice; //回款金额

    private String preBackPrice; //待回款金额

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getBackPrice() {
        return backPrice;
    }

    public void setBackPrice(String backPrice) {
        this.backPrice = backPrice;
    }

    public String getPreBackPrice() {
        return preBackPrice;
    }

    public void setPreBackPrice(String preBackPrice) {
        this.preBackPrice = preBackPrice;
    }

    @Override
    public String toString() {
        return "EchartsObj{" +
                "eId=" + eId +
                ", empName='" + empName + '\'' +
                ", backPrice='" + backPrice + '\'' +
                ", preBackPrice='" + preBackPrice + '\'' +
                '}';
    }
}
