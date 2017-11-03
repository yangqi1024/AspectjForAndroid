package com.example.gsz.buriedpoint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description ...
 *
 * @author gsz
 * @create 2017/11/1
 * @since V1.1.2
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface BuryPoint {
    String value() default "";
}
