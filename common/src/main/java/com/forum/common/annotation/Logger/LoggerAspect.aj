package com.forum.common.annotation.Logger;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("@annotation(com.forum.common.annotation.Logger.MyLogger)")
    public void annotationPointCut() {

    }

    @Before(value = "annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLogger annotation = method.getAnnotation(MyLogger.class);

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = sign.getName();

        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);

        //System.out.print("打印：" + annotation.value() + " 前置日志");
    }
}
