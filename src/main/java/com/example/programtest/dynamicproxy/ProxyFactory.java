package com.example.programtest.dynamicproxy;


import com.example.programtest.daili.RealSubject;
import com.example.programtest.daili.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @BelongsProject: programtest-main
 * @BelongsPackage: com.example.programtest.dynamicproxy
 * @Author: lining
 * @CreateTime: 2024-01-15  15:51
 * @Description: TODO
 * @Version: 1.0
 */
public class ProxyFactory {
    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("计算开始时间");
                        //执行目标对象方法
                        method.invoke(target,args);
                        System.out.println("计算结束时间");
                        return null;
                    }
                }
        );
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.getClass());
        Subject subject = (Subject) new ProxyFactory(realSubject).getProxyInstance();
        System.out.println(subject.getClass());
        subject.request();
    }
}
