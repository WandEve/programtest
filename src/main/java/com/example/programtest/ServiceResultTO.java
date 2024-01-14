package com.example.programtest;

import java.io.Serializable;

public class ServiceResultTO<T> implements Serializable {
    private static final long serialVersionUID = 123L;
    private Boolean sucess;
    private String message;
    private T data;

    public static ServiceResultTO<Boolean> buildSuccess(Boolean aFalse) {

        return null;
    }

    public static ServiceResultTO<Boolean> buildFailed(Boolean aFalse, String 执行失败) {
        return null;
    }

    public static Object buildFailed(String 系统错误) {
        return false;
    }
}
