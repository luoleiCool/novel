package com.luolei.novel.sys.common;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class AspectLog {

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.luolei.novel.sys.annotation.Action)")
    public void annotationPointCut() {};

    @Around("annotationPointCut()")
    public Object  logAround(ProceedingJoinPoint joinPoint)  throws Throwable{
        Object result;
        currentTime.set(System.currentTimeMillis());
        result = joinPoint.proceed();
        currentTime.remove();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        logService.save(getUsername(), StringUtils.getBrowser(request), StringUtils.getIp(request),joinPoint, log);
        return result;
    }
}
