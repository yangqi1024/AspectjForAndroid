package com.example.gsz.buriedpoint;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Description ...
 *
 * @author gsz
 * @create 2017/11/1
 * @since V1.1.2
 */
@Aspect
public class CheckLoginAspect {

    @Around("execution(@com.example.gsz.buriedpoint.CheckLogin * *(..)) && @annotation(log)")//在连接点进行方法替换
    public void aroundMethod(ProceedingJoinPoint joinPoint,CheckLogin log) throws Throwable {
        Log.d("SingleClickAspect","checkLogin="+log.value());
        if(log.value()){
            joinPoint.proceed();//执行原方法
        }else{
            Log.d("SingleClickAspect","请登录");
        }
    }
}
