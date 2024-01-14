package com.example.programtest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAdvice {
    //1.定义所有带有GlobalErrorCatch的注解的方法为pointcut
    @Pointcut("@annotation(com.example.programtest.annotation.GlobalErrorCatch)")
    private void globalCatch() {
    }

    //2.将around advice 作用于GlobalCatch(){}此PointCut
    @Around("globalCatch()")
    public Object handlerGlobalResult(ProceedingJoinPoint point) throws Throwable {
        try {
            System.out.println("执行前操作");
            return point.proceed();
        } catch (Exception e) {
            System.out.println("执行错误" + e);
            return ServiceResultTO.buildFailed("系统错误");
        }

    }

    @Autowired
    TestServiceImpl testService;
    @Bean
    private void fun(){
        testService.test();
    }
}
