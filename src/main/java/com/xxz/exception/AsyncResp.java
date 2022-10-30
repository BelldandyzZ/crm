package com.xxz.exception;

/**
 * 异步请求数据返回类
 * @param <T>
 */
public class AsyncResp<T> {

    public static final String ADD_SUCCESS = "添加成功";
    public static final String UPDATE_SUCCESS = "修改成功";

    private int code = 200;
    private String msg = "SUCCESS";
    private T data;

    public AsyncResp() {
    }

    /**
     *
     * @param code：服务端返回的状态码，成功为200
     * @param msg：状态信息
     * @param data:服务端返回的数据
     */
    public AsyncResp(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 异步请求成功之后调用的方法
     * @param data：需要返回的数据
     * @param <T>
     * @return
     */
    public static <T>  AsyncResp success(T data){
        return new AsyncResp(200,"SUCCESS",data);
    }

    public static <T>  AsyncResp success(String msg){
        return new AsyncResp(200,msg,null);
    }

    /**
     * 步请求成功之后调用的方法
     * @param data
     * @param msg：可以自定义返回的提示信息
     * @param <T>
     * @return
     */
    public static <T>  AsyncResp success(T data,String msg){
        return new AsyncResp(200,msg,data);
    }

    /**
     * 异步请求失败或者发生异常时调用的方法
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T>  AsyncResp error(int code,String msg){
        return new AsyncResp(code,msg,null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
