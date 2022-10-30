package com.xxz.bean.vo;

public class MenuVo {
    private String id;
    private String pId;
    private String name;
    private boolean checked = false;

    @Override
    public String toString() {
        return "MenuVo{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public MenuVo() {
    }

    public MenuVo(String id, String pId, String name, boolean checked) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.checked = checked;
    }
}
