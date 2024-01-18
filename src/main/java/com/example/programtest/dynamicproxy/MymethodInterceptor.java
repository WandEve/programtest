package com.example.programtest.dynamicproxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @BelongsProject: programtest-main
 * @BelongsPackage: com.example.programtest.dynamicproxy
 * @Author: lining
 * @CreateTime: 2024-01-17  09:58
 * @Description: TODO
 * @Version: 1.0
 */
public class MymethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("目标类增强前");

        // 调用目标类方法
        Object result = proxy.invokeSuper(obj, args);

        System.out.println("目标类增强后");
        return result;
    }
}
