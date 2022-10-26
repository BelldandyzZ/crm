package com.xxz.bean;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import lombok.Data;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.Serializable;

@Data
@ExcelIgnoreUnannotated
//行高全部设为40
@HeadRowHeight(value = 20)
//标题全部居中
@HeadStyle(horizontalAlignment = HorizontalAlignment.CENTER,borderRight = BorderStyle.MEDIUM,
        borderLeft =  BorderStyle.MEDIUM,
        borderTop = BorderStyle.MEDIUM,
        borderBottom = BorderStyle.MEDIUM )
//框线
@ColumnWidth(value = 20)
@ContentStyle( borderRight = BorderStyle.MEDIUM,
        borderLeft =  BorderStyle.MEDIUM,
        borderTop = BorderStyle.MEDIUM,
        borderBottom = BorderStyle.MEDIUM,
        fillPatternType = FillPatternType.SOLID_FOREGROUND,
        fillForegroundColor = 1,
        horizontalAlignment = HorizontalAlignment.CENTER,
        wrapped = true)
public class Interview implements Serializable {
//    @ExcelProperty(value = "访谈编号", index = 0)
    private Integer iId;
    @ExcelProperty(value = "客户单位", index = 0)
    private String iCompany;
//    @ExcelProperty(value = "客户人员编号", index = 1)
    private Integer cId;

    //业务设置列------------------------------------
    @ExcelProperty(value = "客户人员", index = 2)
    private String cRename;
    public String getcRename() {return cRename;}
    public void setcRename(String cRename) {this.cRename = cRename;}
    //-------------------------------------------
    @ExcelProperty(value = "拜访时间", index = 3)
    private String iVisitTime;
//    @ExcelProperty(value = "拜访类型编号", index = 4)
    private Integer pId;
    //业务设置列------------------------------------
    @ExcelProperty(value = "拜访类型", index = 5)
    private String pName;
    public String getpName() {return pName;}
    public void setpName(String pName) {this.pName = pName;}
    //-------------------------------------------
//    @ExcelProperty(value = "我方员工编号", index = 6)
    private Integer eId;
    //业务设置列------------------------------------
    @ExcelProperty(value = "我方人员", index = 7)
    private String eRename;
    public String geteRename() {return eRename;}
    public void seteRename(String eRename) {this.eRename = eRename;}
    //-------------------------------------------
    @ExcelProperty(value = "其他人员", index = 8)
    private String iOthers;
    @ExcelProperty(value = "内容摘要", index = 9)
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
        return "Interview{" +
                "iId=" + iId +
                ", iCompany='" + iCompany + '\'' +
                ", cId=" + cId +
                ", cRename='" + cRename + '\'' +
                ", iVisitTime='" + iVisitTime + '\'' +
                ", pId=" + pId +
                ", pName='" + pName + '\'' +
                ", eId=" + eId +
                ", eRename='" + eRename + '\'' +
                ", iOthers='" + iOthers + '\'' +
                ", iContent='" + iContent + '\'' +
                ", iNext='" + iNext + '\'' +
                '}';
    }
}