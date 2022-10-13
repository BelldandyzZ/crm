package com.xxz.aspect;

import com.xxz.annotations.Permission;
import com.xxz.exception.AppException;
import com.xxz.exception.enums.AppExceptionCodeMsg;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
@Aspect
public class PermissionProxy {

    @Resource
    private HttpSession session;


    /**
     * 拦截指定的注解
     * @return
     */
    @Around("@annotation(com.xxz.annotations.Permission)")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        System.out.println("PermissionProxy.around");

        Object result = null;

        //得到当前用户拥有的所有权限
        List<String> permissions = (List<String>)session.getAttribute("permissions");

        //没有权限抛出认证异常
        if(permissions == null || permissions.size() < 1){
            throw  new AppException(AppExceptionCodeMsg.INSUFFICIENT_PERMISSION);
        }

        //得到目标方法
        MethodSignature methodSignature =  (MethodSignature)point.getSignature();

        //得到方法上的注解
        Permission permission = methodSignature.getMethod().getDeclaredAnnotation(Permission.class);

        //判断注解上的权限码是否在用户拥有的权限中，不在则抛出异常
        if(!permissions.contains(permission.value())){
            throw  new AppException(AppExceptionCodeMsg.INSUFFICIENT_PERMISSION);
        }

        result = point.proceed();
        return  result;
    }

}
