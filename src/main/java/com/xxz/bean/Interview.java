package com.xxz.bean;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelIgnoreUnannotated
public class Interview implements Serializable {
    @ExcelProperty(value = "访谈编号", index = 0)
    private Integer iId;
    @ExcelProperty(value = "访谈单位", index = 1)
    private String iCompany;
    @ExcelProperty(value = "客户人员编号", index = 2)
    private Integer cId;

    //业务设置列------------------------------------
    @ExcelProperty(value = "客户姓名", index = 3)
    private String cRename;
    public String getcRename() {return cRename;}
    public void setcRename(String cRename) {this.cRename = cRename;}
    //-------------------------------------------
    @ExcelProperty(value = "拜访时间", index = 4)
    private String iVisitTime;
    @ExcelProperty(value = "拜访类型编号", index = 5)
    private Integer pId;
    //业务设置列------------------------------------
    @ExcelProperty(value = "拜访项目", index = 6)
    private String pName;
    public String getpName() {return pName;}
    public void setpName(String pName) {this.pName = pName;}
    //-------------------------------------------
    @ExcelProperty(value = "我方员工编号", index = 7)
    private Integer eId;
    //业务设置列------------------------------------
    @ExcelProperty(value = "我方员工姓名", index = 8)
    private String eRename;
    public String geteRename() {return eRename;}
    public void seteRename(String eRename) {this.eRename = eRename;}
    //-------------------------------------------
    @ExcelProperty(value = "其他参与成员", index = 9)
    private String iOthers;
    @ExcelProperty(value = "拜访内容", index = 10)
    private String iContent;
    @ExcelProperty(value = "下一步计划", index = 11)
    private String iNext;

    private static final long serialVersionUID = 1L;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getiCompany() {
        return iCompany;
    }

    public void setiCompany(String iCompany) {
        this.iCompany = iCompany == null ? null : iCompany.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getiVisitTime() {
        return iVisitTime;
    }

    public void setiVisitTime(String iVisitTime) {
        this.iVisitTime = iVisitTime == null ? null : iVisitTime.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getiOthers() {
        return iOthers;
    }

    public void setiOthers(String iOthers) {
        this.iOthers = iOthers == null ? null : iOthers.trim();
    }

    public String getiContent() {
        return iContent;
    }

    public void setiContent(String iContent) {
        this.iContent = iContent == null ? null : iContent.trim();
    }

    public String getiNext() {
        return iNext;
    }

    public void setiNext(String iNext) {
        this.iNext = iNext == null ? null : iNext.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iId=").append(iId);
        sb.append(", iCompany=").append(iCompany);
        sb.append(", cId=").append(cId);
        sb.append(", iVisitTime=").append(iVisitTime);
        sb.append(", pId=").append(pId);
        sb.append(", eId=").append(eId);
        sb.append(", iOthers=").append(iOthers);
        sb.append(", iContent=").append(iContent);
        sb.append(", iNext=").append(iNext);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}