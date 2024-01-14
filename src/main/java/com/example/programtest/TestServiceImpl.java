package com.example.programtest;

import com.example.programtest.annotation.GlobalErrorCatch;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService{
    @Override
    @GlobalErrorCatch
    public ServiceResultTO<Boolean> test() {
//        try {
//            //此处书写代码逻辑
//            return ServiceResultTO.buildSuccess(Boolean.TRUE);
//        }catch (Exception e){
//            return ServiceResultTO.buildFailed(Boolean.FALSE, "执行失败");
//        }
        System.out.println("执行成功");
        boolean result = true;

        return ServiceResultTO.buildSuccess(result);
    }
}
