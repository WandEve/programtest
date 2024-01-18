package com.example.programtest.daili;

/**
 * @BelongsProject: programtest-main
 * @BelongsPackage: com.example.programtest.daili
 * @Author: lining
 * @CreateTime: 2024-01-15  15:23
 * @Description: TODO
 * @Version: 1.0
 */
public class Proxy implements Subject{

    private RealSubject realSubject;

    public Proxy(RealSubject subject){
        this.realSubject = subject;
    }
    @Override
    public void request() {
        //执行代理逻辑
        System.out.println("卖房前");

        //执行目标对象方法
        realSubject.request();

        //执行代理逻辑
        System.out.println("卖房后");
    }

    public static void main(String[] args) {
        //被代理对象
        RealSubject subject = new RealSubject();

        //代理
        Proxy proxy = new Proxy(subject);

        //代理请求
        proxy.request();
    }
}
