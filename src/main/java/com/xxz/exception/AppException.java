package com.xxz.exception;

import com.xxz.exception.enums.AppExceptionCodeMsg;

public class AppException extends RuntimeException {

    private int code ;
    private String  msg ;

    /**
     * 默认的异常信息
     */
    public AppException() {
        this.code = 500;
        this.msg = "服务器异常";
    }

    /**
     * 自定义异常调用这个方法，从枚举类中获取异常信息
     * @param appExceptionCodeMsg
     */
    public AppException(AppExceptionCodeMsg appExceptionCodeMsg) {
            this.code = appExceptionCodeMsg.getCode();
            this.msg  = appExceptionCodeMsg.getMsg();
    }

    /**
     * 这个方法是给系统异常用的，如空指针，下标越界等
     * @param code
     * @param msg
     */
    public AppException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
