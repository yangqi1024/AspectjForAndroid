package com.example.gsz.buriedpoint;

import android.util.Log;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Calendar;

/**
 * 埋点信息
 *
 * @author gsz
 * @create 2017/11/1
 * @since V1.1.2
 */
@Aspect
public class SingleClickAspect {
    static int TIME_TAG = R.id.click_time;
    public static final int MIN_CLICK_DELAY_TIME = 3000;

    @Around("execution(@com.example.gsz.buriedpoint.BuryPoint * *(..)) && @annotation(log)")//在连接点进行方法替换
    public void aroundMethod(ProceedingJoinPoint joinPoint,BuryPoint log) throws Throwable {
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
            }
        }
        if (view != null) {
            Object tag = view.getTag(TIME_TAG);
            long lastClickTime = ((tag != null) ? (long) tag : 0);
            Log.d("SingleClickAspect", "lastClickTime:" + lastClickTime);
            long currentTime = Calendar.getInstance().getTimeInMillis();
            //过滤掉600毫秒内的连续点击
            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                view.setTag(TIME_TAG, currentTime);
                Log.d("SingleClickAspect", "currentTime:" + currentTime);
                Log.d("SingleClickAspect", "tag:" + log.value());
                joinPoint.proceed();//执行原方法
            }
        }
    }
}
