package com.xxz.bean;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelIgnoreUnannotated
public class Customer implements Serializable {
    @ExcelProperty(value = "客户编号", index = 0)
    private Integer cId;
    @ExcelProperty(value = "客户姓名", index = 1)
    private String cRename;
    @ExcelProperty(value = "单位名称", index = 2)
    private String cName;
    @ExcelProperty(value = "所在部门", index = 3)
    private String cDepart;
    @ExcelProperty(value = "单位类型", index = 4)
    private String cCieType;
    @ExcelProperty(value = "客户职务", index = 5)
    private String cJob;
    @ExcelProperty(value = "客户电话", index = 6)
    private String cTele;
    @ExcelProperty(value = "客户邮箱", index = 7)
    private String cPost;
    @ExcelProperty(value = "客户爱好", index = 8)
    private String cHobby;
    @ExcelProperty(value = "备注", index = 9)
    private String cRemark;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcRename() {
        return cRename;
    }

    public void setcRename(String cRename) {
        this.cRename = cRename == null ? null : cRename.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcDepart() {
        return cDepart;
    }

    public void setcDepart(String cDepart) {
        this.cDepart = cDepart == null ? null : cDepart.trim();
    }

    public String getcCieType() {
        return cCieType;
    }

    public void setcCieType(String cCieType) {
        this.cCieType = cCieType == null ? null : cCieType.trim();
    }

    public String getcJob() {
        return cJob;
    }

    public void setcJob(String cJob) {
        this.cJob = cJob == null ? null : cJob.trim();
    }

    public String getcTele() {
        return cTele;
    }

    public void setcTele(String cTele) {
        this.cTele = cTele == null ? null : cTele.trim();
    }

    public String getcPost() {
        return cPost;
    }

    public void setcPost(String cPost) {
        this.cPost = cPost == null ? null : cPost.trim();
    }

    public String getcHobby() {
        return cHobby;
    }

    public void setcHobby(String cHobby) {
        this.cHobby = cHobby == null ? null : cHobby.trim();
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark == null ? null : cRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", cRename=").append(cRename);
        sb.append(", cName=").append(cName);
        sb.append(", cDepart=").append(cDepart);
        sb.append(", cCieType=").append(cCieType);
        sb.append(", cJob=").append(cJob);
        sb.append(", cTele=").append(cTele);
        sb.append(", cPost=").append(cPost);
        sb.append(", cHobby=").append(cHobby);
        sb.append(", cRemark=").append(cRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}