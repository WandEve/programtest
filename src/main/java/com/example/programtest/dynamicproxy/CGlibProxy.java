package com.example.programtest.dynamicproxy;

import com.example.programtest.daili.RealSubject;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @BelongsProject: programtest-main
 * @BelongsPackage: com.example.programtest.dynamicproxy
 * @Author: lining
 * @CreateTime: 2024-01-17  16:12
 * @Description: TODO
 * @Version: 1.0
 */
public class CGlibProxy {
    public static void main(String[] args) {
        //创建Enhancer对象，类似与JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(RealSubject.class);
        //设置回调函数
        enhancer.setCallback(new MymethodInterceptor());
        //这里的creat方法就是正确创建代理类
        RealSubject proxyDog = (RealSubject) enhancer.create();
        //调用代理类的set方法
        proxyDog.request();
    }
}
