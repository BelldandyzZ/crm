package com.xxz.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
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
public class Employee implements Serializable {

//    @ExcelProperty(value = "员工编号", index = 0)
    private Integer eId;
    @ExcelProperty(value = "员工姓名", index = 0)
    private String rename;
    @ExcelProperty(value = "员工账号", index = 1)
    private String eName;
    @ExcelProperty(value = "员工密码", index = 2)
    private String ePwd;
    @ExcelProperty(value = "出生年月", index = 3)
    private String eBirthday;
    @ExcelProperty(value = "毕业院校", index = 4)
    private String eSchool;
    @ExcelProperty(value = "所任职位", index = 5)
    private String eJob;
    @ExcelProperty(value = "入司时间", index = 6)
    private String eStartTime;
    @ExcelProperty(value = "社会职位", index = 7)
    private String eSocialPosition;
    @ExcelProperty(value = "员工荣誉", index = 8)
    private String eHonor;
    @ExcelProperty(value = "员工备注", index = 9)
    private String eRemark;

    private static final long serialVersionUID = 1L;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename == null ? null : rename.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getePwd() {
        return ePwd;
    }

    public void setePwd(String ePwd) {
        this.ePwd = ePwd == null ? null : ePwd.trim();
    }

    public String geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(String eBirthday) {
        this.eBirthday = eBirthday == null ? null : eBirthday.trim();
    }

    public String geteSchool() {
        return eSchool;
    }

    public void seteSchool(String eSchool) {
        this.eSchool = eSchool == null ? null : eSchool.trim();
    }

    public String geteJob() {
        return eJob;
    }

    public void seteJob(String eJob) {
        this.eJob = eJob == null ? null : eJob.trim();
    }

    public String geteStartTime() {
        return eStartTime;
    }

    public void seteStartTime(String eStartTime) {
        this.eStartTime = eStartTime == null ? null : eStartTime.trim();
    }

    public String geteSocialPosition() {
        return eSocialPosition;
    }

    public void seteSocialPosition(String eSocialPosition) {
        this.eSocialPosition = eSocialPosition == null ? null : eSocialPosition.trim();
    }

    public String geteHonor() {
        return eHonor;
    }

    public void seteHonor(String eHonor) {
        this.eHonor = eHonor == null ? null : eHonor.trim();
    }

    public String geteRemark() {
        return eRemark;
    }

    public void seteRemark(String eRemark) {
        this.eRemark = eRemark == null ? null : eRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eId=").append(eId);
        sb.append(", rename=").append(rename);
        sb.append(", eName=").append(eName);
        sb.append(", ePwd=").append(ePwd);
        sb.append(", eBirthday=").append(eBirthday);
        sb.append(", eSchool=").append(eSchool);
        sb.append(", eJob=").append(eJob);
        sb.append(", eStartTime=").append(eStartTime);
        sb.append(", eSocialPosition=").append(eSocialPosition);
        sb.append(", eHonor=").append(eHonor);
        sb.append(", eRemark=").append(eRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}