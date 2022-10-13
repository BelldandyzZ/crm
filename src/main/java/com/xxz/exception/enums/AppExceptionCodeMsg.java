package com.xxz.exception.enums;

/**
 * 抛出自定义异常所需要的信息全部统一写在这一个类中集中管理
 */
public enum  AppExceptionCodeMsg {


    INSUFFICIENT_PERMISSION(1002,"权限不足"),


    ;



    private int code;
    private String msg;

    AppExceptionCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


}
