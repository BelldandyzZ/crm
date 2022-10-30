package com.xxz.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override

    /**
     * 如果是异步请求，捕获全局异常之后则返回异步json信息
     * 如果不是异步请求，捕获异常之后携带错误信息跳转到错误页面
     * 有ResponseBody注解就是异步请求，否则就不是。
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {


        //首先判断是返回页面还是返回json，false默认返回页面
        boolean isReturnJson = false;
        if(handler instanceof HandlerMethod){
            HandlerMethod  handlerMethod = (HandlerMethod)handler;
            ResponseBody responseBody = handlerMethod.getMethod().getDeclaredAnnotation(ResponseBody.class);
            //方法上有ResponseBody注解则代表返回的是json
            if(responseBody != null) isReturnJson  = true;
        }

        //返回的是json则调用处理json的方法
        if(isReturnJson){
             jsonHandler(e,httpServletResponse);
        }
        //返回的是视图则调用处理视图的方法
        else{
            return viewHandler(e);
        }

        return null;
    }


    private ModelAndView viewHandler(Exception e) {
        //拦截的是系统异常，则不带任何信息直接跳转到错误页面
        ModelAndView mo = new ModelAndView();
        mo.addObject("msg","系统忙，请稍后再试.....");
        mo.setViewName("/error/error");

        //如果拦截的异常是自定义的异常，则执行if语句块带着自定义异常信息跳转到错误页面
        if(e instanceof AppException){
            AppException appException = (AppException) e;
            mo.addObject("code",appException.getCode());
            mo.addObject("msg",appException.getMsg());
        }
        return mo;

    }


    private void jsonHandler(Exception e, HttpServletResponse response) {
        //拦截的是系统异常，则返回默认信息
        AsyncResp asyncResp = AsyncResp.error(500,"系统忙，请稍后再试");

        //拦截的是自定义异常，则返回自定义信息
        if(e instanceof AppException){
            AppException appException = (AppException) e;
            asyncResp.setCode(appException.getCode());
            asyncResp.setMsg(appException.getMsg());
        }

        //设置好asyncResp对象之后通过流写到前端
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(asyncResp);
            writer.write(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(writer != null){
                writer.flush();
                writer.close();
            }
        }

    }
}
