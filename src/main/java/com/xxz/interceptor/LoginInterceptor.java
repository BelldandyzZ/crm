package com.xxz.interceptor;

import com.xxz.bean.Employee;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Employee emp = (Employee) request.getSession().getAttribute("emp");

        if (emp == null) {
            response.sendRedirect(request.getContextPath());
            return false;
        }
        return true;
    }


}
